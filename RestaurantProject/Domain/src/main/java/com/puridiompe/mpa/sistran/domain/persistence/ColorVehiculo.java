package com.puridiompe.mpa.sistran.domain.persistence;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "\"TrGen_ColVeh\"")
public class ColorVehiculo {
	
	@Id
	@Column(name = "\"id\"", nullable = false, unique = true)
	private Integer id;
	
	@Column(name = "\"vehiculo\"")
	private String vehiculo;
	
	@Column(name = "\"color\"")
	private String color;
	
	@Column(name = "\"detCol\"")
	private String detalleColor;
	
	@Column(name = "\"usuario\"")
	private String usuario;
	
	@Column(name = "\"fecAct\"")
	private Date fechaActual;
	
	public ColorVehiculo(){
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(String vehiculo) {
		this.vehiculo = vehiculo;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getDetalleColor() {
		return detalleColor;
	}

	public void setDetalleColor(String detalleColor) {
		this.detalleColor = detalleColor;
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
