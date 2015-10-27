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
import com.puridiompe.mpa.common.security.SecurityContextHelper;
import com.puridiompe.mpa.common.security.exception.SecurityException;
import com.puridiompe.mpa.common.type.ImageType;
import com.puridiompe.mpa.common.type.ReclamoState;
import com.puridiompe.mpa.common.util.DateUtil;
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
	public Integer saveReclamo(ReclamoDto request) throws SecurityException {
		
		String currentImei = SecurityContextHelper.getCurrentImei(); 
		Reclamo reclamo =  new Reclamo();
		Date fechaActual = DateUtil.getCurrentDate();
		
		if(request.getIdReclamo() != null){
			reclamo.setIdReclamo(request.getIdReclamo());
		}
		if(request.getNumRec() != null){
			reclamo.setNumRec(request.getNumRec());
		}
		reclamo.setDni(request.getDni());
		reclamo.setDescripcion(request.getDescripcion());
		reclamo.setVehiculo(request.getVehiculo());
		reclamo.setFecCre(fechaActual);
		reclamo.setFecMod(fechaActual);
		reclamo.setImei(currentImei);		
		reclamo.setEstado(request.getEstado());
		
		reclamoRepository.save(reclamo);
		Integer reclamoID = reclamo.getIdReclamo();

		
		List<String> imagenesBase64 = request.getImagenesBase64();
		if((imagenesBase64  != null) && (!imagenesBase64.isEmpty())){
			
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
				
				imagen.setTipoEntidad(ImageType.RECLAMO.toString());
				imagen.setNombre(fileName);
				imagen.setTipo(fileType);
				imagen.setTamanho(fileSize);
				imagen.setFecCre(new Date());				
				imagen.setIdPadre(reclamoId);
				
				imagenRepository.save(imagen);
			}					
		}
		
		return reclamoID;
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
	
	@Transactional(value = "movilTransactionManager", readOnly = true)
	@Override
	public Integer getLastDniByImei(String imei){
		List<Reclamo> lastReclamosByImei = reclamoRepository.findByImei(imei);
		
		if(lastReclamosByImei.isEmpty()){
			return null;
		}else{
			return lastReclamosByImei.get(0).getDni();
		}
		
	}
	
	@Transactional(value = "movilTransactionManager", readOnly = true)
	@Override
	public List<ReclamoDto> getAll(){
		List<Reclamo> reclamos = reclamoRepository.findAll();
		List<ReclamoDto> forResponse = new ArrayList<ReclamoDto>();
		
		if(reclamos.isEmpty()){
			return null;
		}else{
			for(int i = 0; i < reclamos.size(); i++){
				ReclamoDto reclamo = new ReclamoDto();
				BeanUtils.copyProperties(reclamos.get(i), reclamo);
				forResponse.add(reclamo);
			}
			return forResponse;
		}
		
	}
	
	@Transactional(value = "movilTransactionManager", readOnly = true)
	@Override
	public ReclamoDto getById(Integer idReclamo){
		
		Reclamo reclamo = reclamoRepository.findById(idReclamo);	 
		
		if(reclamo == null){
			return null;
		}else{			
			ReclamoDto reclamoDto = new ReclamoDto();
			BeanUtils.copyProperties(reclamo, reclamoDto);			
			
			return reclamoDto;
		}
		
	}
}
