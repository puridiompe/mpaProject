package com.puridiompe.mpa.sistran.domain.persistence;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author PuridiomPe
 * @version 1.0
 * 
 *
 */

@Entity
@Table(name = "\"TrPpe_Usuario\"")

public class Usuario {
	@Id
	@Column(name = "\"idUsuario\"", nullable = false, unique = true)
	private Integer idUsuario;
	
	@Column(name = "\"username\"", nullable = false,length = 100)
	private String username;
	
	@Column(name = "\"password\"", nullable = false,length = 100)
	private String password;
	
	@Column(name = "\"apePat\"", nullable = false,length = 100)
	private String apellidoPaterno;
	
	@Column(name = "\"apeMat\"", length = 100)
	private String apellidoMaterno;
	
	@Column(name = "\"nombres\"", nullable = false,length = 100)
	private String nombres;
	
	@Column(name = "\"estado\"", nullable = false)
	private Boolean  estado;
	
	@Column(name = "\"fecCre\"", nullable = false)
	private Date fecCre;
	
	@Column(name = "\"fecMod\"", nullable = true)
	private Date fecMod;
	
	public Usuario(){}
	
	public void setIdUsuario(Integer idUsuario){
		this.idUsuario = idUsuario;
	}
	public void setUsername(String email){
		this.username=email;
	}
	
	public void setPassword(String password){
		this.password= password;
	}
	
	public void setApellidoPaterno(String apellidoPaterno){
		this.apellidoPaterno=apellidoPaterno;
	}
	
	public void setApellidoMaterno(String apellidoMaterno){
		this.apellidoMaterno=apellidoMaterno;
	}
	
	public void setNombres(String nombres){
		this.nombres= nombres;
	}
	
	public Integer getIdUsuario(){
		return this.idUsuario;
	}
	
	public String getUsername(){
		return this.username;
	}
	
	public String getPassword(){
		return this.password;
	}
	
	public String getApellidoPaterno(){
		return this.apellidoPaterno;
	}
	
	public String getApellidoMaterno(){
		return this.apellidoMaterno;
	}
	
	public String getNombres(){
		return this.nombres;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
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
	
}
