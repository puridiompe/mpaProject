/**
 * 
 */
package com.puridiompe.mpa.business.security;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.puridiompe.mpa.business.general.dto.LoginHistorialDto;
import com.puridiompe.mpa.business.security.dto.UsuarioDto;

/**
 * @author
 *
 */
public interface GestionarUserDetailsBusiness extends UserDetailsService {

	public UsuarioDto getUsuario(String username);
	
	public UsuarioDto validateUsuario(String username,String password);
	
	public boolean setLastLogin(String username);
	
	public boolean setCurrentDevice(String username,String imei);
}
