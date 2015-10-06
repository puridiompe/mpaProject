package com.puridiompe.mpa.business.general;

import com.puridiompe.mpa.business.general.dto.CiudadanoDto;

public interface GestionarCiudadanoBusiness {

	public CiudadanoDto getCiudadano (String imei);
	public void setCiudadano(Integer dni, String apellidoPaterno, String apellidoMaterno, String nombres,
			String email, String imei);
}
