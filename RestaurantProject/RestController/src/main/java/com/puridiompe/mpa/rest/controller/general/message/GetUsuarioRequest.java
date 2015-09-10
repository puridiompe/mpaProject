package com.puridiompe.mpa.rest.controller.general.message;

import com.puridiompe.mpa.business.general.dto.UsuarioDto;
import com.puridiompe.mpa.common.rest.message.RequestBody;

public class GetUsuarioRequest extends RequestBody {
	
	private UsuarioDto usuario;
	
	/**
	 * @return the usuario
	 */
	public UsuarioDto getUsuario() {
		return usuario;
	}
	
	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(UsuarioDto usuario) {
		this.usuario = usuario;
	}

}
