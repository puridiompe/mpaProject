package com.puridiompe.mpa.dataaccess;

import java.util.Date;
import java.util.List;

import com.puridiompe.mpa.business.general.dto.GpsDto;
import com.puridiompe.mpa.business.general.dto.GpsInspectorDto;

/**
 * 
 * @author Lucho
 *
 */

public interface GpsDao {	
	
	public GpsDto addGps(GpsDto gps, Long timeToSave);
	
	public GpsInspectorDto getLastByUsername(String username);
	
	public GpsDto addBatchGps(String username, List<GpsDto> gps, Long lastTime, Integer caseNumber);
	
	public List<GpsDto> getGpsByImei(String imei);
	
	public GpsDto getLastGpsByImei(String imei);
	
	public List<GpsInspectorDto> getLastPositions();

	public List<GpsDto> findAll();	

}