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
@Table(name = "\"TrMov_InfFre\"")
public class InfraccionFrecuente extends PersistenceAuditableEntity<Integer>{
	
	@Id
	@Column(name = "\"idInfFre\"", unique = true, nullable = false)
	@SequenceGenerator(name = "infraccion_sequence", sequenceName = "\"TrMov_InfFre_idInfFre_seq\"", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "infraccion_sequence")
	private Integer idInfraccionFrecuente;
	
	@Column(name = "\"descripcion\"", nullable = false, length = 150)
	private String descripcion;
	
	public InfraccionFrecuente(){
		
	}

	public Integer getIdInfraccionFrecuente() {
		return idInfraccionFrecuente;
	}

	public void setIdInfraccionFrecuente(Integer idInfraccionFrecuente) {
		this.idInfraccionFrecuente = idInfraccionFrecuente;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
