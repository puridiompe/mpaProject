package com.puridiompe.mpa.sistran.domain.persistence;

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
	@Column(name = "\"login\"", nullable = false, unique = true, length = 50)
	private String idUsuario;
	
	@Column(name = "\"email\"", nullable = false,length = 100)
	private String email;
	
	@Column(name = "\"password\"", nullable = false,length = 100)
	private String password;
	
	@Column(name = "\"apePat\"", nullable = false,length = 100)
	private String apellidoPaterno;
	
	@Column(name = "\"apeMat\"", length = 100)
	private String apellidoMaterno;
	
	@Column(name = "\"nombres\"", nullable = false,length = 100)
	private String nombres;
	
	
	public Usuario(){}
	
	public void setIdUsuario(String idUsuario){
		this.idUsuario = idUsuario;
	}
	public void setEmail(String email){
		this.email=email;
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
	
	public String getIdUsuario(){
		return this.idUsuario;
	}
	
	public String getEmail(){
		return this.email;
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
	
}
