package com.puridiompe.mpa.business.general.dto;

import java.util.Date;

public class ReclamoDto {

private Integer idReclamo;
	
	private Integer dni;
	
	private String descripcion;
	
	private String vehiculo;
	
	private String imagen;
	
	private Date fechaCreacion;
	
	
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


	public String getImagen() {
		return imagen;
	}


	public void setImagen(String imagen) {
		this.imagen = imagen;
	}


	public Date getFechaCreacion() {
		return fechaCreacion;
	}


	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	
}
