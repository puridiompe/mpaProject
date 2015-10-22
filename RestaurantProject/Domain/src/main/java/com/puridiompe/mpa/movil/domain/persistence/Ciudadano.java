package com.puridiompe.mpa.movil.domain.persistence;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "\"TrMov_Ciudadano\"")
public class Ciudadano {

	@Id
	@Column(name = "\"dni\"", unique = true, nullable = false)
	private Integer dni;
	
	@Column(name = "\"apePat\"", nullable = false)
	private String apellidoPaterno;
	
	@Column(name = "\"apeMat\"", nullable = false)
	private String apellidoMaterno;
	
	@Column(name = "\"nombres\"", nullable = false)
	private String nombres;
	
	@Column(name = "\"email\"", nullable = true)
	private String email;
	
//	@Column(name = "\"imei\"", length = 30, unique = true, nullable = false)
//	private String imei;
	
	@Column(name = "\"fecCre\"", nullable = false)
	private Date fechaCreacion;
	
	@Column(name = "\"fecMod\"", nullable = true)
	private Date fechaModificacion;
	
	/**
	 * Default Constructor
	 */
	public Ciudadano(){
		
	}

	/**
	 * Getters and Setters
	 * @return
	 */
	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

//	public String getImei() {
//		return imei;
//	}
//
//	public void setImei(String imei) {
//		this.imei = imei;
//	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

}
