/**
 * 
 */
package com.puridiompe.mpa.dataaccess.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.puridiompe.mpa.business.general.dto.GpsDto;
import com.puridiompe.mpa.dataaccess.GpsDao;
import com.puridiompe.mpa.sistran.domain.persistence.Gps;
import com.puridiompe.mpa.sistran.repository.persistence.GpsRepository;

/**
 * @author Lucho
 *
 */

@Component
public class GpsDaoImpl implements GpsDao{
	
	@Autowired
	private GpsRepository gpsRepository;

	@Transactional(value = "sistranTransactionManager", readOnly = true)
	@Override
	public GpsDto getGpsByImei(String imei) {
		
		GpsDto gpsObject = new GpsDto();
		
		Gps gps = gpsRepository.findByImei(imei);
		
		if(gps != null){
			
			BeanUtils.copyProperties(gps, gpsObject);
			
			
		}else{
			return null;
		}
		
		return gpsObject;
	}
	
	@Transactional(value = "sistranTransanctionManager", readOnly = true)
	@Override
	public List<GpsDto> findAll() {
		
		List<GpsDto> gpsObject = new ArrayList<GpsDto>();
		
		List<Gps> gps = gpsRepository.findAll();
		
		if(gps != null){		
			
			for(int i = 0; i < gps.size(); i++ ){
				
				GpsDto gpsDtoTmp = new GpsDto();
				
				BeanUtils.copyProperties(gps.get(i), gpsDtoTmp);
				
				gpsObject.add(gpsDtoTmp);				
			}			
			
		}else{
			return null;
		}		
		
		return gpsObject;
	}
	

}