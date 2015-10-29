package com.puridiompe.mpa.business.general;

import java.util.List;

import com.puridiompe.mpa.business.general.dto.DeviceDto;
import com.puridiompe.mpa.common.security.exception.RegisteredPublicImeiException;

/**
 * 
 * @author Lucho
 *
 */

public interface GestionarDeviceBusiness {
	
	public DeviceDto getDeviceByImei(String imei);
	
	public void checkDeviceByImei(String imei) throws RegisteredPublicImeiException;
	
	public DeviceDto getDeviceByUsername(String username);

	public List<DeviceDto> getAll();	
	

}