/**
 * 
 */
package com.puridiompe.mpa.business.security.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author 
 *
 */
@SuppressWarnings("serial")
public class UsuarioDto implements UserDetails {

	private Integer IdUsuario;
	
	private String username;

	private String password;

	private List<PerfilDto> perfiles;
	
	public UsuarioDto(){
		perfiles = new ArrayList<>();
	}

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

	public List<PerfilDto> getPerfiles() {
		return perfiles;
	}

	public void setPerfiles(List<PerfilDto> perfiles) {
		this.perfiles = perfiles;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getIdUsuario() {
		return IdUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		IdUsuario = idUsuario;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
