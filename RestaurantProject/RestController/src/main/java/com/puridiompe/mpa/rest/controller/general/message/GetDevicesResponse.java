package com.puridiompe.mpa.rest.controller.general.message;

import java.util.List;

import com.puridiompe.mpa.business.general.dto.DeviceDto;
import com.puridiompe.mpa.common.rest.message.ResponseBody;


/**
 * 
 * @author Lucho
 *
 */

public class GetDevicesResponse extends ResponseBody{
	
	private List<DeviceDto> device;
	
	public List<DeviceDto> getDevices(){
		return device;
	}
	
	public void setDevices(List<DeviceDto> device){
		this.device = device;
	}

}