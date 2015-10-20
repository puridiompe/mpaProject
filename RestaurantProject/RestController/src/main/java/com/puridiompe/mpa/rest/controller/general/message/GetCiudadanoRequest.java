package com.puridiompe.mpa.rest.controller.general.message;


import com.puridiompe.mpa.business.general.dto.CiudadanoDto;
import com.puridiompe.mpa.common.rest.message.RequestBody;

public class GetCiudadanoRequest extends RequestBody{

	private CiudadanoDto ciudadano;

	public CiudadanoDto getCiudadano() {
		return ciudadano;
	}

	public void setCiuadadano(CiudadanoDto ciudadano) {
		this.ciudadano = ciudadano;
	}
	
}
