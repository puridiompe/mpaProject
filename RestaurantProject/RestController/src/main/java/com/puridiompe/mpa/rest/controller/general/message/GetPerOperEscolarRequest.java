package com.puridiompe.mpa.rest.controller.general.message;

import com.puridiompe.mpa.business.general.dto.PermisoOperacionEscolarDto;
import com.puridiompe.mpa.rest.controller.message.RequestBody;

public class GetPerOperEscolarRequest extends RequestBody {

	PermisoOperacionEscolarDto permiso;

	public PermisoOperacionEscolarDto getPermiso() {
		return permiso;
	}

	public void setPermiso(PermisoOperacionEscolarDto permiso) {
		this.permiso = permiso;
	}
	
}
