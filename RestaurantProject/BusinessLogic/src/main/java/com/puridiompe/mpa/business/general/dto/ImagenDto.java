package com.puridiompe.mpa.business.general.dto;

import com.puridiompe.mpa.common.type.Datetime;

public class ImagenDto {
	
	private Integer idEntidad;
		
	private String tipoEntidad;
		
	private String nombre;
		
	private String tipo;
		
	private Integer tamanho;
	
	private Datetime fechaCreacion;
	
	private Integer idPadre;
	
	public ImagenDto(){
		
	}

	public Integer getIdEntidad() {
		return idEntidad;
	}

	public void setIdEntidad(Integer idEntidad) {
		this.idEntidad = idEntidad;
	}

	public String getTipoEntidad() {
		return tipoEntidad;
	}

	public void setTipoEntidad(String tipoEntidad) {
		this.tipoEntidad = tipoEntidad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Integer getTamanho() {
		return tamanho;
	}

	public void setTamanho(Integer tamanho) {
		this.tamanho = tamanho;
	}

	public Datetime getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Datetime fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Integer getIdPadre() {
		return idPadre;
	}

	public void setIdPadre(Integer idPadre) {
		this.idPadre = idPadre;
	}
	

}
