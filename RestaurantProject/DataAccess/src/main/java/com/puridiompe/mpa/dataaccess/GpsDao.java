package com.puridiompe.mpa.dataaccess;

import java.util.List;

import com.puridiompe.mpa.business.general.dto.GpsDto;
import com.puridiompe.mpa.business.general.dto.GpsInspectorDto;
import com.puridiompe.mpa.common.type.Datetime;

/**
 * 
 * @author Lucho
 *
 */

public interface GpsDao {	
	
	public GpsDto addGps(GpsDto gps);
	
	public GpsDto addBatchGps(String username, List<GpsDto> gps);
	
	public List<GpsDto> getGpsByImei(String imei);
	
	public GpsDto getLastGpsByImei(String imei);
	
	public List<GpsInspectorDto> getLastPositions();

	public List<GpsDto> findAll();	

}