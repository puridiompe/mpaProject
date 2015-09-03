package com.puridiompe.mpa.business.impl.general;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.puridiompe.mpa.business.general.GestionarPermisoOperacionEscolarBusiness;
import com.puridiompe.mpa.business.general.dto.PermisoOperacionEscolarDto;
import com.puridiompe.mpa.dataaccess.PermisoOperacionEscolarDao;

@Service
public class GestionarPermisoOperacionEscolarBusinessImpl implements
		GestionarPermisoOperacionEscolarBusiness {

	@Autowired
	PermisoOperacionEscolarDao PermisoEscolar;
	
	@Override
	public PermisoOperacionEscolarDto getPermisoOperacionEscolar(
			String vehiculo) {
		
		return PermisoEscolar.getPermisoOperacionEspecialByVehiculo(vehiculo);
	}

}
