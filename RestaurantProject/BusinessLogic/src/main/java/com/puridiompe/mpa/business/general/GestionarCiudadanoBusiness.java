package com.puridiompe.mpa.business.general;

import com.puridiompe.mpa.business.exception.BusinessException;
import com.puridiompe.mpa.business.general.dto.CiudadanoDto;
import com.puridiompe.mpa.common.security.exception.SecurityException;

public interface GestionarCiudadanoBusiness {

	public CiudadanoDto getCiudadano (String imei);
	public void setCiudadano(Integer dni, String apellidoPaterno, String apellidoMaterno, String nombres,
			String email) throws BusinessException, SecurityException;
}
