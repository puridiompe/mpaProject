package com.puridiompe.mpa.sistran.domain.persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;


@Entity
//@IdClass(value=RolUsuario.RolUsuarioId.class)
@Table(name = "\"TrPpe_RolUsu\"")
public class RolUsuario {

	//@Id
	@Column(name = "\"idUsuario\"", nullable = false)
	private Integer idUsuario;
	
	@Id
	@Column(name = "\"idRol\"", nullable = false)
	private Integer idRol;
	
	@Column(name = "\"estado\"", nullable = false)
	private Boolean estado;
	
	@Column(name = "\"fecCre\"", nullable = false)
	private Date fecCre;
	
	@Column(name = "\"fecMod\"", nullable = true)
	private Date fecMod;
	
	
	public RolUsuario(){}
	
	
	public Integer  getIdUsuario(){ 
		return this.idUsuario;
	}
	public void setIdUsuario(Integer idUsuario){
		this.idUsuario=idUsuario;
	}
	

	public Integer  getIdRol(){
		return this.idRol;
	}
	public void setIdRol(Integer idRol){
		this.idRol=idRol;
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
	
	static class RolUsuarioId implements Serializable {
        private Integer idUsuario;
        private Integer idRol;

        public Integer getIdUsuario(){ return idUsuario; }
        public void setIdUsuario(Integer idUsuario){ this.idUsuario = idUsuario; }

        public Integer getIdRol(){ return idRol; }
        public void setIdRol(Integer idRol){ this.idRol = idRol; }

        // implement equals(), hashcode()
    }
	
	
}
