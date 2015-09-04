package com.puridiompe.mpa.business.general.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PermisoGeneralDto {

	private String vehiculo;
	private List<Date> fechaEmision;
	private List<Date> fechaVencimiento;
	private List<String> observacion;
	private List<String> numeroExpediente;
	private List<Date> fechaExpediente;
	private List<String> tipoPermiso;
	private PermisoOperacionEscolarDto permisoEscolar;
	private PermisoOperacionEspecialDto permisoEspecial;
	//private PermisoOperacionTrabajadorDto permisoTrabajador;
	private PermisoOperacionTurismoDto permisoTurismo;
	
	public PermisoGeneralDto(){
		this.fechaEmision = new ArrayList<Date>();
		this.fechaVencimiento = new ArrayList<Date>();
		this.observacion = new ArrayList<String>();
		this.numeroExpediente = new ArrayList<String>();
		this.fechaExpediente = new ArrayList<Date>();
		this.tipoPermiso = new ArrayList<String>();
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

	public PermisoOperacionEscolarDto getPermisoEscolar() {
		return permisoEscolar;
	}

	public void setPermisoEscolar(PermisoOperacionEscolarDto permisoEscolar) {
		this.permisoEscolar = permisoEscolar;
	}

	public PermisoOperacionEspecialDto getPermisoEspecial() {
		return permisoEspecial;
	}

	public void setPermisoEspecial(PermisoOperacionEspecialDto permisoEspecial) {
		this.permisoEspecial = permisoEspecial;
	}
/*
	public PermisoOperacionTrabajadorDto getPermisoTrabajador() {
		return permisoTrabajador;
	}

	public void setPermisoTrabajador(PermisoOperacionTrabajadorDto permisoTrabajador) {
		this.permisoTrabajador = permisoTrabajador;
	}
*/
	public PermisoOperacionTurismoDto getPermisoTurismo() {
		return permisoTurismo;
	}

	public void setPermisoTurismo(PermisoOperacionTurismoDto permisoTurismo) {
		this.permisoTurismo = permisoTurismo;
	}

	public List<Date> getFechaEmision() {
		return fechaEmision;
	}

	public void setFechaEmision(List<Date> fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	public List<Date> getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(List<Date> fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public List<String> getObservacion() {
		return observacion;
	}

	public void setObservacion(List<String> observacion) {
		this.observacion = observacion;
	}

	public List<String> getNumeroExpediente() {
		return numeroExpediente;
	}

	public void setNumeroExpediente(List<String> numeroExpediente) {
		this.numeroExpediente = numeroExpediente;
	}

	public List<Date> getFechaExpediente() {
		return fechaExpediente;
	}

	public void setFechaExpediente(List<Date> fechaExpediente) {
		this.fechaExpediente = fechaExpediente;
	}

	public List<String> getTipoPermiso() {
		return tipoPermiso;
	}

	public void setTipoPermiso(List<String> tipoPermiso) {
		this.tipoPermiso = tipoPermiso;
	}

	
			
}
