package com.puridiompe.mpa.movil.domain.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.puridiompe.mpa.domain.persistence.utility.PersistenceAuditableEntity;

@Entity
@Table(name = "\"TrMov_Acta\"")
public class Acta extends PersistenceAuditableEntity<Integer>{

	@Id
	@SequenceGenerator(name = "acta_sequence", sequenceName = "\"TrMov_Acta_idAct_seq\"", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "acta_sequence")
	@Column(name = "\"idAct\"", nullable = false)
	private Integer idActa;
	
	@Column(name = "\"numAct\"")
	private String numAct;
	
	@Column(name = "\"username\"", length = 30, nullable = false)
	private String username;
	
	@Column(name = "\"vehiculo\"", length = 6, nullable = false)
	private String vehiculo;
	
	@Column(name = "\"descripcion\"", nullable = false)
	private String descripcion;
	
	public Acta(){
		
	}

	public Integer getIdActa() {
		return idActa;
	}

	public void setIdActa(Integer idActa) {
		this.idActa = idActa;
	}

	public String getNumAct() {
		return numAct;
	}

	public void setNumAct(String numAct) {
		this.numAct = numAct;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(String vehiculo) {
		this.vehiculo = vehiculo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}
