package com.puridiompe.mpa.rest.controller.general.message;

import com.puridiompe.mpa.business.general.dto.GpsDto;
import com.puridiompe.mpa.common.rest.message.RequestBody;

/**
 * 
 * @author Lucho
 *
 */

public class GetGpsRequest extends RequestBody{
	
	private GpsDto gps;
	
	public GpsDto getGps(){
		return gps;
	}
	
	public void setGps(GpsDto device){
		this.gps = device;
	}

}
