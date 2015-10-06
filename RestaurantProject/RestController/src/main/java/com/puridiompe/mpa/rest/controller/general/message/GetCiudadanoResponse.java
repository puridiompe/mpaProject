package com.puridiompe.mpa.rest.controller.general.message;

import com.puridiompe.mpa.business.general.dto.CiudadanoDto;
import com.puridiompe.mpa.common.rest.message.ResponseBody;

public class GetCiudadanoResponse extends ResponseBody {

	private CiudadanoDto ciudadano;

	public CiudadanoDto getCiudadano() {
		return ciudadano;
	}

	public void setCiudadano(CiudadanoDto ciudadano) {
		this.ciudadano = ciudadano;
	}
	
}
