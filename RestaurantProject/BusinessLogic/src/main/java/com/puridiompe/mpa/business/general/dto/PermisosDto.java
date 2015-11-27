package com.puridiompe.mpa.business.general.dto;

import java.util.Date;
import java.util.List;

public class PermisosDto {

	private String vehiculo;
	
	private Date fechaEmision;
	
	private Date fechaInicio;
	
	private Date fechaVencimiento;
	
	private String observacion;
	
	private String numeroExpediente;
	
	private Integer numeroPermiso;
	
	private Date fechaExpediente;
	
	private String tipoPermiso;
	
	private String razonSocial;
	
	private String estadoPermiso;
	
	
	/**
	 * Constructor
	 * 
	 * 
	 */
	public PermisosDto(){
		
	}
	
	/**
	 * Getters and Setters
	 * 
	 * @return
	 */
	public String getVehiculo() {
		return vehiculo;
	}
	
	public void setVehiculo(String vehiculo) {
		this.vehiculo = vehiculo;
	}
	
	public Date getFechaEmision() {
		return fechaEmision;
	}
	
	public void setFechaEmision(Date fechaEmision) {
		this.fechaEmision = fechaEmision;
	}
	
	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}
	
	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}
	
	public String getObservacion() {
		return observacion;
	}
	
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	
	public String getNumeroExpediente() {
		return numeroExpediente;
	}
	
	public void setNumeroExpediente(String numeroExpediente) {
		this.numeroExpediente = numeroExpediente;
	}
	
	public Date getFechaExpediente() {
		return fechaExpediente;
	}
	
	public void setFechaExpediente(Date fechaExpediente) {
		this.fechaExpediente = fechaExpediente;
	}
	
	public String getTipoPermiso() {
		return tipoPermiso;
	}
	
	public void setTipoPermiso(String tipoPermiso) {
		this.tipoPermiso = tipoPermiso;
	}
	
	public String getRazonSocial() {
		return razonSocial;
	}
	
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public Integer getNumeroPermiso() {
		return numeroPermiso;
	}

	public void setNumeroPermiso(Integer numeroPermiso) {
		this.numeroPermiso = numeroPermiso;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	
	public void setEstadoPermiso(String estadoPermiso) {
		this.estadoPermiso = estadoPermiso;
	}

	public String getEstadoPermiso() {
		return estadoPermiso;
	}
	
}
