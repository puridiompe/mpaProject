package com.puridiompe.mpa.business.general;

import java.util.List;

import com.puridiompe.mpa.business.exception.BusinessException;
import com.puridiompe.mpa.business.general.dto.CiudadanoDto;
import com.puridiompe.mpa.common.security.exception.SecurityException;

public interface GestionarCiudadanoBusiness {

	public CiudadanoDto getCiudadano (Integer dni);
	
	public void setCiudadano(Integer dni, String apellidoPaterno, String apellidoMaterno, String nombres,
			String email, String estado) throws BusinessException, SecurityException;
	
	public void setCiudadanoBatch(List<CiudadanoDto> ciudadanoArray);
}
