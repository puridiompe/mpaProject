package com.puridiompe.mpa.business.general.dto;

import java.util.Date;

public class LoginHistorialDto {

	private Integer idLogHist;
	private Integer idUsuario;
	private Date fechaHora;
//	private Boolean estado;
	
	public LoginHistorialDto(){}

	public Integer getIdLogHist() {
		return idLogHist;
	}

	public void setIdLogHist(Integer idLogHist) {
		this.idLogHist = idLogHist;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Date getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(Date fechaHora) {
		this.fechaHora = fechaHora;
	}

//	public Boolean getEstado() {
//		return estado;
//	}
//
//	public void setEstado(Boolean estado) {
//		this.estado = estado;
//	}
	
	
	
}
