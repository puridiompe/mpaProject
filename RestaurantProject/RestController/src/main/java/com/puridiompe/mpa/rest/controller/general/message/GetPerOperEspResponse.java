package com.puridiompe.mpa.rest.controller.general.message;

import com.puridiompe.mpa.business.general.dto.PermisoOperacionEspecialDto;
import com.puridiompe.mpa.rest.controller.message.ResponseBody;

public class GetPerOperEspResponse extends ResponseBody{

	private PermisoOperacionEspecialDto permiso;

	/**
	 * @return the permiso
	 */
	public PermisoOperacionEspecialDto getPermiso() {
		return permiso;
	}

	/**
	 * @param permiso the permiso to set
	 */
	public void setPermiso(PermisoOperacionEspecialDto permiso) {
		this.permiso = permiso;
	}
}
