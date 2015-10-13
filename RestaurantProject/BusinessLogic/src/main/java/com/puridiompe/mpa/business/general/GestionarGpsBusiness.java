package com.puridiompe.mpa.business.general;

import java.util.List;

import com.puridiompe.mpa.business.general.dto.GpsDto;
import com.puridiompe.mpa.business.general.dto.GpsInspectorDto;
import com.puridiompe.mpa.common.annotation.SafeMethod;

/**
 * 
 * @author Lucho
 *
 */

public interface GestionarGpsBusiness {
	
	public GpsDto addGps(GpsDto gps);
	
	//@SafeMethod
	public GpsDto addBatchGps(String username, List<GpsDto> gps);
	
	public GpsDto getLastGpsByImei(String imei);	
	
	public List<GpsDto> getGpsByImei(String imei);
	
	public List<GpsInspectorDto> getLastGpsInspector();

	public List<GpsDto> getAll();
	

}