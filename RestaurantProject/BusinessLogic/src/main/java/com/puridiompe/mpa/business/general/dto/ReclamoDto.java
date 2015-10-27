package com.puridiompe.mpa.business.general.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReclamoDto {

	private Integer idReclamo;
	
	private Integer dni;
	
	private String descripcion;
	
	private String vehiculo;
	
//	private Date fechaCreacion;
	
	private List<String> imagenesBase64;
	
	private String imei;
	
	private String estado;
	
	private String numRec;
	
	
	public ReclamoDto (){
		imagenesBase64 = new ArrayList<String>();		
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

//	public Date getFechaCreacion() {
//		return fechaCreacion;
//	}
//
//
//	public void setFechaCreacion(Date fechaCreacion) {
//		this.fechaCreacion = fechaCreacion;
//	}


	public List<String> getImagenesBase64() {
		return imagenesBase64;
	}


	public void setImagenesBase64(List<String> imagenesBase64) {
		this.imagenesBase64 = imagenesBase64;
	}


	public String getImei() {
		return imei;
	}


	public void setImei(String imei) {
		this.imei = imei;
	}


	public String getNumRec() {
		return numRec;
	}


	public void setNumRec(String numRec) {
		this.numRec = numRec;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}
	
}
