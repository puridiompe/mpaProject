package com.puridiompe.mpa.business.impl.general;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.puridiompe.mpa.business.general.GestionarPermisoOperacionEspecialBusiness;
import com.puridiompe.mpa.business.general.dto.PermisoOperacionEspecialDto;
import com.puridiompe.mpa.dataaccess.PermisoOperacionEspecialDao;

@Service
public class GestionarPermisoOperacionEspecialImpl implements
		GestionarPermisoOperacionEspecialBusiness {

	@Autowired
	PermisoOperacionEspecialDao PermisoEspecial;
	
	@Override
	public PermisoOperacionEspecialDto getPermisoOperacionEspecial(String vehiculo) {
		
		return PermisoEspecial.getPermisoOperacionEspecialByVehiculo(vehiculo);
	}

}
