package com.puridiompe.mpa.business.impl.general;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.puridiompe.mpa.business.general.GestionarPermisoGeneralBusiness;
import com.puridiompe.mpa.business.general.dto.PermisoGeneralDto;
import com.puridiompe.mpa.dataaccess.PermisoGeneralDao;

@Service
public class GestionarPermisoGeneralBusinessImpl implements
		GestionarPermisoGeneralBusiness {

	@Autowired
	PermisoGeneralDao  permisoGeneral;
	
	@Override
	public PermisoGeneralDto getPermisoGeneral(String placa) {
		
		return permisoGeneral.getPermisoGeneralByPlaca(placa);
	}

}
