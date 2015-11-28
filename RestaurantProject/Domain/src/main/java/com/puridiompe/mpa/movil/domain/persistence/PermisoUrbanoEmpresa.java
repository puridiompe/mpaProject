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
	
	private String circuito;
	
	private String codigo;
	
	private String descripcion;
	
	private String recorridoIda;
	
	private String recorridoVuelta;
	
	/**
	 * Constructor
	 * 
	 * 
	 */
	public PermisoUrbanoEmpresa(String vehiculo, Date fechaEmision, Date fechaInicio, Date fechaVencimiento, String observacion, Integer numeroPermiso,
						String razonSocial, String circuito, String codigo, String descripcion, String recorridoIda, String recorridoVuelta){
		
		this.vehiculo = vehiculo;
		this.fechaEmision = fechaEmision;
		this.fechaInicio = fechaInicio;
		this.fechaVencimiento = fechaVencimiento;
		this.observacion = observacion;
		this.numeroPermiso = numeroPermiso;
		this.razonSocial = razonSocial;
		this.circuito = circuito;
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.recorridoIda = recorridoIda;
		this.recorridoVuelta = recorridoVuelta;
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

	public String getCircuito() {
		return circuito;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public String getRecorridoIda() {
		return recorridoIda;
	}

	public String getRecorridoVuelta() {
		return recorridoVuelta;
	}
	
}
