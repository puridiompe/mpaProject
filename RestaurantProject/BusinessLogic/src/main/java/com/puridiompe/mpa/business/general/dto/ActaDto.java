package com.puridiompe.mpa.business.general.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ActaDto {

	private Integer idActa;
	
	private String numAct;
	
	private String username;
	
	private String vehiculo;
	
	private String descripcion;
	
	private List<String> imagenesBase64;
	
	private ResumenImagenDto resumenImagen;
	
	private Date fecCre;
	
	private String estado;
	
	private String nombres;
	
	private String apellidoPaterno;
	
	private String apellidoMaterno;
	
	
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

	public ResumenImagenDto getResumenImagen() {
		return resumenImagen;
	}

	public void setResumenImagen(ResumenImagenDto resumenImagen) {
		this.resumenImagen = resumenImagen;
	}

	public Date getFecCre() {
		return fecCre;
	}

	public void setFecCre(Date fecCre) {
		this.fecCre = fecCre;
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
	
	
}
