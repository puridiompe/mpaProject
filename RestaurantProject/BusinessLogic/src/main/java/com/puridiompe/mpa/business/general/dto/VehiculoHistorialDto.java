package com.puridiompe.mpa.business.general.dto;

import java.util.Date;

public class VehiculoHistorialDto {

	private String vehiculo;
	
	private String usuario;
	
	private String imei;
	
	private Date fecha;
	
	public VehiculoHistorialDto(){
		
	}

	public String getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(String vehiculo) {
		this.vehiculo = vehiculo;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
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
