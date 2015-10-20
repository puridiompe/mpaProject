package com.puridiompe.mpa.rest.controller.general.message;

import java.util.List;

import com.puridiompe.mpa.business.general.dto.CiudadanoDto;
import com.puridiompe.mpa.common.rest.message.RequestBody;

public class GetCiudadanoArrayRequest extends RequestBody{

	private List<CiudadanoDto> ciudadanoArray;

	public List<CiudadanoDto> getCiudadanoArray() {
		return ciudadanoArray;
	}

	public void setCiuadadanoArray(List<CiudadanoDto> ciudadanoArray) {
		this.ciudadanoArray = ciudadanoArray;
	}
	
}
