package com.puridiompe.mpa.dataaccess;

import com.puridiompe.mpa.business.security.dto.PerfilDto;
//import com.puridiompe.mpa.business.general.dto.UsuarioDto;
import com.puridiompe.mpa.business.security.dto.UsuarioDto;
//
import com.puridiompe.mpa.common.security.SystemRole;


public interface UsuarioDao {

	public UsuarioDto getUsuarioByUsername(String username);
	
	public PerfilDto getPerfilByRol(SystemRole systemRol);
	
	public UsuarioDto validateUsuario(String username,String password);
	
	public Boolean setCurrentDevice(String username,String imei);
	
	public Boolean setLastLogin(String username);
	
}