package com.puridiompe.mpa.business.impl.general;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.puridiompe.mpa.business.general.GestionarCiudadanoBusiness;
import com.puridiompe.mpa.dataaccess.CiudadanoDao;

@Service
public class GestionarCiudadanoBusinessImpl implements GestionarCiudadanoBusiness{

	@Autowired
	CiudadanoDao ciudadanoDao;
	
	@Override
	public void setCiudadano(Integer dni, String apellidoPaterno, String apellidoMaterno, String nombres,
			String email) {
		
		ciudadanoDao.setCiudadano(dni, apellidoPaterno, apellidoMaterno, nombres, email);
	}

}
