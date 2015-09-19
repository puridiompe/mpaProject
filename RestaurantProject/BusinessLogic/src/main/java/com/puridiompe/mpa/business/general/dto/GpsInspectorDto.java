package com.puridiompe.mpa.business.general.dto;

import java.math.BigDecimal;

import com.puridiompe.mpa.common.type.Datetime;

public class GpsInspectorDto {
	
//	 private Integer idGps;	 
	 
	 private String imei;	 
	 	 
//	 private Integer idUsuario;	 
	 
	 private String username;	 
	 
	 private String apePat;	 
	 
	 private String apeMat;	 
	 
	 private String nombres; 
	 
	 private BigDecimal latitude;	 
	 
	 private BigDecimal longitude;	 	 
	 
	 private Datetime date;	
	 
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
		return latitude;
	}

	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}

	public BigDecimal getLongitude() {
		return longitude;
	}

	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}

	public Datetime getDate() {
		return date;
	}

	public void setDate(Datetime date) {
		this.date = date;
	}

}
