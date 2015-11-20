package com.puridiompe.mpa.dataaccess.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.puridiompe.mpa.business.general.dto.FilterDto;
import com.puridiompe.mpa.business.general.dto.ReclamoComentarioDto;
import com.puridiompe.mpa.business.general.dto.ReclamoDto;
import com.puridiompe.mpa.business.general.dto.ResumenImagenDto;
import com.puridiompe.mpa.common.security.SecurityContextHelper;
import com.puridiompe.mpa.common.security.exception.SecurityException;
import com.puridiompe.mpa.common.type.Datetime;
import com.puridiompe.mpa.common.type.ImageType;
import com.puridiompe.mpa.common.util.DateUtil;
import com.puridiompe.mpa.dataaccess.ReclamoDao;
import com.puridiompe.mpa.movil.domain.persistence.Imagen;
import com.puridiompe.mpa.movil.domain.persistence.Reclamo;
import com.puridiompe.mpa.movil.domain.persistence.ReclamoCiudadano;
import com.puridiompe.mpa.movil.domain.persistence.ReclamoComentario;
import com.puridiompe.mpa.movil.domain.persistence.ReclamoFrecuente;
import com.puridiompe.mpa.movil.repository.file.FileRepository;
import com.puridiompe.mpa.movil.repository.persistence.CiudadanoRepository;
import com.puridiompe.mpa.movil.repository.persistence.ImagenRepository;
import com.puridiompe.mpa.movil.repository.persistence.ReclamoCiudadanoRepository;
import com.puridiompe.mpa.movil.repository.persistence.ReclamoComentarioRepository;
import com.puridiompe.mpa.movil.repository.persistence.ReclamoFrecuenteRepository;
import com.puridiompe.mpa.movil.repository.persistence.ReclamoRepository;

@Component
public class ReclamoDaoImpl implements ReclamoDao {

	@Autowired
	private ReclamoRepository reclamoRepository;
	
	@Autowired
	private ReclamoCiudadanoRepository reclamoCiudadanoRepository;

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
		
		if(request.getNumRec() == null){
			reclamo.setFecCre(fechaActual);
			reclamo.setImei(currentImei);
			reclamo.setLatitud(request.getLatitud());
			reclamo.setLongitud(request.getLongitud());
		}else{
			Reclamo numRec = reclamoRepository.getImagesByNumRec(request.getNumRec());
			reclamo.setImei(numRec.getImei());
			reclamo.setFecCre(numRec.getFecCre());
			reclamo.setLatitud(numRec.getLatitud());
			reclamo.setLongitud(numRec.getLongitud());
		}		
		

		if (request.getIdReclamo() != null) {
			reclamo.setIdReclamo(request.getIdReclamo());
		}
		if (request.getNumRec() != null) {
			reclamo.setNumRec(request.getNumRec());
		}
		reclamo.setDni(request.getDni());
		reclamo.setDescripcion(request.getDescripcion());
		reclamo.setVehiculo(request.getVehiculo());		
		reclamo.setFecMod(fechaActual);		
		reclamo.setEstado(request.getEstadoReclamo());

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
			
			List<ReclamoComentario> tmp = reclamoComentarioRepository.findByiDReclamo(response.getIdReclamo());
			
			for (int i=0 ; i<tmp.size() ; i++){
				response.getReclamoComentarios().add(new ReclamoComentarioDto());
				response.getReclamoComentarios().get(i).setComentario(tmp.get(i).getComentario());
				response.getReclamoComentarios().get(i).setFecCre(new Datetime(tmp.get(i).getFecCre()));
			}
			
