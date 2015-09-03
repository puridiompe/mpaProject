package com.puridiompe.mpa.sistran.domain.persistence;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "\"TrGen_Flota\"")
public class Flota {
	
	@Id
	@Column(name = "\"id\"", nullable = false, unique = true)
	private Integer id;
	
	@Column(name = "\"empresa\"")
	private String empresa;
	
	@Column(name = "\"socio\"")
	private Integer socio;
	
	@Column(name = "\"vehiculo\"", length = 6)
	private String vehiculo;
	
	@Column(name = "\"modTax\"")
	private Integer mododTaxi;
	
	@Column(name = "\"numDoc\"")
	private String numeroDocumento;
	
	@Column(name = "\"fecDoc\"")
	private Date fechaDocumento;
	
	@Column(name = "\"observaci\"")
	private String Observacion;
	
	@Column(name = "\"estado\"")
	private Integer estado;
	
	@Column(name = "\"usuario\"")
	private String usuario ;
	
	@Column(name = "\"fecAct\"")
	private Date feechaActual;

	/**
	 * Default Constructor
	 */
	public Flota(){
		
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
