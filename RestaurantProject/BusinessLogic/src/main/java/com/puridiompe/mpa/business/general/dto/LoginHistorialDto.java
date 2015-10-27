package com.puridiompe.mpa.business.general.dto;

import java.util.Date;


public class LoginHistorialDto {

	private Integer idLogHist;
	private String username;
	private Date fechaHora;
//	private Boolean estado;
	private String imei;
	private Date fechaToken;
	
	public LoginHistorialDto(){}

	public Integer getIdLogHist() {
		return idLogHist;
	}

	public void setIdLogHist(Integer idLogHist) {
		this.idLogHist = idLogHist;
	}

	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(Date fechaHora) {
		this.fechaHora = fechaHora;
	}

	public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

	public Date getFechaToken() {
		return fechaToken;
	}

	public void setFechaToken(Date fechaToken) {
		this.fechaToken = fechaToken;
	}
	

//	public Boolean getEstado() {
//		return estado;
//	}
//
//	public void setEstado(Boolean estado) {
//		this.estado = estado;
//	}
	
	
	
}
