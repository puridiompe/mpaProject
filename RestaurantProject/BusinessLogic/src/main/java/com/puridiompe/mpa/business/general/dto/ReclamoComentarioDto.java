package com.puridiompe.mpa.business.general.dto;

import java.util.Date;

import com.puridiompe.mpa.common.type.Datetime;

public class ReclamoComentarioDto {
	
	private Integer id;
	
	private Integer dni;	

	private String comentario;
	
	private Date fecCre;
	
	private Date fecMod;
	
	private String estado;
	
	public ReclamoComentarioDto(){
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Date getFecCre() {
		return fecCre;
	}

	public void setFecCre(Date fecCre) {
		this.fecCre = fecCre;
	}

	public Date getFecMod() {
		return fecMod;
	}

	public void setFecMod(Date fecMod) {
		this.fecMod = fecMod;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
