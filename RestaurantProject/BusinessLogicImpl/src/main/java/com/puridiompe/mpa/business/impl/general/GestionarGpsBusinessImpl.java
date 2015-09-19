package com.puridiompe.mpa.business.impl.general;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.puridiompe.mpa.business.general.GestionarGpsBusiness;
import com.puridiompe.mpa.business.general.dto.GpsDto;
import com.puridiompe.mpa.business.general.dto.GpsInspectorDto;
import com.puridiompe.mpa.dataaccess.GpsDao;

/**
 * 
 * @author Lucho
 *
 */

@Service
public class GestionarGpsBusinessImpl implements GestionarGpsBusiness{

	@Autowired
	private GpsDao gpsDao;
	
	@Override
	public boolean addGps(GpsDto gps) {
		return gpsDao.addGps(gps);
	}
	
	@Override
	public GpsDto getLastGpsByImei(String imei){
		return gpsDao.getLastGpsByImei(imei);
	}
	
	@Override
	public List<GpsDto> getGpsByImei(String imei) {		
		return gpsDao.getGpsByImei(imei);
	}
	
	@Override
	public List<GpsInspectorDto> getLastGpsInspector(){
		return gpsDao.getLastPositions();
	}

	@Override
	public List<GpsDto> getAll() {
		return gpsDao.findAll();
	}

}