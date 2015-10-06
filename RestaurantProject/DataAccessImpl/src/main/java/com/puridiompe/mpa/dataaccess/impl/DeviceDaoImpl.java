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

import com.puridiompe.mpa.business.general.dto.DeviceDto;
import com.puridiompe.mpa.dataaccess.DeviceDao;
import com.puridiompe.mpa.movil.domain.persistence.Device;
import com.puridiompe.mpa.movil.repository.persistence.DeviceRepository;

/**
 * @author Lucho
 *
 */

@Component
public class DeviceDaoImpl implements DeviceDao{
	
	@Autowired
	private DeviceRepository deviceRepository;

	@Transactional(value = "movilTransactionManager", readOnly = true)
	@Override
	public DeviceDto getDeviceByImei(String imei) {
		
		DeviceDto infraccionObject = new DeviceDto();
		
		Device infraccion = deviceRepository.findByImei(imei);
		
		if(infraccion != null){
			
			BeanUtils.copyProperties(infraccion, infraccionObject);
			
			
		}else{
			return null;
		}
		
		return infraccionObject;
	}
	
	@Transactional(value = "movilTransactionManager", readOnly = true)
	@Override
	public DeviceDto checkDeviceByImei(String imei){
		
		DeviceDto deviceObject = new DeviceDto();
		Device device = deviceRepository.findByImei(imei);
		
		if(device != null){
			BeanUtils.copyProperties(device, deviceObject);
		}else{
			return null;
		}
		
		return deviceObject;
	}
	
	@Transactional(value = "movilTransactionManager", readOnly = true)
	@Override
	public List<DeviceDto> findAll() {
		
		List<DeviceDto> devicesObject = new ArrayList<DeviceDto>();
		
		List<Device> devices = deviceRepository.findAll();
		
		if(devices != null){		
			
			for(int i = 0; i < devices.size(); i++ ){
				
				DeviceDto deviceDtoTmp = new DeviceDto();
				
				BeanUtils.copyProperties(devices.get(i), deviceDtoTmp);
				
				devicesObject.add(deviceDtoTmp);				
			}			
			
		}else{
			return null;
		}		
		
		return devicesObject;
	}
	

}