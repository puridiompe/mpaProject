package com.puridiompe.mpa.dataaccess.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.puridiompe.mpa.business.general.dto.CiudadanoDto;
import com.puridiompe.mpa.business.general.dto.ImagenDto;
import com.puridiompe.mpa.business.general.dto.ReclamoComentarioDto;
import com.puridiompe.mpa.business.general.dto.ReclamoDto;
import com.puridiompe.mpa.business.general.dto.ReclamosDto;
import com.puridiompe.mpa.business.general.dto.ResumenImagenDto;
import com.puridiompe.mpa.common.security.SecurityContextHelper;
import com.puridiompe.mpa.common.security.exception.SecurityException;
import com.puridiompe.mpa.common.type.ImageType;
import com.puridiompe.mpa.common.util.DateUtil;
import com.puridiompe.mpa.dataaccess.ReclamoDao;
import com.puridiompe.mpa.movil.domain.persistence.Ciudadano;
import com.puridiompe.mpa.movil.domain.persistence.Imagen;
import com.puridiompe.mpa.movil.domain.persistence.Reclamo;
import com.puridiompe.mpa.movil.domain.persistence.ReclamoComentario;
import com.puridiompe.mpa.movil.domain.persistence.ReclamoFrecuente;
import com.puridiompe.mpa.movil.repository.file.FileRepository;
import com.puridiompe.mpa.movil.repository.persistence.CiudadanoRepository;
import com.puridiompe.mpa.movil.repository.persistence.ImagenRepository;
import com.puridiompe.mpa.movil.repository.persistence.ReclamoComentarioRepository;
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
	
	@Autowired
	private CiudadanoRepository ciudadanoRepository;
	
	@Autowired
	private ReclamoComentarioRepository reclamoComentarioRepository; 
	
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
	
	@Transactional(value = "movilTransactionManager")
	@Override
	public boolean saveReclamoComentario(ReclamoDto request) {
		
		if( (request.getReclamoComentarios() != null) && (!request.getReclamoComentarios().isEmpty())){
			for(int r = 0; r < request.getReclamoComentarios().size(); r++){
				ReclamoComentario reclamoComentario = new ReclamoComentario();
				reclamoComentario.setComentario(request.getReclamoComentarios().get(r));
				reclamoComentario.setIdReclamo(request.getIdReclamo());
				reclamoComentarioRepository.save(reclamoComentario);
			}
			return true;
		}else{
			return false;
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
	
	@Transactional(value = "movilTransactionManager", readOnly = true)
	@Override
	public ReclamosDto getReclamosByImei(String imei) {
		
		ReclamosDto objectReclamos = new ReclamosDto();
		
		List<Reclamo> reclamo =  reclamoRepository.findByImei(imei);
		
		if(!reclamo.isEmpty()){
						
			for(int i = 0; i < reclamo.size(); i++){
				
				ReclamoDto objectReclamo = new ReclamoDto();
				BeanUtils.copyProperties(reclamo.get(i), objectReclamo);

				CiudadanoDto objectCiudadano = new CiudadanoDto();
				Ciudadano ciudadano = ciudadanoRepository.findByDni(reclamo.get(i).getDni());
				BeanUtils.copyProperties(ciudadano, objectCiudadano);
				
				ImagenDto objectImagenDto = new ImagenDto();
				List<Imagen> imagen = imagenRepository.findByidPadre(reclamo.get(i).getIdReclamo());
				ResumenImagenDto resumenImagen = new ResumenImagenDto();

				if(!imagen.isEmpty()){
					
					resumenImagen.setNumeroImagenes(imagen.size());
					for(int j = 0; j < imagen.size(); j++){
						resumenImagen.getPesoImagen().add(Integer.toString(imagen.get(j).getTamanho()));
					}
				}else{
					resumenImagen.setNumeroImagenes(0);
					resumenImagen.getPesoImagen().add("");
				}
				
				objectReclamos.getListImagen().add(resumenImagen);
				objectReclamos.getListCiudadano().add(objectCiudadano);
				objectReclamos.getListReclamo().add(objectReclamo);
			}

		}else{
			return null;
		}
		
		return objectReclamos;
	}
	
	@Transactional(value = "movilTransactionManager", readOnly = true)
	@Override
	public ReclamosDto getAll() {
		
		ReclamosDto objectReclamos = new ReclamosDto();
		
		List<Reclamo> reclamo =  reclamoRepository.findAll();	
		
		if(!reclamo.isEmpty()){
						
			for(int i = 0; i < reclamo.size(); i++){
				
				ReclamoDto objectReclamo = new ReclamoDto();
				BeanUtils.copyProperties(reclamo.get(i), objectReclamo);

				CiudadanoDto objectCiudadano = new CiudadanoDto();
				Ciudadano ciudadano = ciudadanoRepository.findByDni(reclamo.get(i).getDni());
				BeanUtils.copyProperties(ciudadano, objectCiudadano);
				
				ImagenDto objectImagenDto = new ImagenDto();
				List<Imagen> imagen = imagenRepository.findByidPadre(reclamo.get(i).getIdReclamo());
				ResumenImagenDto resumenImagen = new ResumenImagenDto();
				
				List<ReclamoComentarioDto> objectReclamoComentario = new ArrayList<ReclamoComentarioDto>();
				List<ReclamoComentario> reclamoComentarios =  reclamoComentarioRepository.findByiDReclamo(reclamo.get(i).getIdReclamo());				
				
				List<String> arrayComentarios = new ArrayList<String>();
				if(!reclamoComentarios.isEmpty() || reclamoComentarios != null){	
					
					for(int r = 0; r < reclamoComentarios.size(); r++){												
						arrayComentarios.add(reclamoComentarios.get(r).getComentario());						
					}
				}
				objectReclamo.setReclamoComentarios(arrayComentarios);

				if(!imagen.isEmpty()){
					
					resumenImagen.setNumeroImagenes(imagen.size());
					for(int j = 0; j < imagen.size(); j++){
						resumenImagen.getPesoImagen().add(Integer.toString(imagen.get(j).getTamanho()));
					}
				}else{
					resumenImagen.setNumeroImagenes(0);
					resumenImagen.getPesoImagen().add("");
				}
				
				objectReclamos.getListImagen().add(resumenImagen);
				objectReclamos.getListCiudadano().add(objectCiudadano);
				objectReclamos.getListReclamo().add(objectReclamo);				
			}

		}else{
			return null;
		}
		
		return objectReclamos;
	}
}
