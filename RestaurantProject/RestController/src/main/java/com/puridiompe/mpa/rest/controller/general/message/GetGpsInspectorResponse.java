package com.puridiompe.mpa.rest.controller.general.message;

import java.util.List;

import com.puridiompe.mpa.business.general.dto.GpsInspectorDto;
import com.puridiompe.mpa.common.rest.message.ResponseBody;


/**
 * 
 * @author Lucho
 *
 */

public class GetGpsInspectorResponse extends ResponseBody{
	
	private List<GpsInspectorDto> gps;
	
	public List<GpsInspectorDto> getGpsInspectors(){
		return gps;
	}
	
	public void setGpsInspectors(List<GpsInspectorDto> gps){
		this.gps = gps;
	}

}