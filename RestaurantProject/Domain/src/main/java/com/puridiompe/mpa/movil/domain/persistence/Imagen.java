package com.puridiompe.mpa.movil.domain.persistence;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "\"TrMov_Imagen\"")
public class Imagen {
	
	@Id
	@Column(name = "\"idEntidad\"", unique = true, nullable = false)
	@SequenceGenerator(name = "imagen_sequence", sequenceName = "\"TrMov_Imagen_idEntidad_seq\"", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "imagen_sequence")
	private Integer idEntidad;
	
	@Column(name = "\"tipoEntidad\"", nullable = false, length = 10)
	private String tipoEntidad;
	
	@Column(name = "\"nombre\"", nullable = false)
	private String nombre;
	
	@Column(name = "\"tipo\"", nullable = false, length = 10)
	private String tipo;
	
	@Column(name = "\"tamanho\"")
	private Integer tamanho;
	
	@Column(name = "\"fecCre\"")
	private Date fechaCreacion;
	
	@Column(name = "\"idPadre\"")
	private Integer idPadre;
	
	
	public Imagen (){
		
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


	public Date getFechaCreacion() {
		return fechaCreacion;
	}


	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}


	public Integer getIdPadre() {
		return idPadre;
	}


	public void setIdPadre(Integer idPadre) {
		this.idPadre = idPadre;
	}
	
}
