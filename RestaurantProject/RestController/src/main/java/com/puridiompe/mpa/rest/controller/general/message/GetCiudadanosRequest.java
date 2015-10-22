package com.puridiompe.mpa.rest.controller.general.message;

import java.util.List;

import com.puridiompe.mpa.business.general.dto.CiudadanoDto;
import com.puridiompe.mpa.common.rest.message.RequestBody;

public class GetCiudadanosRequest extends RequestBody{

	private List<CiudadanoDto> ciudadanos;

	public List<CiudadanoDto> getCiudadanos() {
		return ciudadanos;
	}

	public void getCiudadanos(List<CiudadanoDto> ciudadanos) {
		this.ciudadanos = ciudadanos;
	}
	
}
