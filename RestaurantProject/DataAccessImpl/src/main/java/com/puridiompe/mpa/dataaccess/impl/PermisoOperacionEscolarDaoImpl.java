package com.puridiompe.mpa.dataaccess.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.puridiompe.mpa.business.general.dto.PermisoOperacionEscolarDto;
import com.puridiompe.mpa.dataaccess.PermisoOperacionEscolarDao;
import com.puridiompe.mpa.sistran.domain.persistence.PermisoOperacionEscolar;
import com.puridiompe.mpa.sistran.repository.persistence.PermisoOperacionEscolarRepository;

@Component
public class PermisoOperacionEscolarDaoImpl implements
		PermisoOperacionEscolarDao {

	@Autowired
	private PermisoOperacionEscolarRepository PermisoEscolarRepository;
	
	@Override
	public PermisoOperacionEscolarDto getPermisoOperacionEspecialByVehiculo(
			String vehiculo) {
		
		PermisoOperacionEscolarDto PermisoEscolarObject = new PermisoOperacionEscolarDto();
		
		PermisoOperacionEscolar PermisoEscolar = PermisoEscolarRepository.findByVehiculo(vehiculo);
		
		if(PermisoEscolar != null){
			BeanUtils.copyProperties(PermisoEscolar, PermisoEscolarObject);
		}else{
			return null;
		}
		return PermisoEscolarObject;
	}

}
