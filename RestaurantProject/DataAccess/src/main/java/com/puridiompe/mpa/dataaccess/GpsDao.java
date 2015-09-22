package com.puridiompe.mpa.dataaccess;

import java.util.List;

import com.puridiompe.mpa.business.general.dto.GpsDto;
import com.puridiompe.mpa.business.general.dto.GpsInspectorDto;

/**
 * 
 * @author Lucho
 *
 */

public interface GpsDao {	
	
	public GpsDto addGps(GpsDto gps);
	
	public GpsDto addBatchGps(List<GpsDto> gps);
	
	public List<GpsDto> getGpsByImei(String imei);
	
	public GpsDto getLastGpsByImei(String imei);
	
	public List<GpsInspectorDto> getLastPositions();

	public List<GpsDto> findAll();	

}