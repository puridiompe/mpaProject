package com.puridiompe.mpa.rest.controller.general.message;

import com.puridiompe.mpa.business.general.dto.PermisoOperacionEspecialDto;
import com.puridiompe.mpa.business.general.dto.VehiculoDto;
import com.puridiompe.mpa.common.rest.message.RequestBody;

public class GetPerOperEspRequest extends RequestBody{

	private PermisoOperacionEspecialDto permiso;

	/**
	 * @return the 
	 */
	public PermisoOperacionEspecialDto getPermiso() {
		return permiso;
	}

	/**
	 * @param permiso the  to set
	 */
	public void setPermiso(PermisoOperacionEspecialDto permiso) {
		this.permiso = permiso;
	}
}
