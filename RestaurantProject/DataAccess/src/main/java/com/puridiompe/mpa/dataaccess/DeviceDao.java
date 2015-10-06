package com.puridiompe.mpa.dataaccess;

import java.util.List;

import com.puridiompe.mpa.business.general.dto.DeviceDto;

/**
 * 
 * @author Lucho
 *
 */

public interface DeviceDao {	
	
	public DeviceDto getDeviceByImei(String codigo);

	public DeviceDto checkDeviceByImei(String imei);
	
	public List<DeviceDto> findAll();	

}