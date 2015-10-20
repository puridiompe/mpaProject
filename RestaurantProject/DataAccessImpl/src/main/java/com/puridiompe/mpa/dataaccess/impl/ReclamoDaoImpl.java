package com.puridiompe.mpa.dataaccess.impl;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.puridiompe.mpa.business.general.dto.ReclamoDto;
import com.puridiompe.mpa.dataaccess.ReclamoDao;
import com.puridiompe.mpa.movil.domain.persistence.Imagen;
import com.puridiompe.mpa.movil.domain.persistence.Reclamo;
import com.puridiompe.mpa.movil.domain.persistence.ReclamoFrecuente;
import com.puridiompe.mpa.movil.repository.file.FileRepository;
import com.puridiompe.mpa.movil.repository.persistence.ImagenRepository;
import com.puridiompe.mpa.movil.repository.persistence.ReclamoFrecuenteRepository;
import com.puridiompe.mpa.movil.repository.persistence.ReclamoRepository;

@Component
public class ReclamoDaoImpl implements ReclamoDao {

	@Autowired
	private ReclamoRepository reclamoRepository;
	
	@Autowired
	private ReclamoFrecuenteRepository reclamofrecuenteRepository;
	
	@Autowired
	private ImagenRepository imagenRepository;
	
	@Autowired
	private FileRepository fileRepository; 
	
	@Transactional(value = "movilTransactionManager")
	@Override
	public void saveReclamo(Integer dni, String descripcion, String vehiculo, List<String> imagenesBase64) {
		
		Reclamo reclamo =  new Reclamo();		
		
		reclamo.setDni(dni);
		reclamo.setDescripcion(descripcion);
		reclamo.setVehiculo(vehiculo);
		reclamo.setFechaCreacion(new Date());
		
		reclamoRepository.save(reclamo);
		
		if((imagenesBase64 != null) && (!imagenesBase64.isEmpty())){
			
			int arraySize = imagenesBase64.size();
			
			Integer reclamoId = reclamo.getIdReclamo();
			
			for(int pos = 0; pos < arraySize; pos++){
				
				String elementBase64 = imagenesBase64.get(pos);
				String fileType = elementBase64.substring(11, 14);
				String elementBase64toDecode = elementBase64.substring(22);
				
				String fileName = null;
				Integer fileSize = 0;
				
				synchronized (this)
				{
					fileName = String.valueOf(new Date().getTime()) + "." + fileType;
					
					fileSize = fileRepository.saveBase64(fileName, elementBase64toDecode);
				}
				
				Imagen imagen = new Imagen();				
				
				imagen.setTipoEntidad("REC");
				imagen.setNombre(fileName);
				imagen.setTipo(fileType);
				imagen.setTamanho(fileSize);
				imagen.setFechaCreacion(new Date());
				imagen.setIdPadre(reclamoId);
				
				imagenRepository.save(imagen);
			}
					
		}		
	}
	
	@Transactional(value = "movilTransactionManager", readOnly = true)
	@Override
	public List<ReclamoDto> getReclamosFrecuentes() {
		List<ReclamoDto> reclamosFrecuentesObject = new ArrayList<ReclamoDto>();
		List<ReclamoFrecuente> reclamosFrecuentes = reclamofrecuenteRepository.findAll();
		
		if (reclamosFrecuentes != null)
			for (int i=0 ; i<reclamosFrecuentes.size() ; i++){
				ReclamoDto reclamoDtoTmp = new ReclamoDto();
				BeanUtils.copyProperties(reclamosFrecuentes.get(i), reclamoDtoTmp);
				reclamosFrecuentesObject.add(reclamoDtoTmp);	
			}
		else return null;
		
		return reclamosFrecuentesObject;
	}
}
