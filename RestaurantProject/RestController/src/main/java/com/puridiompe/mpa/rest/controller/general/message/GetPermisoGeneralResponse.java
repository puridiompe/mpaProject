package com.puridiompe.mpa.rest.controller.general.message;

import com.puridiompe.mpa.business.general.dto.PermisoGeneralDto;
import com.puridiompe.mpa.rest.controller.message.ResponseBody;

public class GetPermisoGeneralResponse extends ResponseBody{

	PermisoGeneralDto permisoGeneral;
	
	public PermisoGeneralDto getPermisoGeneral() {
		return permisoGeneral;
	}

	public void setPermisoGeneral(PermisoGeneralDto permisoGeneral) {
		this.permisoGeneral = permisoGeneral;
	}
}
