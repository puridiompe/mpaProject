package com.puridiompe.mpa.dataaccess;

import com.puridiompe.mpa.business.general.dto.PermisoOperacionEspecialDto;

public interface PermisoOperacionEspecialDao {
	
	public PermisoOperacionEspecialDto getPermisoOperacionEspecialByVehiculo(String vehiculo);
}
