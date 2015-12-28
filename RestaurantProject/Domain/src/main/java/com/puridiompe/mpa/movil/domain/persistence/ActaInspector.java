package com.puridiompe.mpa.movil.domain.persistence;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class ActaInspector implements Serializable {
	
	private Integer idActa;
	private String numAct;
	private String username;
	private String vehiculo;
	private String descripcion;
	private String nombres;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private Date fecCre;
	
	public ActaInspector(Integer idActa, String numAct, String username, String vehiculo, String descripcion,Date fecCre,
			String nombres, String apellidoPaterno, String apellidoMaterno) {
		
		this.idActa = idActa;
		this.numAct = numAct;
		this.username = username;
		this.vehiculo = vehiculo;
		this.descripcion = descripcion;
		this.nombres = nombres;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		this.fecCre = fecCre;
	}
	
	/**
	 * @return the idActa
	 */
	public Integer getIdActa() {
		return idActa;
	}
	public void setIdActa(Integer idActa) {
		this.idActa = idActa;
	}
	public String getNumAct() {
		return numAct;
	}
	public void setNumAct(String numAct) {
		this.numAct = numAct;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getVehiculo() {
		return vehiculo;
	}
	public void setVehiculo(String vehiculo) {
		this.vehiculo = vehiculo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
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

	public Date getFecCre() {
		return fecCre;
	}

	public void setFecCre(Date fecCre) {
		this.fecCre = fecCre;
	}

	
	
	
}
