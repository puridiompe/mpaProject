package com.puridiompe.mpa.dataaccess;

//import com.puridiompe.mpa.business.general.dto.UsuarioDto;
import com.puridiompe.mpa.business.security.dto.UsuarioDto;
//


public interface UsuarioDao {

	public UsuarioDto getUsuarioByUsername(String username);
	
	public UsuarioDto validateUsuario(String username,String password);
}