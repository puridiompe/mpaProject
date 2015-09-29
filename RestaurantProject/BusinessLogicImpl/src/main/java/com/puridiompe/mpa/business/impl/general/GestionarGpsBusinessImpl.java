package com.puridiompe.mpa.business.impl.general;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.type.ArrayType;
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
	public GpsDto addGps(GpsDto gps) {
		if(gps != null){
			
			return gpsDao.addGps(gps, new Long(0));
			
		}else{
			
			return null;
			
		}
	}	
	
	//Main method to save positions/inspectors
	@Override
	public GpsDto addBatchGps(String username, List<GpsDto> gps) {
		
		GpsDto toReturn = new GpsDto();
		
		if(gps != null){
			GpsInspectorDto previousGpsInspector = gpsDao.getLastByUsername(username);
			Date lastInspectorDate = new Date();
			Long lastInspectorTime = new Long(0);
			Integer arraySize = gps.size();
		
			//One member array - offline and online cases
			if(arraySize == 1){
				GpsDto toSave = gps.get(0);
				Long offlineTime = toSave.getOfflineTime();
				Date actualDate = new Date();
				Long timeToSave = actualDate.getTime();
			
				if(offlineTime == 0){	
				
					return gpsDao.addGps(toSave, timeToSave);
//					toReturn = gpsDao.addGps(toSave, timeToSave);
				
				}if(offlineTime  > 0 && previousGpsInspector != null){
					
					lastInspectorDate = previousGpsInspector.getDate();
					lastInspectorTime = lastInspectorDate.getTime();
					
					timeToSave = lastInspectorTime + offlineTime;				
				
					return gpsDao.addGps(toSave, timeToSave);
//					toReturn = gpsDao.addGps(toSave, timeToSave);
					
				}if(offlineTime  > 0 && previousGpsInspector == null){
					
					timeToSave = timeToSave - offlineTime;
					
					return gpsDao.addGps(toSave, timeToSave);
//					toReturn = gpsDao.addGps(toSave, timeToSave);
				}
			}
			//add in batch with last datetime found
			//cases: array with only members for batch save and with last one online
			//special case: init offline
			if(arraySize > 1){
				Long lastOfflineTime = gps.get(arraySize-1).getOfflineTime();
				Date actualDate = new Date();
				Long actualTime = actualDate.getTime();
				
				if(previousGpsInspector != null){
					lastInspectorDate = previousGpsInspector.getDate();
					lastInspectorTime = lastInspectorDate.getTime();				
				
					if(lastOfflineTime > 0){				
					
						return gpsDao.addBatchGps(username, gps, lastInspectorTime, 1);
					}
					if(lastOfflineTime == 0){				
					
						gpsDao.addBatchGps(username, gps, lastInspectorTime, 2);
					
						//fixed time to avoid synch problems, it could be new Date()
						actualTime = lastInspectorTime + (arraySize * gps.get(0).getOfflineTime());
						return gpsDao.addGps(gps.get(arraySize-1), actualTime);
					}	
				}if(previousGpsInspector == null){
					if(lastOfflineTime > 0){
					
						lastInspectorTime = actualTime - ((arraySize + 1) * gps.get(0).getOfflineTime());
					
						return gpsDao.addBatchGps(username, gps, lastInspectorTime, 1);
					
					}if(lastOfflineTime == 0){
					
						lastInspectorTime = actualTime - ((arraySize) * gps.get(0).getOfflineTime());					
						gpsDao.addBatchGps(username, gps, lastInspectorTime, 2);					
									
						return gpsDao.addGps(gps.get(arraySize-1), actualTime);
					
					}
				}
			}
		}else{
			return null;
		}
		return null;
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