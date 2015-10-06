package com.puridiompe.mpa.dataaccess.impl;

import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.puridiompe.mpa.business.general.dto.CiudadanoDto;
import com.puridiompe.mpa.dataaccess.CiudadanoDao;
import com.puridiompe.mpa.movil.domain.persistence.Ciudadano;
import com.puridiompe.mpa.movil.repository.persistence.CiudadanoRepository;

@Component
public class CiudadanoDaoImpl implements CiudadanoDao {

	@Autowired
	private CiudadanoRepository ciudadanoRepository;
	
	@Transactional(value = "movilTransactionManager")
	@Override
	public CiudadanoDto getCiudadano(String imei){
		
		CiudadanoDto objectCiudadano = new CiudadanoDto();
		Ciudadano ciudadano = ciudadanoRepository.findByImei(imei);
		
		if(ciudadano != null){
			BeanUtils.copyProperties(ciudadano, objectCiudadano);
		}else{
			return null;
		}
		
		return objectCiudadano;
	}
	
	@Transactional(value = "movilTransactionManager")
	@Override
	public void setCiudadano(Integer dni, String apellidoPaterno, String apellidoMaterno, String nombres,
			String email, String imei) {
		
		Date fechaCreacion = new Date();
		Ciudadano ciudadano = new Ciudadano();	
		Ciudadano ciudadanoExists = ciudadanoRepository.findByDni(dni);
		if(ciudadanoExists != null){
			fechaCreacion = ciudadanoExists.getFechaCreacion();
		}else{
			fechaCreacion = new Date();
//			ciudadanoRepository.updateCiudadano(apellidoPaterno, apellidoMaterno, nombres,
//					email, new Date(), dni);
		}
		ciudadano.setDni(dni);
		ciudadano.setApellidoPaterno(apellidoPaterno);
		ciudadano.setApellidoMaterno(apellidoMaterno);
		ciudadano.setNombres(nombres);
		ciudadano.setEmail(email);
		ciudadano.setImei(imei);
		ciudadano.setFechaCreacion(fechaCreacion);
		ciudadano.setFechaModificacion(new Date());
		
		ciudadanoRepository.save(ciudadano);
	}

}
