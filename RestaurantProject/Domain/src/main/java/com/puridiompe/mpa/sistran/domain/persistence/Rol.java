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
@Table(name = "\"TrPpe_Rol\"")
public class Rol {
	@Id
	@Column(name = "\"rol\"", nullable = false, unique = true, length = 50)
	private String idRol;
	
	public Rol(){}
	
	public void setIdRol(String idRol){
		this.idRol=idRol;
	}
	
	public String  getIdRol(){
		return this.idRol;
	}
}
