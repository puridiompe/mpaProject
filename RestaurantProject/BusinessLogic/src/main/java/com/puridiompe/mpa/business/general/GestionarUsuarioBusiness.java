package com.puridiompe.mpa.business.general;

import com.puridiompe.mpa.business.general.dto.UsuarioDto;


public interface GestionarUsuarioBusiness {
	
	public UsuarioDto getUsuario(String idUsuario);
	public UsuarioDto validateUsuario(String idUsuario,String password);
	
}
