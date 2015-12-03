package com.puridiompe.mpa.business.general.dto;

import java.util.Date;

public class UsuarioActaDto {

	private String username;
	
	private String numActa;
	
	private Date fecha;
	
	
	public UsuarioActaDto(){
		
	}

	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNumActa() {
		return numActa;
	}

	public void setNumActa(String numActa) {
		this.numActa = numActa;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
}
