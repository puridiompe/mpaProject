package com.puridiompe.mpa.rest.controller.general.message;

import java.util.List;

import com.puridiompe.mpa.business.general.dto.GpsDto;
import com.puridiompe.mpa.common.rest.message.ResponseBody;


/**
 * 
 * @author Lucho
 *
 */

public class GetGpssResponse extends ResponseBody{
	
	private List<GpsDto> gps;
	
	public List<GpsDto> getGpss(){
		return gps;
	}
	
	public void setGpss(List<GpsDto> gps){
		this.gps = gps;
	}

}