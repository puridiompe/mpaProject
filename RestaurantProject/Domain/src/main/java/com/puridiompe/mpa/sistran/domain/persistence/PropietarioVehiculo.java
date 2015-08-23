package com.puridiompe.mpa.sistran.domain.persistence;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author PuridiomPe
 * @version 1.0
 * 
 *
 */

@Entity
@Table(name = "\"TrGen_ProVeh\"")
public class PropietarioVehiculo{

	@Id
	@Column(name = "\"id\"", nullable = false, unique = true)
	private Integer idPropietario;
	
	@Column(name = "\"vehiculo\"", length = 6)
	private String vehiculo;
	
	@Column(name = "\"apePat1\"")
	private String apellidoPaterno1;
	
	@Column(name = "\"apeMat1\"")
	private String apellidoMaterno1;

	@Column(name = "\"nombres1\"")
	private String nombreCompleto1;
	
	@Column(name = "\"apePat2\"")
	private String apellidoPaterno2;
	
	@Column(name = "\"apeMat2\"")
	private String apellidoMaterno2;

	@Column(name = "\"nombres2\"")
	private String nombreCompleto2;
	
	@Column(name = "\"razSoc\"")
	private String razonSocial;
	
	@Column(name = "\"domicilio\"")
	private String domicilioPropietario;
	
	@Column(name = "\"estado\"")
	private Integer estado;
	
	@Column(name = "\"usuario\"")
	private String usuario;
	
	@Column(name = "\"fecAct\"")
	private Date fechaActivacion;
	
	
	/**
	 * Default Constructor
	 */
	public PropietarioVehiculo() {
	
	}
	
	
	/**
	 * Getters and Setters
	 * @return
	 */
	public Integer getIdPropietario() {
		return idPropietario;
	}


	public void setIdPropietario(Integer idPropietario) {
		this.idPropietario = idPropietario;
	}


	public String getVehiculo() {
		return vehiculo;
	}


	public void setVehiculo(String vehiculo) {
		this.vehiculo = vehiculo;
	}


	public String getApellidoPaterno1() {
		return apellidoPaterno1;
	}


	public void setApellidoPaterno1(String apellidoPaterno1) {
		this.apellidoPaterno1 = apellidoPaterno1;
	}


	public String getApellidoMaterno1() {
		return apellidoMaterno1;
	}


	public void setApellidoMaterno1(String apellidoMaterno1) {
		this.apellidoMaterno1 = apellidoMaterno1;
	}


	public String getNombreCompleto1() {
		return nombreCompleto1;
	}


	public void setNombreCompleto1(String nombreCompleto1) {
		this.nombreCompleto1 = nombreCompleto1;
	}


	public String getApellidoPaterno2() {
		return apellidoPaterno2;
	}


	public void setApellidoPaterno2(String apellidoPaterno2) {
		this.apellidoPaterno2 = apellidoPaterno2;
	}


	public String getApellidoMaterno2() {
		return apellidoMaterno2;
	}


	public void setApellidoMaterno2(String apellidoMaterno2) {
		this.apellidoMaterno2 = apellidoMaterno2;
	}


	public String getNombreCompleto2() {
		return nombreCompleto2;
	}


	public void setNombreCompleto2(String nombreCompleto2) {
		this.nombreCompleto2 = nombreCompleto2;
	}


	public String getRazonSocial() {
		return razonSocial;
	}


	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}


	public String getDomicilioPropietario() {
		return domicilioPropietario;
	}


	public void setDomicilioPropietario(String domicilioPropietario) {
		this.domicilioPropietario = domicilioPropietario;
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
	
	
	public Date getFechaActivacion() {
		return fechaActivacion;
	}

	
	public void setFechaActivacion(Date fechaActivacion) {
		this.fechaActivacion = fechaActivacion;
	}

	
}


