package com.puridiompe.mpa.rest.controller.general.message;

import java.util.List;

import com.puridiompe.mpa.business.general.dto.GpsDto;
import com.puridiompe.mpa.common.rest.message.RequestBody;

/**
 * 
 * @author Lucho
 *
 */

public class GetGpssRequest extends RequestBody{
	
	private List<GpsDto> gpss;
	
	public List<GpsDto> getGpss(){
		return gpss;
	}
	
	public void setGpss(List<GpsDto> gpss){
		this.gpss = gpss;
	}

}
