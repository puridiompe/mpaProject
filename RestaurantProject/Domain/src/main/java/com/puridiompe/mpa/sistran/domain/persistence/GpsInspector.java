package com.puridiompe.mpa.sistran.domain.persistence;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author Lucho
 *
 */

@Entity
@Table(name = "\"TrGen_LastPerInsp\"")
public class GpsInspector{
	
	 @Id
	 @Column(name = "\"txn_id\"")	 
	 private Integer idGps;
	 
	 @Column(name = "\"imei\"", length = 20, unique = true)
	 private String imei;
	 
	 @Column(name = "\"idUsuario\"")	 
	 private Integer idUsuario;
	 
	 @Column(name = "\"username\"")
	 private String username;
	 
	 @Column(name = "\"apePat\"")
	 private String apePat;
	 
	 @Column(name = "\"apeMat\"")
	 private String apeMat;
	 
	 @Column(name = "\"nombres\"")
	 private String nombres;
	 
	 @Column(name = "\"latitude\"")
	 private BigDecimal latitude;
	 
	 @Column(name = "\"longitude\"")
	 private BigDecimal longitude;
	 	 
	 @Column(name = "\"txn_date\"", nullable = true, updatable = false)
	 private Date date;	 
	 	 
	 /**
	  * default constructor
	  */
	 
	 public GpsInspector(){
		 
	 }

	public Integer getIdGps() {
		return idGps;
	}

	public void setIdGps(Integer idGps) {
		this.idGps = idGps;
	}

	public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	} 
	
}