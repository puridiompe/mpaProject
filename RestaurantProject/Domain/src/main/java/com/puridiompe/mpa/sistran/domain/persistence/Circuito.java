package com.puridiompe.mpa.sistran.domain.persistence;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "\"TrUrb_Circuito\"")
public class Circuito {

	@Id
	@Column(name = "\"id\"", nullable = false, unique = true, length = 6)
	private Integer id;
	
	@Column(name = "\"circuito\"")
	private String circuito;
	
	@Column(name = "\"observaci\"")
	private String observacion;
	
	@Column(name = "\"usuario\"")
	private String usuario;
	
	@Column(name = "\"fecAct\"")
	private Date fechaActual;
	
	public Circuito(){
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCircuito() {
		return circuito;
	}

	public void setCircuito(String circuito) {
		this.circuito = circuito;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public Date getFechaActual() {
		return fechaActual;
	}

	public void setFechaActual(Date fechaActual) {
		this.fechaActual = fechaActual;
	}
	
	
}
