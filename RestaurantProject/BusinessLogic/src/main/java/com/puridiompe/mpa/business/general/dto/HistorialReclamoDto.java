package com.puridiompe.mpa.business.general.dto;

import java.util.Date;




public class HistorialReclamoDto {

private Integer idHistorialReclamo;
	

	private Integer idReclamo;
	private String usuario;
	private String tipoUsuario;
	private String accion;
	private String descripcion;
	private String imei;
	private Date fecha;

	public Integer getIdHistorialReclamo() {
		return idHistorialReclamo;
	}

	public void setIdHistorialReclamo(Integer idHistorialReclamo) {
		this.idHistorialReclamo = idHistorialReclamo;
	}

	public Integer getIdReclamo() {
		return idReclamo;
	}

	public void setIdReclamo(Integer idReclamo) {
		this.idReclamo = idReclamo;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public String getAccion() {
		return accion;
	}

	public void setAccion(String accion) {
		this.accion = accion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	
}
