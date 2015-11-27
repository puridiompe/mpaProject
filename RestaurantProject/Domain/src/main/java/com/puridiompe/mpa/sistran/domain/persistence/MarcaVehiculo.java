package com.puridiompe.mpa.sistran.domain.persistence;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "\"TrGen_MarVeh\"")
public class MarcaVehiculo {
	
	@Id
	@Column(name = "\"id\"", nullable = false, unique = true, length = 6)
	private Integer id;
	
	@Column(name = "\"denominac\"")
	private String denominacion;
	
	@Column(name = "\"estado\"")
	private Integer estado;
	
	@Column(name = "\"usuario\"")
	private String usuario;
	
	@Column(name = "\"fecAct\"")
	private Date fechaActual;
	

	public MarcaVehiculo (){
		
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getDenominacion() {
		return denominacion;
	}


	public void setDenominacion(String denominacion) {
		this.denominacion = denominacion;
	}


	public Integer getEstado() {
		return estado;
	}


	public void setEstado(Integer estado) {
		this.estado = estado;
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
