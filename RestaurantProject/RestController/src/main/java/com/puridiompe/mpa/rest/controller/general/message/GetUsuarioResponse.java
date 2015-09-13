package com.puridiompe.mpa.rest.controller.general.message;

import com.puridiompe.mpa.business.security.dto.UsuarioDto;
import com.puridiompe.mpa.common.rest.message.ResponseBody;

public class GetUsuarioResponse extends ResponseBody  {
	
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
