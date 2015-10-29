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
		
		List<Reclamo> reclamo =  reclamoRepository.findAvailableByImei(imei,2); 		//En el futuro etiqueta 
		List<Ciudadano> ciudadanoAll =  ciudadanoRepository.findAllByDni(); //Aqui tus consultas
		List<Imagen> imagenAll =  imagenRepository.findAllByidPadre(2); 		//aqui tus consultas
		
		int contImagenes = 0;
		if(!reclamo.isEmpty()){
						
			for(int i = 0; i < reclamo.size(); i++){
				
				ReclamoDto objectReclamo = new ReclamoDto();
				BeanUtils.copyProperties(reclamo.get(i), objectReclamo);

				CiudadanoDto objectCiudadano = new CiudadanoDto();
				ResumenImagenDto resumenImagen = new ResumenImagenDto();

				for(int j = 0; j < ciudadanoAll.size(); j++ ){
					if(reclamo.get(i).getDni().equals(ciudadanoAll.get(j).getDni())){
						BeanUtils.copyProperties(ciudadanoAll.get(j), objectCiudadano);
						break;
					}
				}

				int numeroImagenes = 0;
				while(reclamo.get(i).getIdReclamo().equals(imagenAll.get(contImagenes).getIdPadre()) && contImagenes < imagenAll.size()){
					resumenImagen.getPesoImagen().add(Integer.toString(imagenAll.get(contImagenes).getTamanho()));
					numeroImagenes++;
					contImagenes++;
				}
				resumenImagen.setNumeroImagenes(numeroImagenes);
				
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
		

		List<Reclamo> reclamo =  reclamoRepository.findAllAvailable(2); //por etiqueta en el futuro
		List<Ciudadano> ciudadanoAll = ciudadanoRepository.findAllByDni();
		List<Imagen> imagenAll =  imagenRepository.findAllByidPadre(2);
		List<ReclamoComentario> reclamoComentarios =  reclamoComentarioRepository.findAllByiDReclamo(2);//luego etiqueta
		
		int contImagenes = 0;
		int contComentario = 0;
		if(!reclamo.isEmpty()){
						
			for(int i = 0; i < reclamo.size(); i++){
				
				ReclamoDto objectReclamo = new ReclamoDto();
				BeanUtils.copyProperties(reclamo.get(i), objectReclamo);

				CiudadanoDto objectCiudadano = new CiudadanoDto();
//				ImagenDto objectImagenDto = new ImagenDto();
				ResumenImagenDto resumenImagen = new ResumenImagenDto();

				for(int j = 0; j < ciudadanoAll.size(); j++){
					if(reclamo.get(i).getDni().equals(ciudadanoAll.get(j).getDni())){
						BeanUtils.copyProperties(ciudadanoAll.get(j), objectCiudadano);
						break;
					}
				}
				int numeroImagenes = 0;
				while(reclamo.get(i).getIdReclamo().equals(imagenAll.get(contImagenes).getIdPadre()) && contImagenes < imagenAll.size()){
					resumenImagen.getPesoImagen().add(Integer.toString(imagenAll.get(contImagenes).getTamanho()));
					numeroImagenes++;
					contImagenes++;
				}
				resumenImagen.setNumeroImagenes(numeroImagenes);
				
				List<String> arrayComentarios = new ArrayList<String>();
				while(reclamo.get(i).getIdReclamo().equals(reclamoComentarios.get(contComentario).getIdReclamo()) && contComentario < reclamoComentarios.size()){
					arrayComentarios.add(reclamoComentarios.get(contComentario).getComentario());
					contComentario++;
				}
				
//				for(int j = 0; j < imagenAll.size(); j++){
//					if(reclamo.get(i).getIdReclamo().equals(imagenAll.get(j).getIdPadre())){
//						resumenImagen.getPesoImagen().add(Integer.toString(imagenAll.get(j).getTamanho()));
//						numeroImagenes++;
//					}
//				}
				
//				for(int j = 0; j < reclamoComentarios.size(); j++){
//					if(reclamo.get(i).getIdReclamo().equals(reclamoComentarios.get(j).getIdReclamo())){
//						arrayComentarios.add(reclamoComentarios.get(j).getComentario());
//					}
//				}
//				List<ReclamoComentarioDto> objectReclamoComentario = new ArrayList<ReclamoComentarioDto>();
//				List<ReclamoComentario> reclamoComentarios =  reclamoComentarioRepository.findByiDReclamo(reclamo.get(i).getIdReclamo());				
				
//				List<String> arrayComentarios = new ArrayList<String>();
//				if(!reclamoComentarios.isEmpty() || reclamoComentarios != null){	
//					
//					for(int r = 0; r < reclamoComentarios.size(); r++){												
//						arrayComentarios.add(reclamoComentarios.get(r).getComentario());						
//					}
//				}
				
//				Ciudadano ciudadano = ciudadanoRepository.findByDni(reclamo.get(i).getDni());
//				BeanUtils.copyProperties(ciudadano, objectCiudadano);
				
//				List<Imagen> imagen = imagenRepository.findByidPadre(reclamo.get(i).getIdReclamo());
				
//
//				if(!imagen.isEmpty()){
//					
//					resumenImagen.setNumeroImagenes(imagen.size());
//					for(int j = 0; j < imagen.size(); j++){
//						resumenImagen.getPesoImagen().add(Integer.toString(imagen.get(j).getTamanho()));
//					}
//				}else{
//					resumenImagen.setNumeroImagenes(0);
//					resumenImagen.getPesoImagen().add("");
//				}
				
				
				objectReclamo.setReclamoComentarios(arrayComentarios);
				
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