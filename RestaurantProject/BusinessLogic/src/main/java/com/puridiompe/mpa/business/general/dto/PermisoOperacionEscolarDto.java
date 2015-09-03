package com.puridiompe.mpa.business.general.dto;

import java.util.Date;


public class PermisoOperacionEscolarDto {

	
	private Integer id;
	
	
	private Integer numeroAuto;
	
	private String vehiculo;
	
	private Integer historialVehiculo;
	
	private Date fechaEmision;
	
	private Date fechaVencimiento;
	
	private String numeroRecibo;
	
	private Date fechaPago;
	
	private Integer numeroImpuesto;
	
	private boolean original ;
	
	private String numeroExpediente;
	
	private Date fechaExpiracion;
	
	private String observacion;
	
	private Integer estado;
	
	private String ultimo;
	
	private String usuario;
	
	private Date fechaActual;

	
	/**
	 * Default Constructor
	 */
	public PermisoOperacionEscolarDto() {
		
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

	public Integer getNumeroAuto() {
		return numeroAuto;
	}

	public void setNumeroAuto(Integer numeroAuto) {
		this.numeroAuto = numeroAuto;
	}

	public String getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(String vehiculo) {
		this.vehiculo = vehiculo;
	}

	public Integer getHistorialVehiculo() {
		return historialVehiculo;
	}

	public void setHistorialVehiculo(Integer historialVehiculo) {
		this.historialVehiculo = historialVehiculo;
	}

	public Date getFechaEmision(){
		return fechaEmision;
	}
	
	public void setFechaEmision(Date fechaEmision){
		this.fechaEmision = fechaEmision;
	}
	
	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public String getNumeroRecibo() {
		return numeroRecibo;
	}

	public void setNumeroRecibo(String numeroRecibo) {
		this.numeroRecibo = numeroRecibo;
	}

	public Date getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}

	public Integer getNumeroImpuesto() {
		return numeroImpuesto;
	}

	public void setNumeroImpuesto(Integer numeroImp) {
		this.numeroImpuesto = numeroImp;
	}

	public boolean isOriginal() {
		return original;
	}

	public void setOriginal(boolean original) {
		this.original = original;
	}

	public String getNumeroExpediente() {
		return numeroExpediente;
	}

	public void setNumeroExpediente(String numeroExpediente) {
		this.numeroExpediente = numeroExpediente;
	}

	public Date getFechaExpiracion() {
		return fechaExpiracion;
	}

	public void setFechaExpiracion(Date fechaExpediente) {
		this.fechaExpiracion = fechaExpediente;
	}
	
	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public String getUltimo() {
		return ultimo;
	}

	public void setUltimo(String ultimo) {
		this.ultimo = ultimo;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public Date getFechaActual(){
		return fechaActual;
	}
	
	public void setFechaActual(Date fechaActual){
		this.fechaActual = fechaActual;
	}
}
