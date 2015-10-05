package com.puridiompe.mpa.dataaccess.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.puridiompe.mpa.dataaccess.CiudadanoDao;
import com.puridiompe.mpa.movil.domain.persistence.Ciudadano;
import com.puridiompe.mpa.movil.repository.persistence.CiudadanoRepository;

@Component
public class CiudadanoDaoImpl implements CiudadanoDao {

	@Autowired
	private CiudadanoRepository ciudadanoRepository;
	
	@Transactional(value = "movilTransactionManager")
	@Override
	public void setCiudadano(Integer dni, String apellidoPaterno, String apellidoMaterno, String nombres,
			String email) {
		
		Ciudadano ciudadano = new Ciudadano();
		
		ciudadano.setDni(dni);
		ciudadano.setApellidoPaterno(apellidoPaterno);
		ciudadano.setApellidoMaterno(apellidoMaterno);
		ciudadano.setNombres(nombres);
		ciudadano.setEmail(email);
		
		ciudadanoRepository.save(ciudadano);

	}

}
