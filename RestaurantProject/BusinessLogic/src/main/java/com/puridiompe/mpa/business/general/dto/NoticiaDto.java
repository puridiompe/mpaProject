package com.puridiompe.mpa.business.general.dto;

import java.util.Date;

public class NoticiaDto {
	private Integer idNoticia;
	private String titulo;
	private String contenido ;
	private Date fecPub;
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
	
	public Date getFecPub() {
		return fecPub;
	}
	public void setFecPub(Date fecPub) {
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
}
