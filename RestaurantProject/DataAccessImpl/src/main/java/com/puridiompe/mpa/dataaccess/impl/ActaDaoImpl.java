package com.puridiompe.mpa.dataaccess.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.puridiompe.mpa.business.general.dto.ActaDto;
import com.puridiompe.mpa.common.type.ImageType;
import com.puridiompe.mpa.common.util.DateUtil;
import com.puridiompe.mpa.dataaccess.ActaDao;
import com.puridiompe.mpa.movil.domain.persistence.Acta;
import com.puridiompe.mpa.movil.domain.persistence.Imagen;
import com.puridiompe.mpa.movil.repository.file.FileRepository;
import com.puridiompe.mpa.movil.repository.persistence.ActaRepository;
import com.puridiompe.mpa.movil.repository.persistence.ImagenRepository;

@Component
public class ActaDaoImpl implements ActaDao {

	@Autowired
	private ActaRepository actaRepository;
	
	@Autowired
	private FileRepository fileRepository;
	
	@Autowired
	private ImagenRepository imagenRepository;
	
	@Override
	public ActaDto setActa(ActaDto actaRequest) {

		ActaDto actaDto =  new ActaDto();
		Acta acta = new Acta();
		
		acta.setUsername(actaRequest.getUsername());
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
		
		if(actaResponse != null){
			BeanUtils.copyProperties(actaResponse, actaDto);
			return actaDto;
		}else{
			return null;
		}
	}

}
