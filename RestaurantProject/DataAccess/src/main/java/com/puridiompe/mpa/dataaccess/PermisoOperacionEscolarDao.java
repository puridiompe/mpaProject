package com.puridiompe.mpa.dataaccess;

import com.puridiompe.mpa.business.general.dto.PermisoOperacionEscolarDto;

public interface PermisoOperacionEscolarDao {

	public PermisoOperacionEscolarDto getPermisoOperacionEspecialByVehiculo (String vehiculo);
}
