package com.puridiompe.mpa.dataaccess.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.puridiompe.mpa.business.general.dto.CiudadanoDto;
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
		Reclamo reclamo = new Reclamo();
		Date fechaActual = DateUtil.getCurrentDate();

		if (request.getIdReclamo() != null) {
			reclamo.setIdReclamo(request.getIdReclamo());
		}
		if (request.getNumRec() != null) {
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
		if ((imagenesBase64 != null) && (!imagenesBase64.isEmpty())) {

			int arraySize = imagenesBase64.size();

			Integer reclamoId = reclamo.getIdReclamo();

			for (int pos = 0; pos < arraySize; pos++) {

				String elementBase64 = imagenesBase64.get(pos);
				String fileType = elementBase64.substring(11, 14);
				String elementBase64toDecode = elementBase64.substring(22);

				String fileName = null;
				Integer fileSize = 0;

				synchronized (this) {
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
	public ReclamoDto saveReclamoComentario(ReclamoDto request) {

		ReclamoDto response = request;

		if ((request.getReclamoComentarios() != null) && (!request.getReclamoComentarios().isEmpty())) {			
			ReclamoComentario reclamoComentario = new ReclamoComentario();
			reclamoComentario.setComentario(request.getReclamoComentarios().get(0).getComentario());
			reclamoComentario.setIdReclamo(request.getIdReclamo());
			reclamoComentarioRepository.save(reclamoComentario);
			
			response.getReclamoComentarios().get(0).setFecCre(reclamoComentario.getFecCre());
			return response;
		} else {
			return null;
		}
	}

	@Transactional(value = "movilTransactionManager", readOnly = true)
	@Override
	public List<ReclamoDto> getReclamosFrecuentes() {
		List<ReclamoDto> reclamosFrecuentesObject = new ArrayList<ReclamoDto>();
		List<ReclamoFrecuente> reclamosFrecuentes = reclamofrecuenteRepository.findAll();

		if (reclamosFrecuentes != null)
			for (int i = 0; i < reclamosFrecuentes.size(); i++) {
				ReclamoDto reclamoDtoTmp = new ReclamoDto();
				BeanUtils.copyProperties(reclamosFrecuentes.get(i), reclamoDtoTmp);
				reclamosFrecuentesObject.add(reclamoDtoTmp);
			}
		else
			return null;

		return reclamosFrecuentesObject;
	}

	@Transactional(value = "movilTransactionManager", readOnly = true)
	@Override
	public Integer getLastDniByImei(String imei) {
		List<Reclamo> lastReclamosByImei = reclamoRepository.findByImei(imei);

		if (lastReclamosByImei.isEmpty()) {
			return null;
		} else {
			return lastReclamosByImei.get(0).getDni();
		}

	}

	@Transactional(value = "movilTransactionManager", readOnly = true)
	@Override
	public ReclamoDto getById(Integer idReclamo) {

		Reclamo reclamo = reclamoRepository.findById(idReclamo);
		List<Imagen> imagen = imagenRepository.findByidPadre(idReclamo);
		
		ResumenImagenDto resumenImagen =  new ResumenImagenDto();
		
		if(imagen == null){
			resumenImagen = null;			
		}else{
			List<String> pesos = new ArrayList<String>(); 
			for(int i = 0; i < imagen.size(); i++){
				pesos.add(Integer.toString(imagen.get(i).getTamanho() / 1024) + " KB");
			}
			resumenImagen.setNumeroImagenes(imagen.size());
			resumenImagen.setPesoImagen(pesos);
		}

		if (reclamo == null) {
			return null;
		} else {
			ReclamoDto reclamoDto = new ReclamoDto();
			BeanUtils.copyProperties(reclamo, reclamoDto);
			reclamoDto.setResumenImagen(resumenImagen);

			return reclamoDto;
		}

	}

	@Transactional(value = "movilTransactionManager", readOnly = true)
	@Override
	public ReclamoDto getImagesByNumRec(String numRec) {

		Reclamo reclamo = reclamoRepository.getImagesByNumRec(numRec);
		List<Imagen> imagen = imagenRepository.findByidPadre(reclamo.getIdReclamo());
		String imagenCodificada = new String();

		int imagenesSize = imagen.size();

		if (reclamo == null) {
			return null;
		} else {
			ReclamoDto reclamoDto = new ReclamoDto();
			BeanUtils.copyProperties(reclamo, reclamoDto);

			if (imagenesSize > 0) {
				for (int i = 0; i < imagenesSize; i++) {
					imagenCodificada = fileRepository.getBase64(imagen.get(i).getNombre());

					reclamoDto.getImagenesBase64().add(imagenCodificada);
				}
			}
			return reclamoDto;
		}
	}

	@Transactional(value = "movilTransactionManager", readOnly = true)
	@Override
	public ReclamosDto getReclamosByImei(String imei) {		

		List<Reclamo> reclamos = reclamoRepository.findAvailableByImei(imei, "2"); 		
		
		if(!reclamos.isEmpty()){
			
			ReclamosDto objectReclamos = new ReclamosDto();
			List<Ciudadano> ciudadanos = ciudadanoRepository.findByImei(imei, "2"); 
			List<Imagen> imagenes = imagenRepository.findAllByImei(imei, "2");
			List<ReclamoComentario> reclamoComentarios = reclamoComentarioRepository.findAllByRecImei(imei, "2");
			
			int comentarioIndex = 0;
			int imagenIndex = 0;
			
			for(int i = 0; i < reclamos.size(); i++){
				
				ReclamoDto reclamoObject = new ReclamoDto();
				CiudadanoDto ciudadanoObject = new CiudadanoDto();				
				
				BeanUtils.copyProperties(ciudadanos.get(i), ciudadanoObject);				
				
				List<ReclamoComentarioDto> comentarios = new ArrayList<ReclamoComentarioDto>();
				
				for(int j = comentarioIndex; j < reclamoComentarios.size(); j++){
					if(reclamos.get(i).getIdReclamo().equals(reclamoComentarios.get(j).getIdReclamo())){
						
						ReclamoComentarioDto reclamoComentario = new ReclamoComentarioDto();
						reclamoComentario.setComentario(reclamoComentarios.get(j).getComentario());
						reclamoComentario.setFecCre(reclamoComentarios.get(j).getFecCre());
						
						comentarios.add(reclamoComentario);
						comentarioIndex++;						
					}else{
						break;						
					}
				}
				reclamoObject.setReclamoComentarios(comentarios);
				BeanUtils.copyProperties(reclamos.get(i), reclamoObject);
				
				ResumenImagenDto resumenImagen = new ResumenImagenDto();
				
				int cantImagenes = 0;
				for(int k = imagenIndex; k < imagenes.size(); k++){
					if(reclamos.get(i).getIdReclamo().equals(imagenes.get(k).getIdPadre())){						
						resumenImagen.getPesoImagen().add(Integer.toString(imagenes.get(k).getTamanho() / 1024) + " KB");
						cantImagenes++;
						imagenIndex++;
					}else{
						break;						
					}
				}
				resumenImagen.setNumeroImagenes(cantImagenes);
				
				objectReclamos.getListReclamo().add(reclamoObject);
				objectReclamos.getListCiudadano().add(ciudadanoObject);
				objectReclamos.getListImagen().add(resumenImagen);
				
			}
			
			return objectReclamos;
		}else{
			return null;
		}
		
		
//		int contImagenes = 0;
//		if (!reclamo.isEmpty()) {
//
//			for (int i = 0; i < reclamo.size(); i++) {
//
//				ReclamoDto objectReclamo = new ReclamoDto();
//				BeanUtils.copyProperties(reclamo.get(i), objectReclamo);
//
//				CiudadanoDto objectCiudadano = new CiudadanoDto();
//				ResumenImagenDto resumenImagen = new ResumenImagenDto();
//
//				for (int j = 0; j < ciudadanoAll.size(); j++) {
//					if (reclamo.get(i).getDni().equals(ciudadanoAll.get(j).getDni())) {
//						BeanUtils.copyProperties(ciudadanoAll.get(j), objectCiudadano);
//						break;
//					}
//				}
//
//				int numeroImagenes = 0;
//				while (reclamo.get(i).getIdReclamo().equals(imagenAll.get(contImagenes).getIdPadre())
//						&& contImagenes < imagenAll.size()) {
//					resumenImagen.getPesoImagen().add(Integer.toString(imagenAll.get(contImagenes).getTamanho()));
//					numeroImagenes++;
//					contImagenes++;
//				}
//				resumenImagen.setNumeroImagenes(numeroImagenes);
//
//				objectReclamos.getListImagen().add(resumenImagen);
//				objectReclamos.getListCiudadano().add(objectCiudadano);
//				objectReclamos.getListReclamo().add(objectReclamo);
//			}
//
//		} else {
//			return null;
//		}
//
//		return objectReclamos;
	}

	@Transactional(value = "movilTransactionManager", readOnly = true)
	@Override
	public ReclamosDto getAll() {

		List<Reclamo> reclamos = reclamoRepository.findAllAvailable("2"); 		
		
		if(!reclamos.isEmpty()){
			
			ReclamosDto objectReclamos = new ReclamosDto();
			List<Ciudadano> ciudadanos = ciudadanoRepository.findByReclamo("2"); 
			List<Imagen> imagenes = imagenRepository.findAllByReclamo("2");
			List<ReclamoComentario> reclamoComentarios = reclamoComentarioRepository.findAllByReclamo("2");
			
			int comentarioIndex = 0;
			int imagenIndex = 0;
			
			for(int i = 0; i < reclamos.size(); i++){
				
				ReclamoDto reclamoObject = new ReclamoDto();
				CiudadanoDto ciudadanoObject = new CiudadanoDto();				
				
				BeanUtils.copyProperties(ciudadanos.get(i), ciudadanoObject);				
				
				List<ReclamoComentarioDto> comentarios = new ArrayList<ReclamoComentarioDto>();
				
				for(int j = comentarioIndex; j < reclamoComentarios.size(); j++){
					if(reclamos.get(i).getIdReclamo().equals(reclamoComentarios.get(j).getIdReclamo())){
						
						ReclamoComentarioDto reclamoComentario = new ReclamoComentarioDto();
						reclamoComentario.setComentario(reclamoComentarios.get(j).getComentario());
						reclamoComentario.setFecCre(reclamoComentarios.get(j).getFecCre());
						
						comentarios.add(reclamoComentario);
						comentarioIndex++;						
					}else{
						break;						
					}
				}
				reclamoObject.setReclamoComentarios(comentarios);
				BeanUtils.copyProperties(reclamos.get(i), reclamoObject);
				
				ResumenImagenDto resumenImagen = new ResumenImagenDto();
				
				int cantImagenes = 0;
				for(int k = imagenIndex; k < imagenes.size(); k++){
					if(reclamos.get(i).getIdReclamo().equals(imagenes.get(k).getIdPadre())){						
						resumenImagen.getPesoImagen().add(Integer.toString(imagenes.get(k).getTamanho() / 1024)+ " KB");
						cantImagenes++;
						imagenIndex++;
					}else{
						break;						
					}
				}
				resumenImagen.setNumeroImagenes(cantImagenes);
				
				objectReclamos.getListReclamo().add(reclamoObject);
				objectReclamos.getListCiudadano().add(ciudadanoObject);
				objectReclamos.getListImagen().add(resumenImagen);
				
			}
			
			return objectReclamos;
		}else{
			return null;
		}
		
		
		//   ===================== PASADO ===================== 
//		
//		ReclamosDto objectReclamos = new ReclamosDto();
//
//		List<Reclamo> reclamo = reclamoRepository.findAllAvailable("2"); 
//		List<Ciudadano> ciudadanoAll = ciudadanoRepository.findAllByDni();
//		List<Imagen> imagenAll = imagenRepository.findAllByidPadre("2");
//		List<ReclamoComentario> reclamoComentarios = reclamoComentarioRepository.findAllByiDReclamo("2");
//																											
//
//		int contImagenes = 0;
//		int contComentario = 0;
//		if (!reclamo.isEmpty()) {
//
//			for (int i = 0; i < reclamo.size(); i++) {
//
//				ReclamoDto objectReclamo = new ReclamoDto();
//				BeanUtils.copyProperties(reclamo.get(i), objectReclamo);
//
//				CiudadanoDto objectCiudadano = new CiudadanoDto();				
//				ResumenImagenDto resumenImagen = new ResumenImagenDto();
//
//				for (int j = 0; j < ciudadanoAll.size(); j++) {
//					if (reclamo.get(i).getDni().equals(ciudadanoAll.get(j).getDni())) {
//						BeanUtils.copyProperties(ciudadanoAll.get(j), objectCiudadano);
//						break;
//					}
//				}
//				int numeroImagenes = 0;
//				while (reclamo.get(i).getIdReclamo().equals(imagenAll.get(contImagenes).getIdPadre())
//						&& contImagenes < imagenAll.size()) {
//					resumenImagen.getPesoImagen().add(Integer.toString(imagenAll.get(contImagenes).getTamanho()));
//					numeroImagenes++;
//					contImagenes++;
//				}
//				resumenImagen.setNumeroImagenes(numeroImagenes);
//
//				List<String> arrayComentarios = new ArrayList<String>();				
//				for (int r = 0; r < reclamoComentarios.size() && contComentario < reclamoComentarios.size(); r++) {
//				
//					if (reclamo.get(i).getIdReclamo().equals(reclamoComentarios.get(contComentario).getIdReclamo())) {
//						arrayComentarios.add(reclamoComentarios.get(contComentario).getComentario());
//						contComentario++;
//					} else {
//						continue;
//					}
//				}
//				
//
//				objectReclamo.setReclamoComentarios(arrayComentarios);
//
//				objectReclamos.getListImagen().add(resumenImagen);
//				objectReclamos.getListCiudadano().add(objectCiudadano);
//				objectReclamos.getListReclamo().add(objectReclamo);
//			}
//
//		} else {
//			return null;
//		}
//
//		return objectReclamos;
	}
	
	@Transactional(value = "movilTransactionManager", readOnly = true)
	@Override
	public Integer countReclamosByImei(String imei){
		
		return reclamoRepository.countReclamosByImei(imei);
	} 
}
