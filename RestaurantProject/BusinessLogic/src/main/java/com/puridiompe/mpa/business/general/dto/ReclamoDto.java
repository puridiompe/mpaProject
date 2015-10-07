package com.puridiompe.mpa.business.general.dto;

import java.util.Date;

public class ReclamoDto {

	private Integer idReclamo;
	
	private Integer dni;
	
	private String descripcion;
	
	private String vehiculo;
	
	private Date fechaCreacion;
	
	private String imagenBase64;
	
	
	public ReclamoDto (){
		
	}


	public Integer getIdReclamo() {
		return idReclamo;
	}


	public void setIdReclamo(Integer idReclamo) {
		this.idReclamo = idReclamo;
	}


	public Integer getDni() {
		return dni;
	}


	public void setDni(Integer dni) {
		this.dni = dni;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public String getVehiculo() {
		return vehiculo;
	}


	public void setVehiculo(String vehiculo) {
		this.vehiculo = vehiculo;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}


	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}


	public String getImagenBase64() {
		return imagenBase64;
	}


	public void setImagenBase64(String imagenBase64) {
		this.imagenBase64 = imagenBase64;
	}
	
}
