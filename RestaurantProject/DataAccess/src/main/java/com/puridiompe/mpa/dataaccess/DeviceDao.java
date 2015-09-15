package com.puridiompe.mpa.dataaccess;

import java.util.List;

import com.puridiompe.mpa.business.general.dto.DeviceDto;

/**
 * 
 * @author Lucho
 *
 */

public interface DeviceDao {	
	
	public DeviceDto getDeviceByCodigo(String codigo);

	public List<DeviceDto> findAll();	

}