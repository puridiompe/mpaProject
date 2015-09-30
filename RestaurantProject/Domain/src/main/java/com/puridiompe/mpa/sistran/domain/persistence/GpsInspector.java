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
@Table(name = "\"TrMov_LastPerUser\"")
public class GpsInspector{
	
	 @Id
	 @Column(name = "\"idTraGps\"")	 
	 private Integer idTraGps;
	 
	 @Column(name = "\"imei\"", length = 30, unique = true)
	 private String imei;
	 
	 @Column(name = "\"idUsu\"")	 
	 private Integer idUsuario;
	 
	 @Column(name = "\"rol\"")
	 private String rol;
	 
	 @Column(name = "\"username\"")
	 private String username;
	 
	 @Column(name = "\"apePat\"")
	 private String apePat;
	 
	 @Column(name = "\"apeMat\"")
	 private String apeMat;
	 
	 @Column(name = "\"nombres\"")
	 private String nombres;
	 
	 @Column(name = "\"latitud\"")
	 private BigDecimal latitud;
	 
	 @Column(name = "\"longitud\"")
	 private BigDecimal longitud;
	 	 
	 @Column(name = "\"fecha\"", nullable = true, updatable = false)
	 private Date fecha;
	 	 	 
	 /**
	  * default constructor
	  */
	 
	 public GpsInspector(){
		 
	 }

	public Integer getIdGps() {
		return idTraGps;
	}

	public void setIdGps(Integer idTraGps) {
		this.idTraGps = idTraGps;
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

	public Date getDate() {
		return fecha;
	}

	public void setDate(Date fecha) {
		this.fecha = fecha;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}
	
}