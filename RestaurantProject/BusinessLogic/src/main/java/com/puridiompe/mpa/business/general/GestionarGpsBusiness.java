package com.puridiompe.mpa.business.general;

import java.util.List;

import com.puridiompe.mpa.business.general.dto.GpsDto;
import com.puridiompe.mpa.business.general.dto.GpsInspectorDto;

/**
 * 
 * @author Lucho
 *
 */

public interface GestionarGpsBusiness {
	
	public boolean addGps(GpsDto gps);
	
	public GpsDto getLastGpsByImei(String imei);	
	
	public List<GpsDto> getGpsByImei(String imei);
	
	public List<GpsInspectorDto> getLastGpsInspector();

	public List<GpsDto> getAll();
	

}