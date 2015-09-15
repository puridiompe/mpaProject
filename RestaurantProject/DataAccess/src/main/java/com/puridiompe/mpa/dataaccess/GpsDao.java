package com.puridiompe.mpa.dataaccess;

import java.util.List;

import com.puridiompe.mpa.business.general.dto.GpsDto;

/**
 * 
 * @author Lucho
 *
 */

public interface GpsDao {	
	
	public GpsDto getGpsByImei(String imei);

	public List<GpsDto> findAll();	

}