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
import com.puridiompe.mpa.sistran.domain.persistence.Device;
import com.puridiompe.mpa.sistran.repository.persistence.DeviceRepository;

/**
 * @author Lucho
 *
 */

@Component
public class DeviceDaoImpl implements DeviceDao{
	
	@Autowired
	private DeviceRepository deviceRepository;

	@Transactional(value = "sistranTransactionManager", readOnly = true)
	@Override
	public DeviceDto getDeviceByCodigo(String codigo) {
		
		DeviceDto infraccionObject = new DeviceDto();
		
		Device infraccion = deviceRepository.findByCodigo(codigo);
		
		if(infraccion != null){
			
			BeanUtils.copyProperties(infraccion, infraccionObject);
			
			
		}else{
			return null;
		}
		
		return infraccionObject;
	}
	
	@Transactional(value = "sistranTransanctionManager", readOnly = true)
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