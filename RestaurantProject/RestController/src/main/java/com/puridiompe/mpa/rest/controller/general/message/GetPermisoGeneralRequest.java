package com.puridiompe.mpa.rest.controller.general.message;

import com.puridiompe.mpa.business.general.dto.PermisoGeneralDto;
import com.puridiompe.mpa.rest.controller.message.RequestBody;

public class GetPermisoGeneralRequest extends RequestBody{

	PermisoGeneralDto permisoGeneral;

	public PermisoGeneralDto getPermisoGeneral() {
		return permisoGeneral;
	}

	public void setPermisoGeneral(PermisoGeneralDto permisoGeneral) {
		this.permisoGeneral = permisoGeneral;
	}
}
