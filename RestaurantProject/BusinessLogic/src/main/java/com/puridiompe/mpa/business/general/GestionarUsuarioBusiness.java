package com.puridiompe.mpa.business.general;

//import com.puridiompe.mpa.business.general.dto.UsuarioDto;
import com.puridiompe.mpa.business.security.dto.UsuarioDto;

public interface GestionarUsuarioBusiness {

	public UsuarioDto getUsuario(String username);
	
	public UsuarioDto validateUsuario(String username,String password);

}
