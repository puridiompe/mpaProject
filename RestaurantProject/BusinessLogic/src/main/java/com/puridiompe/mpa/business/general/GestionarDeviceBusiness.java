package com.puridiompe.mpa.business.general;

import java.util.List;

import com.puridiompe.mpa.business.general.dto.DeviceDto;

/**
 * 
 * @author Lucho
 *
 */

public interface GestionarDeviceBusiness {
	
	public DeviceDto getDeviceByCodigo(String codigo);	

	public List<DeviceDto> getAll();	
	

}