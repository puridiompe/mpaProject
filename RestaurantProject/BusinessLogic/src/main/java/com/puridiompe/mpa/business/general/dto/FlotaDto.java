package com.puridiompe.mpa.business.general.dto;

import java.util.Date;

public class FlotaDto {

	private Integer id;
	
	private String empresa;
	
	private Integer socio;
	
	private String vehiculo;
	
	private Integer mododTaxi;
	
	private String numeroDocumento;
	
	private Date fechaDocumento;
	
	private String Observacion;
	
	private Integer estado;
	
	private String usuario ;
	
	private Date feechaActual;

	/**
	 * Default Constructor
	 */
	public FlotaDto(){
		
	}
	
	/**
	 * Getters and Setters
	 * @return
	 */
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public Integer getSocio() {
		return socio;
	}

	public void setSocio(Integer socio) {
		this.socio = socio;
	}

	public String getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(String vehiculo) {
		this.vehiculo = vehiculo;
	}

	public Integer getMododTaxi() {
		return mododTaxi;
	}

	public void setMododTaxi(Integer mododTaxi) {
		this.mododTaxi = mododTaxi;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public Date getFechaDocumento() {
		return fechaDocumento;
	}

	public void setFechaDocumento(Date fechaDocumento) {
		this.fechaDocumento = fechaDocumento;
	}

	public String getObservacion() {
		return Observacion;
	}

	public void setObservacion(String observacion) {
		Observacion = observacion;
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

	public Date getFeechaActual() {
		return feechaActual;
	}

	public void setFeechaActual(Date feechaActual) {
		this.feechaActual = feechaActual;
	}
}
