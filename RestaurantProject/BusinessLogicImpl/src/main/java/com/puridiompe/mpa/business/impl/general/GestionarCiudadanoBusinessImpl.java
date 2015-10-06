package com.puridiompe.mpa.business.impl.general;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.puridiompe.mpa.business.general.GestionarCiudadanoBusiness;
import com.puridiompe.mpa.business.general.dto.CiudadanoDto;
import com.puridiompe.mpa.dataaccess.CiudadanoDao;

@Service
public class GestionarCiudadanoBusinessImpl implements GestionarCiudadanoBusiness{

	@Autowired
	CiudadanoDao ciudadanoDao;
	
	@Override
	public CiudadanoDto getCiudadano(String imei){
		
		CiudadanoDto ciudadanoDto = ciudadanoDao.getCiudadano(imei);
		
		return ciudadanoDto;
	}
	
	@Override
	public void setCiudadano(Integer dni, String apellidoPaterno, String apellidoMaterno, String nombres,
			String email, String imei) {

		ciudadanoDao.setCiudadano(dni, apellidoPaterno, apellidoMaterno, nombres, email, imei);
	}

}
