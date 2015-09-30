package com.puridiompe.mpa.business.general.dto;

import java.math.BigDecimal;

import com.puridiompe.mpa.common.type.Datetime;

public class GpsInspectorDto {
	
//	 private Integer idGps;	 
	 
	 private String imei;  
	 
	 private String username;	 
	 
	 private String apePat;	 
	 
	 private String apeMat;	 
	 
	 private String nombres; 
	 
	 private BigDecimal latitud;	 
	 
	 private BigDecimal longitud;	 	 
	 
	 private Datetime fecha;
	 
	 private String rol;
	 
	 public GpsInspectorDto() {
		// TODO Auto-generated constructor stub
	}

	public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getApePat() {
		return apePat;
	}

	public void setApePat(String apePat) {
		this.apePat = apePat;
	}

	public String getApeMat() {
		return apeMat;
	}

	public void setApeMat(String apeMat) {
		this.apeMat = apeMat;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public BigDecimal getLatitude() {
		return latitud;
	}

	public void setLatitude(BigDecimal latitud) {
		this.latitud = latitud;
	}

	public BigDecimal getLongitude() {
		return longitud;
	}

	public void setLongitude(BigDecimal longitud) {
		this.longitud = longitud;
	}

	public Datetime getDate() {
		return fecha;
	}

	public void setDate(Datetime fecha) {
		this.fecha = fecha;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

}
