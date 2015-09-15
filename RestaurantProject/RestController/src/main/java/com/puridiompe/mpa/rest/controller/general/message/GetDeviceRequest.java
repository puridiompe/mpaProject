package com.puridiompe.mpa.rest.controller.general.message;

import com.puridiompe.mpa.business.general.dto.DeviceDto;
import com.puridiompe.mpa.common.rest.message.RequestBody;

/**
 * 
 * @author Lucho
 *
 */

public class GetDeviceRequest extends RequestBody{
	
	private DeviceDto device;
	
	public DeviceDto getDevice(){
		return device;
	}
	
	public void setDevice(DeviceDto device){
		this.device = device;
	}

}
