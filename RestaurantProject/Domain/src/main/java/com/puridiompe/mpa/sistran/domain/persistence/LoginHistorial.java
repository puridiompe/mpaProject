package com.puridiompe.mpa.sistran.domain.persistence;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name = "\"TrPpe_LogHis\"")
public class LoginHistorial {

	@Id
	@SequenceGenerator(name = "pk_sequence", sequenceName = "tr_loghis_id", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "pk_sequence")
	@Column(name = "\"idloghist\"", unique=true, nullable=false)
	private Integer idLogHist;
	
	@Column(name = "\"idUsuario\"", nullable = false)
	private Integer idUsuario;
	
	@Column(name = "\"fechaHora\"", nullable = false)
	private Date fechaHora;
	
	@Column(name = "\"estado\"", nullable = true)
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
