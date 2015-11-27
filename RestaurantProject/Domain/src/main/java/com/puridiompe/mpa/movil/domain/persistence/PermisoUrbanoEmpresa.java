package com.puridiompe.mpa.movil.domain.persistence;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class PermisoUrbanoEmpresa implements Serializable{

	private String vehiculo;
	
	private Date fechaEmision;
	
	private Date fechaInicio;
	
	private Date fechaVencimiento;
	
	private String observacion;
	
	private Integer numeroPermiso;
	
	private String razonSocial;
	
	/**
	 * Constructor
	 * 
	 * 
	 */
	public PermisoUrbanoEmpresa(String vehiculo, Date fechaEmision, Date fechaInicio, Date fechaVencimiento, String observacion, Integer numeroPermiso,
						String razonSocial){
		
		this.vehiculo = vehiculo;
		this.fechaEmision = fechaEmision;
		this.fechaInicio = fechaInicio;
		this.fechaVencimiento = fechaVencimiento;
		this.observacion = observacion;
		this.numeroPermiso = numeroPermiso;
		this.razonSocial = razonSocial;
	}

	public String getVehiculo() {
		return vehiculo;
	}

	public Date getFechaEmision() {
		return fechaEmision;
	}
	
	public Date getFechaInicio() {
		return fechaInicio;
	}

	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}

	public String getObservacion() {
		return observacion;
	}

	public Integer getNumeroPermiso() {
		return numeroPermiso;
	}
	
	public String getRazonSocial() {
		return razonSocial;
	}
	
}
