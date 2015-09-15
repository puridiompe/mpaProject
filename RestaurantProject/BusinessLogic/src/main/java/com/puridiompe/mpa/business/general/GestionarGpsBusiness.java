package com.puridiompe.mpa.business.general;

import java.util.List;

import com.puridiompe.mpa.business.general.dto.GpsDto;

/**
 * 
 * @author Lucho
 *
 */

public interface GestionarGpsBusiness {
	
	public GpsDto getGpsByImei(String imei);	

	public List<GpsDto> getAll();
	

}