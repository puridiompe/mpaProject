package com.puridiompe.mpa.dataaccess.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.puridiompe.mpa.business.general.dto.CiudadanoDto;
import com.puridiompe.mpa.business.general.dto.ImagenDto;
import com.puridiompe.mpa.business.general.dto.ReclamoDto;
import com.puridiompe.mpa.business.general.dto.ReclamosDto;
import com.puridiompe.mpa.business.general.dto.ResumenImagenDto;
import com.puridiompe.mpa.dataaccess.ReclamosDao;
import com.puridiompe.mpa.movil.domain.persistence.Ciudadano;
import com.puridiompe.mpa.movil.domain.persistence.Imagen;
import com.puridiompe.mpa.movil.domain.persistence.Reclamo;
import com.puridiompe.mpa.movil.repository.persistence.CiudadanoRepository;
import com.puridiompe.mpa.movil.repository.persistence.ImagenRepository;
import com.puridiompe.mpa.movil.repository.persistence.ReclamoRepository;

@Component
public class ReclamosDaoImpl implements ReclamosDao {

	@Autowired
	private ReclamoRepository reclamoRepository;
	
	@Autowired
	private CiudadanoRepository ciudadanoRepository;
	
	@Autowired
	private ImagenRepository imagenRepository;
	
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

}
