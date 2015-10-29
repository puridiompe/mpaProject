/**
 * 
 */
package com.puridiompe.mpa.business.security;

import java.util.Date;

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
	
	public UserDetails loadAnonymusUser(String username, String imei);

	public UsuarioDto getUsuario(String username);
	
	public UsuarioDto validateUsuario(String username,String password);
	
	//public void setLastLogin(String username,String imei,Date fechatoken);
	
	public boolean setCurrentDevice(UserDetails user, String imei);
}
