package com.puridiompe.mpa.dataaccess;

import com.puridiompe.mpa.business.general.dto.PermisoGeneralDto;

public interface PermisoGeneralDao {

	public PermisoGeneralDto getPermisoGeneralByPlaca(String placa);
}
