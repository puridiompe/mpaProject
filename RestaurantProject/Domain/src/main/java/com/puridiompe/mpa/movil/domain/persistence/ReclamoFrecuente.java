package com.puridiompe.mpa.movil.domain.persistence;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.puridiompe.mpa.domain.persistence.utility.PersistenceAuditableEntity;

@Entity
@Table(name = "\"TrMov_RecFre\"")
public class ReclamoFrecuente extends PersistenceAuditableEntity<Integer>{

	@Id
	@Column(name = "\"idRecFre\"", unique = true, nullable = false)
	@SequenceGenerator(name = "reclamo_sequence", sequenceName = "\"TrMov_Reclamo_idRec_seq\"", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "reclamo_sequence")
	private Integer idReclamoFrecuente;
	
	@Column(name = "\"descripcion\"", nullable = false, length = 150)
	private String descripcion;
	
	
	public ReclamoFrecuente (){}
	
	public Integer getIdReclamoFrecuente() {
		return idReclamoFrecuente;
	}
	public void setIdReclamoFrecuente(Integer idReclamoFrecuente) {
		this.idReclamoFrecuente = idReclamoFrecuente;
	}

	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}	
}