			//response.getReclamoComentarios().get(0).setFecCre(new Datetime(reclamoComentario.getFecCre()));
			return response;
		} else {
			return null;
		}
	}
	
	@Transactional(value = "movilTransactionManager", readOnly = true)
	@Override
	public List<ReclamoDto> getAllReclamos(Pageable paging, List<FilterDto> filter) {

		
//		StringBuilder sb = new StringBuilder();
		
//		for(int i = 0; i < filter.size(); i++){
//			if (filter.get(i).getEnabled() == true){
//				if(filter.get(i).getType() == "TEXT"){
//					sb.append("r.");
//					sb.append(filter.get(i).getModel());
//					sb.append(" = ");
//					sb.append(filter.get(i).getValue());
//					sb.append(" ");
//				}
//				if(filter.get(i).getType() == "CHECK"){
//					sb.append("r.");
//					sb.append(filter.get(i).getModel());
////					for(int j = 0; j = filter.get(i).getOptionList().get(0).getOptionList().size(); j++){
////						
////					}
//				}
//			}
//		}
		
		
//		Pageable paging = new PageRequest(2, 20, Sort.Direction.ASC, "idReclamo");

//		List<ReclamoCiudadano> reclamosPaging = reclamoRepository.findByEstado("2", paging);

		List<ReclamoCiudadano> reclamosPaging = reclamoCiudadanoRepository.findByEstado("2", paging);
		
		List<ReclamoDto> reclamoObjects = getReclamoObjects(reclamosPaging);

		return reclamoObjects;
	}
	
	@Transactional(value = "movilTransactionManager", readOnly = true)
	@Override
	public List<ReclamoDto> getReclamosByImei(String imei) {

//		Pageable paging = new PageRequest(2, 20, Sort.Direction.ASC, "idReclamo");

		List<ReclamoCiudadano> reclamosPaging = reclamoRepository.findAllByImei(imei);//, "2", paging);

		List<ReclamoDto> reclamoObjects = getReclamoObjects(reclamosPaging);

		return reclamoObjects;
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
			reclamoDto.setEstadoReclamo(reclamo.getEstado());
			reclamoDto.setCodigo(reclamo.getNumRec());
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
	public Integer countReclamosByImei(String imei){
		
		return reclamoRepository.countReclamosByImei(imei);
	}
	
	@Transactional(value = "movilTransactionManager", readOnly = true)
	@Override
	public Integer getTotalReclamos(){
		
		return reclamoRepository.findTotalReclmaos();
	}
	
	private List<ReclamoDto> getReclamoObjects(List<ReclamoCiudadano> reclamosCiudadano) {

		List<ReclamoDto> reclamoObjects = new ArrayList<ReclamoDto>();

		if (reclamosCiudadano != null && !reclamosCiudadano.isEmpty()) {
			List<Integer> reclamoIds = new ArrayList<Integer>();

			for (ReclamoCiudadano reclamo : reclamosCiudadano) {
				reclamoIds.add(reclamo.getIdReclamo());
			}

			int imagenIdx = 0;
			int comentarioIdx = 0;

			List<Imagen> imagenes = imagenRepository.findByReclamo(reclamoIds, "REC", "2");

			List<ReclamoComentario> comentarios = reclamoComentarioRepository.findByReclamo(reclamoIds, "2");

			for (ReclamoCiudadano reclamoCiudadano : reclamosCiudadano) {
				ReclamoDto reclamoObject = new ReclamoDto();

				BeanUtils.copyProperties(reclamoCiudadano, reclamoObject);

				ResumenImagenDto resumenImagen = new ResumenImagenDto();

				int cantImagenes = 0;

				for (int i = imagenIdx; i < imagenes.size(); i++) {
					Imagen imagen = imagenes.get(i);
					if (reclamoObject.getIdReclamo().equals(imagen.getIdPadre())) {
						resumenImagen.getPesoImagen()
								.add(Integer.toString(Math.round(imagen.getTamanho() / 1024)) + " KB");
						cantImagenes++;
						imagenIdx++;
					} else {
						break;
					}
				}

				resumenImagen.setNumeroImagenes(cantImagenes);

				reclamoObject.setResumenImagen(resumenImagen);

				List<ReclamoComentarioDto> comentariosObject = new ArrayList<ReclamoComentarioDto>();

				for (int j = comentarioIdx; j < comentarios.size(); j++) {
					ReclamoComentario comentario = comentarios.get(j);

					if (reclamoObject.getIdReclamo().equals(comentario.getIdReclamo())) {

						ReclamoComentarioDto reclamoComentario = new ReclamoComentarioDto();
						reclamoComentario.setComentario(comentario.getComentario());
						reclamoComentario.setFecCre(comentario.getFecCre());

						comentariosObject.add(reclamoComentario);
						comentarioIdx++;
					} else {
						break;
					}
				}
				reclamoObject.setReclamoComentarios(comentariosObject);

				reclamoObjects.add(reclamoObject);
			}

		}

		return reclamoObjects;
	}
}
