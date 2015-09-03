package com.puridiompe.mpa.dataaccess.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.puridiompe.mpa.business.general.dto.PermisoOperacionEspecialDto;
import com.puridiompe.mpa.dataaccess.PermisoOperacionEspecialDao;
import com.puridiompe.mpa.sistran.domain.persistence.PermisoOperacionEspecial;
import com.puridiompe.mpa.sistran.repository.persistence.PermisoOperacionEspecialRepository;

@Component
public class PermisoOperacionEspecialDaoImpl implements
		PermisoOperacionEspecialDao {

	@Autowired
	private PermisoOperacionEspecialRepository PermisoEspecialRepository;
	
	@Transactional(value = "sistranTransactionManager", readOnly = true)
	@Override
	public PermisoOperacionEspecialDto getPermisoOperacionEspecialByVehiculo(
			String vehiculo) {
		
		PermisoOperacionEspecialDto PermisoEspecialObject = new PermisoOperacionEspecialDto();
		
		PermisoOperacionEspecial PermisoEspecial = PermisoEspecialRepository.findByVehiculo(vehiculo);
		
		if(PermisoEspecial != null){
			BeanUtils.copyProperties(PermisoEspecial, PermisoEspecialObject);
		}else{
			return null;
		}
		return PermisoEspecialObject;
	}

}
