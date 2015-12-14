package com.puridiompe.mpa.dataaccess.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.puridiompe.mpa.business.general.dto.ActaDto;
import com.puridiompe.mpa.business.general.dto.ResumenImagenDto;
import com.puridiompe.mpa.business.general.dto.UsuarioActaDto;
import com.puridiompe.mpa.common.type.Datetime;
import com.puridiompe.mpa.common.type.ImageType;
import com.puridiompe.mpa.common.util.DateUtil;
import com.puridiompe.mpa.dataaccess.ActaDao;
import com.puridiompe.mpa.movil.domain.persistence.Acta;
import com.puridiompe.mpa.movil.domain.persistence.Imagen;
import com.puridiompe.mpa.movil.domain.persistence.InfraccionFrecuente;
import com.puridiompe.mpa.movil.domain.persistence.Reclamo;
import com.puridiompe.mpa.movil.repository.file.FileRepository;
import com.puridiompe.mpa.movil.repository.persistence.ActaRepository;
import com.puridiompe.mpa.movil.repository.persistence.ImagenRepository;
import com.puridiompe.mpa.movil.repository.persistence.InfraccionFrecuenteRepository;
import com.puridiompe.mpa.movil.repository.persistence.ReclamoCiudadanoRepository;

@Component
public class ActaDaoImpl implements ActaDao {

	@Autowired
	private ActaRepository actaRepository;
	
	@Autowired
	private FileRepository fileRepository;
	
	@Autowired
	private ImagenRepository imagenRepository;
	
	@Autowired
	private InfraccionFrecuenteRepository infraccionFrecuenteRepository;
	
	@Autowired
	private ReclamoCiudadanoRepository reclamoCiudadanoRepository;
	
	@Override
	public ActaDto setActa(ActaDto actaRequest) {

		ActaDto actaDto =  new ActaDto();
		Acta acta = new Acta();
		
		acta.setUsername(actaRequest.getUsername());
		
		if (actaRequest.getNumAct() != null){
			acta.setNumAct(actaRequest.getNumAct());
		}
		else{
			String nexVal = reclamoCiudadanoRepository.nextValNumAct();
			acta.setNumAct(nexVal);
		}
		
		acta.setVehiculo(actaRequest.getVehiculo());
		acta.setDescripcion(actaRequest.getDescripcion());
		acta.setEstado(actaRequest.getEstado());
		acta.setFecCre(DateUtil.getCurrentDate());
		
		actaRepository.save(acta);
		
		Acta actaResponse = actaRepository.findByIdActa(acta.getIdActa());
		
		/**** Set Image ****/
		
		List<String> imagenesBase64 = actaRequest.getImagenesBase64();
		if ((imagenesBase64 != null) && (!imagenesBase64.isEmpty())) {

			int arraySize = imagenesBase64.size();

			Integer actaId = acta.getIdActa();

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

				imagen.setTipoEntidad(ImageType.ACTA.toString());
				imagen.setNombre(fileName);
				imagen.setTipo(fileType);
				imagen.setTamanho(fileSize);
				imagen.setFecCre(DateUtil.getCurrentDate());
				imagen.setIdPadre(actaId);

				imagenRepository.save(imagen);
			}
		}
		
		/**** end set Image ****/
		
		/**** get Resumen Image ****/
		
		List<Imagen> imagen = imagenRepository.findByidPadre(acta.getIdActa());
		
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
	
		/**** end Resumen Image ****/
		
