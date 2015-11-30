package com.puridiompe.mpa.business.general.dto;

import java.util.ArrayList;
import java.util.List;

public class ActaDto {

	private Integer idActa;
	
	private String numAct;
	
	private String username;
	
	private String vehiculo;
	
	private String descripcion;
	
	private List<String> imagenesBase64;
	
	private String estado;
	
	public ActaDto(){
		this.imagenesBase64 = new ArrayList<String>();
	}

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

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public List<String> getImagenesBase64() {
		return imagenesBase64;
	}

	public void setImagenesBase64(List<String> imagenesBase64) {
		this.imagenesBase64 = imagenesBase64;
	}
	
	
}
