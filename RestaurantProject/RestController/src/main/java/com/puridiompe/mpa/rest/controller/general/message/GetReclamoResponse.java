package com.puridiompe.mpa.rest.controller.general.message;

import java.util.List;

import com.puridiompe.mpa.business.general.dto.ReclamoDto;
import com.puridiompe.mpa.common.rest.message.ResponseBody;

public class GetReclamoResponse extends ResponseBody{
	
	private ReclamoDto gps;

	public ReclamoDto getGps() {
		return gps;
	}

	public void setGps(ReclamoDto gps) {
		this.gps = gps;
	}
	
	private List<ReclamoDto> reclamosFrecuentes;
	
	public List<ReclamoDto> getReclamosFrecuentes(){
		return reclamosFrecuentes;
	}
	
	public void setReclamosFrecuentes(List<ReclamoDto> reclamosFrecuentes){
		this.reclamosFrecuentes = reclamosFrecuentes;
	}
	
}
