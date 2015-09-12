package com.puridiompe.mpa.sistran.domain.persistence;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.puridiompe.mpa.common.security.SystemRole;

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
	@Column(name = "\"idRol\"", nullable = false, unique = true)
	private Integer idRol;
	
	@Column(name = "\"rol\"", nullable = false, unique = true, length = 50)
	private String rol;
	
	@Column(name = "\"estado\"", nullable = false)
	private Boolean estado;
	
	@Column(name = "\"fecCre\"", nullable = false)
	private Date fecCre;
	
	@Column(name = "\"fecMod\"", nullable = true)
	private Date fecMod;
	
	public Rol(){}
	
	public void setIdRol(Integer idRol){
		this.idRol=idRol;
	}
	
	public Integer  getIdRol(){
		return this.idRol;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
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
