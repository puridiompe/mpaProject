package com.puridiompe.mpa.movil.domain.persistence;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class PermisoUrbanoEmpresa implements Serializable{

	private String vehiculo;
	
	private Date fechaEmision;
	
	private Date fechaVencimiento;
	
	private String observacion;
	
	private Integer numeroExpediente;
	
	private String razonSocial;
	
	/**
	 * Constructor
	 * 
	 * 
	 */
	public PermisoUrbanoEmpresa(String vehiculo, Date fechaEmision, Date fechaVencimiento, String observacion, Integer numeroExpediente,
						String razonSocial){
		this.vehiculo = vehiculo;
		this.fechaEmision = fechaEmision;
		this.fechaVencimiento = fechaVencimiento;
		this.observacion = observacion;
		this.numeroExpediente = numeroExpediente;
		this.razonSocial = razonSocial;
	}

	public String getVehiculo() {
		return vehiculo;
	}

	public Date getFechaEmision() {
		return fechaEmision;
	}

	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}

	public String getObservacion() {
		return observacion;
	}

	public Integer getNumeroExpediente() {
		return numeroExpediente;
	}
	
	public String getRazonSocial() {
		return razonSocial;
	}
	
}
