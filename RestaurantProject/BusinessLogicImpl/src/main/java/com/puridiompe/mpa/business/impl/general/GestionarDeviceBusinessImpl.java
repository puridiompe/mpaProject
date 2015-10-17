package com.puridiompe.mpa.business.impl.general;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.puridiompe.mpa.business.general.GestionarDeviceBusiness;
import com.puridiompe.mpa.business.general.dto.DeviceDto;
import com.puridiompe.mpa.common.security.exception.RegisteredPublicImeiException;
import com.puridiompe.mpa.dataaccess.DeviceDao;

/**
 * 
 * @author Lucho
 *
 */

@Service
public class GestionarDeviceBusinessImpl implements GestionarDeviceBusiness{

	@Autowired
	private DeviceDao deviceDao;
	
	@Override
	public DeviceDto getDeviceByImei(String imei) {		
		return deviceDao.getDeviceByImei(imei);
	}

	@Override
	public void checkDeviceByImei(String imei) throws RegisteredPublicImeiException {
		
		DeviceDto deviceDto = deviceDao.checkDeviceByImei(imei);
		
		if(deviceDto != null){
			throw new RegisteredPublicImeiException("Dispositivo está registrado en la minicipalidad");
		}
	}
	
	@Override
	public List<DeviceDto> getAll() {
		return deviceDao.findAll();
	}
	

}