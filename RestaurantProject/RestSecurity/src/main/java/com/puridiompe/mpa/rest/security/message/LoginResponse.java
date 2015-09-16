/**
 * 
 */
package com.puridiompe.mpa.rest.security.message;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.puridiompe.mpa.business.security.dto.PerfilDto;
import com.puridiompe.mpa.common.rest.message.ResponseBody;

/**
 * @author
 *
 */
public class LoginResponse extends ResponseBody {

	
	private String nombres;
	
	private String apellidoPaterno;
	
	private String apellidoMaterno;
	
	private List<String> roles;
	
	private String username;
	
	private String status;
	
	private Date lastLogin;
	
	
	
	public LoginResponse(){
		roles= new ArrayList<>();
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the lastLogin
	 */
	public Date getLastLogin() {
		return lastLogin;
	}

	/**
	 * @param lastLogin
	 *            the lastLogin to set
	 */
	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public List<String> getRoles() {
		return roles;
	}
	public void setRoles(List<String> roles) {
		this.roles=roles;
	}

	public void setPerfil(List<PerfilDto> perfiles) {
		roles= new ArrayList<>();
		for (PerfilDto perfil: perfiles){
			this.roles.add(perfil.getAuthority());
		}
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}


}
