package com.puridiompe.mpa.sistran.domain.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "\"TrPpe_RolUsu\"")
public class RolUsuario {
	@Id
	@Column(name = "\"usuario\"", nullable = false, unique = true, length = 50)
	private String idUsuario;
	
	//@Id
	@Column(name = "\"rol\"", length = 50)
	private String idRol;
	
	
	public RolUsuario(){}
	
	public void setIdUsuario(String idUsuario){
		this.idUsuario=idUsuario;
	}
	
	public void setIdRol(String idRol){
		this.idRol=idRol;
	}
		
	public String  getIdUsuario(){
		return this.idUsuario;
	}
	
	public String  getIdRol(){
		return this.idRol;
	}
}
