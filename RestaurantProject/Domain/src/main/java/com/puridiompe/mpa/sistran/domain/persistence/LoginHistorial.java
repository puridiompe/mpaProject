package com.puridiompe.mpa.sistran.domain.persistence;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "\"TrPpe_LogHis\"")
public class LoginHistorial {

	@Id
	@Column(name = "\"idLogHist\"", nullable = false, unique = true)
	private Integer idLogHist;
	
	@Column(name = "\"idUsuario\"", nullable = false)
	private Integer idUsuario;
	
	@Column(name = "\"fechaHora\"", nullable = false)
	private Date fechaHora;
	
	@Column(name = "\"estado\"", nullable = false)
	private Boolean estado;

	public LoginHistorial(){}

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

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	
	
}