		if(actaResponse != null){
			BeanUtils.copyProperties(actaResponse, actaDto);
			actaDto.setResumenImagen(resumenImagen);
			return actaDto;
		}else{
			return null;
		}
	}
	
	@Override
	public List<ActaDto> getActaByUsername(Pageable paging, String username){
		
		List<Acta> actas = actaRepository.findByUsername(username, paging);
		
		List<ActaDto> actaObjects = getActaObjects(actas);
		
		return actaObjects;
		
	}
	
	@Override
	public List<ActaDto> findAllActas(Pageable paging){
		
		List<Acta> actas = actaRepository.findAllActas(paging);
		
		List<ActaDto> actaObjects = getActaObjects(actas);
		
		return actaObjects;
		
	}
	
	private List<ActaDto> getActaObjects(List<Acta> actas) {

		List<ActaDto> actaObjects = new ArrayList<ActaDto>();

		if (actas != null && !actas.isEmpty()) {
			List<Integer> actaIds = new ArrayList<Integer>();

			for (Acta acta : actas) {
				actaIds.add(acta.getIdActa());
			}

			int imagenIdx = 0;
//			int comentarioIdx = 0;

			List<Imagen> imagenes = imagenRepository.findByReclamo(actaIds, "ACT", "2");

//			List<ReclamoComentario> comentarios = reclamoComentarioRepository.findByReclamo(reclamoIds, "2");

			for (Acta acta : actas) {
				ActaDto actaObject = new ActaDto();

				BeanUtils.copyProperties(acta, actaObject);

				ResumenImagenDto resumenImagen = new ResumenImagenDto();

				int cantImagenes = 0;

				for (int i = imagenIdx; i < imagenes.size(); i++) {
					Imagen imagen = imagenes.get(i);
					if (actaObject.getIdActa().equals(imagen.getIdPadre())) {
						resumenImagen.getPesoImagen()
								.add(Integer.toString(Math.round(imagen.getTamanho() / 1024)) + " KB");
						cantImagenes++;
						imagenIdx++;
					} else {
						break;
					}
				}

				resumenImagen.setNumeroImagenes(cantImagenes);

				actaObject.setResumenImagen(resumenImagen);

//				List<ReclamoComentarioDto> comentariosObject = new ArrayList<ReclamoComentarioDto>();
//
//				for (int j = comentarioIdx; j < comentarios.size(); j++) {
//					ReclamoComentario comentario = comentarios.get(j);
//
//					if (reclamoObject.getIdReclamo().equals(comentario.getIdReclamo())) {
//
//						ReclamoComentarioDto reclamoComentario = new ReclamoComentarioDto();
//						reclamoComentario.setComentario(comentario.getComentario());
//						reclamoComentario.setFecCre(new Datetime(comentario.getFecCre()));
//
//						comentariosObject.add(reclamoComentario);
//						comentarioIdx++;
//					} else {
//						break;
//					}
//				}
//				actaObject.setReclamoComentarios(comentariosObject);

				actaObjects.add(actaObject);
			}

		}

		return actaObjects;
	}

	public Integer getTotalActas (String username){
		
		return actaRepository.findTotalActas(username);
	}
	
	public Integer getAllTotalActas (){
		
		return actaRepository.findAllTotalActas();
	}
	

	@Transactional(value = "movilTransactionManager", readOnly = true)
	@Override
	public List<ActaDto> getInfraccionesFrecuentes() {
		List<ActaDto> infraccionesFrecuentesObject = new ArrayList<ActaDto>();
		List<InfraccionFrecuente> infraccionesFrecuentes = infraccionFrecuenteRepository.findAll();

		if (infraccionesFrecuentes != null && !infraccionesFrecuentes.isEmpty())
			for (int i = 0; i < infraccionesFrecuentes.size(); i++) {
				ActaDto actaDto = new ActaDto();
				BeanUtils.copyProperties(infraccionesFrecuentes.get(i), actaDto);
				infraccionesFrecuentesObject.add(actaDto);
			}
		else
			return null;

		return infraccionesFrecuentesObject;
	}
	
	
	@Transactional(value = "movilTransactionManager", readOnly = true)
	@Override
	public ActaDto getImagesByIdActa(Integer idActa) {
		
		List<Imagen> imagen = imagenRepository.findAllByTipoIdPadre("ACT",idActa);
		String imagenCodificada = new String();

		int imagenesSize = imagen.size();

		ActaDto actaDto = new ActaDto();
			
		for (int i = 0; i < imagenesSize; i++) {
			imagenCodificada = fileRepository.getBase64(imagen.get(i).getNombre());

			actaDto.getImagenesBase64().add(imagenCodificada);
		}
		
		return actaDto;
	
	}

	public UsuarioActaDto getNumeroActa(){
		
		UsuarioActaDto usuarioActa =  new UsuarioActaDto();
		
		String nexVal = reclamoCiudadanoRepository.nextValNumAct();
		
		usuarioActa.setFecha(new Datetime(DateUtil.getCurrentDate()));
		usuarioActa.setNumActa(nexVal);
		
		return usuarioActa;
	}
}


