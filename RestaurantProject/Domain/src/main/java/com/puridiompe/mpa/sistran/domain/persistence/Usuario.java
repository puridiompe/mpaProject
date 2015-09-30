package com.puridiompe.mpa.sistran.domain.persistence;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.puridiompe.mpa.domain.persistence.utility.PersistenceAuditableEntity;

/**
 * @author PuridiomPe
 * @version 1.0
 * 
 *
 */

@Entity
@Table(name = "\"TrMov_Usuario\"")

public class Usuario extends PersistenceAuditableEntity<Integer> {
	@Id
	@Column(name = "\"idUsu\"", nullable = false, unique = true)
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
}
