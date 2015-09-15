package com.puridiompe.mpa.business.impl.general;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.puridiompe.mpa.business.general.GestionarDeviceBusiness;
import com.puridiompe.mpa.business.general.dto.DeviceDto;
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
	public DeviceDto getDeviceByCodigo(String codigo) {		
		return deviceDao.getDeviceByCodigo(codigo);
	}

	@Override
	public List<DeviceDto> getAll() {
		return deviceDao.findAll();
	}
	

}