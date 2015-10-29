package com.puridiompe.mpa.movil.domain.persistence;

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
@Table(name = "\"TrMov_HisLog\"")
public class LoginHistorial {

	@Id
	@SequenceGenerator(name = "loginhistorial_sequence", sequenceName = "\"TrMov_HisLog_idHisLog_seq\"", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "loginhistorial_sequence")
	@Column(name = "\"idHisLog\"", unique=true, nullable=false)
	private Integer idLogHist;
	
//	@Column(name = "\"idUsuario\"", nullable = false)
//	private Integer idUsuario;
	
	@Column(name = "\"username\"") //nullable = false
	private String username;
	
	@Column(name = "\"fecha\"", nullable = false)
	private Date fechaHora;
	
//	@Column(name = "\"estado\"", nullable = true)
//	private Boolean estado;

	@Column(name = "\"imei\"")
	private String imei;
	
	@Column(name = "\"fechaToken\"")
	private Date fechaToken;
	
	public LoginHistorial(){}

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
