package com.puridiompe.mpa.rest.controller.general.message;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.puridiompe.mpa.business.general.dto.PermisoOperacionEscolarDto;
import com.puridiompe.mpa.common.rest.message.ResponseBody;

@RestController
@RequestMapping("/transportes/permisoEscolar")
public class GetPerOperEscolarResponse extends ResponseBody {

	PermisoOperacionEscolarDto permiso;

	/**
	 * @return the permiso
	 */
	public PermisoOperacionEscolarDto getPermiso() {
		return permiso;
	}

	/**
	 * @param permiso the permiso to set
	 */
	public void setPermiso(PermisoOperacionEscolarDto permiso) {
		this.permiso = permiso;
	}
	
	
}
