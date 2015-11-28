package com.puridiompe.mpa.sistran.domain.persistence;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "\"TrUrb_RecRut\"")
public class Ruta {
	
	@Id
	@Column(name = "\"id\"", nullable = false, unique = true, length = 6)
	private Integer id;
	
	@Column(name = "\"ruta\"")
	private Integer ruta;
	
	@Column(name = "\"hisRut\"")
	private Integer hisRut;
	
	@Column(name = "\"recIda\"")
	private String recorridoIda;
	
	@Column(name = "\"recVue\"")
	private String recorridoVuelta;
	
	@Column(name = "\"estado\"")
	private Integer estado;
	
	@Column(name = "\"usuario\"")
	private String usuario;
	
	@Column(name = "\"fecAct\"")
	private Date fechaActual;
	
	public Ruta(){
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRuta() {
		return ruta;
	}

	public void setRuta(Integer ruta) {
		this.ruta = ruta;
	}

	public Integer getHisRut() {
		return hisRut;
	}

	public void setHisRut(Integer hisRut) {
		this.hisRut = hisRut;
	}

	public String getRecorridoIda() {
		return recorridoIda;
	}

	public void setRecorridoIda(String recorridoIda) {
		this.recorridoIda = recorridoIda;
	}

	public String getRecorridoVuelta() {
		return recorridoVuelta;
	}

	public void setRecorridoVuelta(String recorridoVuelta) {
		this.recorridoVuelta = recorridoVuelta;
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

	public Date getFechaActual() {
		return fechaActual;
	}

	public void setFechaActual(Date fechaActual) {
		this.fechaActual = fechaActual;
	}
	
}
