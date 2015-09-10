/**
 * 
 */
package com.puridiompe.mpa.business.security.dto;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author 
 *
 */
@SuppressWarnings("serial")
public class UsuarioDto implements UserDetails {

	private String username;

	private String password;

	private List<PerfilDto> perfiles;

	public UsuarioDto(String username, String password, List<PerfilDto> perfiles) {
		this.username = username;
		this.password = password;
		this.perfiles = perfiles;
	}

	@Override
	public List<PerfilDto> getAuthorities() {
		// TODO Auto-generated method stub
		return perfiles;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
