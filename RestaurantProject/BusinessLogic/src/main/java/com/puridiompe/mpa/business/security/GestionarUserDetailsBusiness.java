/**
 * 
 */
package com.puridiompe.mpa.business.security;


import org.springframework.security.core.userdetails.UserDetailsService;

import com.puridiompe.mpa.business.security.dto.UsuarioDto;

/**
 * @author
 *
 */
public interface GestionarUserDetailsBusiness extends UserDetailsService {

	public UsuarioDto getUsuario(String username);
	
	public UsuarioDto validateUsuario(String username,String password);

}
