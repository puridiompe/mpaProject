package com.puridiompe.mpa.business.general.dto;

import java.util.Date;
import com.puridiompe.mpa.common.type.Datetime;

public class NoticiaDto {
	private Integer idNoticia;
	private String titulo;
	private String contenido ;
	private String fecha;
	private String hora;
	private Datetime fecPub;
	private String fuente;
	private String autor;
	private String link;
	
	public NoticiaDto(){}
	
	public Integer getIdNoticia() {
		return idNoticia;
	}
	public void setIdNoticia(Integer idNoticia) {
		this.idNoticia = idNoticia;
	}
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getContenido() {
		return contenido;
	}
	public void setContenido(String contenido) {
		this.contenido = contenido;
	}
	
	public Datetime getFecPub() {
		return fecPub;
	}
	public void setFecPub(Datetime fecPub) {
		this.fecPub = fecPub;
	}
	
	public String getFuente() {
		return fuente;
	}
	public void setFuente(String fuente) {
		this.fuente = fuente;
	}
	
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}
	
}
