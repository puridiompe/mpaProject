/**
 * 
 */
package com.puridiompe.mpa.business.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.puridiompe.mpa.business.security.dto.UsuarioDto;

/**
 * @author
 *
 */
public interface GestionarUserDetailsBusiness extends UserDetailsService {
	
	public UserDetails createAnonymusUser();

	public boolean isAnonymusUser(String username);
	
	public UserDetails loadAnonymusUser(String username);

	public UsuarioDto getUsuario(String username);
	
	public UsuarioDto validateUsuario(String username,String password);
	
	public boolean setLastLogin(String username);
	
	public boolean setCurrentDevice(UserDetails user, String imei);
}
