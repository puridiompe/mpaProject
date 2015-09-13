package com.puridiompe.mpa.business.general.dto;

import java.util.ArrayList;
import java.util.List;
import com.puridiompe.mpa.business.general.dto.RolDto;

public class UsuarioDto {
	private String idUsuario;
	private String username;
	private String password;
	private String apellidoPaterno;
	private String apellidoMaterno; 
	private String nombres;
	private List<RolDto> roles;

	
	public UsuarioDto(){
		roles = new ArrayList<>();
	}
	
	public String getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getApellidoMaterno() {
		return apellidoMaterno;
	}
	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}
	public String getApellidoPaterno() {
		return apellidoPaterno;
	}
	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public List<RolDto> getRoles() {
		return roles;
	}

	public void setRoles(List<RolDto> roles) {
		this.roles = roles;
	}
	

}
