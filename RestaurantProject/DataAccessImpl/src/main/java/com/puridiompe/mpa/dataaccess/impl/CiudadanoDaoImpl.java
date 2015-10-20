package com.puridiompe.mpa.dataaccess.impl;

import java.util.Date;
import java.util.List;

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
		Ciudadano ciudadano = ciudadanoRepository.findByImei(imei).get(0);
		
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
		List<Ciudadano> lista = ciudadanoRepository.findByImei(imei);
		Ciudadano dniExists = ciudadanoRepository.findByDni(dni);		
		Ciudadano imeiExists = null;
		
		if(lista.isEmpty() || lista.size() == 0){
			imeiExists = null;			
		}else{
			imeiExists = lista.get(0);
		}
		
		if(dniExists == null){
			fechaCreacion = new Date();
			ciudadano.setDni(dni);
			ciudadano.setApellidoPaterno(apellidoPaterno);
			ciudadano.setApellidoMaterno(apellidoMaterno);
			ciudadano.setNombres(nombres);
			ciudadano.setEmail(email);
			ciudadano.setImei(imei);
			ciudadano.setFechaCreacion(fechaCreacion);
			ciudadano.setFechaModificacion(new Date());
			
			ciudadanoRepository.save(ciudadano);
		}else{
			if(imeiExists != null){
				ciudadanoRepository.updateCiudadano(dni, apellidoPaterno, apellidoMaterno, nombres,
						email, new Date(), imei);	
			}else{
				ciudadanoRepository.updateCiudadano(dni, apellidoPaterno, apellidoMaterno, nombres,
						email, new Date(), imei);
			}
		}
	}

}
