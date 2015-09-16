/**
 * 
 */
package com.puridiompe.mpa.rest.controller.general.message;

import java.util.List;

import com.puridiompe.mpa.business.general.dto.GpsDto;
import com.puridiompe.mpa.common.rest.message.ResponseBody;

/**
 * @author Lucho
 *
 */
public class GetGpsResponse extends ResponseBody{
	
	private GpsDto gps;
	
	public GpsDto getGps(){
		return gps;
	}
	
	public void setGps(GpsDto gps){
		this.gps = gps;
	}

}
