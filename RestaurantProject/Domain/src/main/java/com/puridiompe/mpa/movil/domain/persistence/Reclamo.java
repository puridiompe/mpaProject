package com.puridiompe.mpa.movil.domain.persistence;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "\"TrMov_Reclamo\"")
public class Reclamo {
	
	@Id
	@Column(name = "\"idRec\"", unique = true, nullable = false)
	@SequenceGenerator(name = "reclamo_sequence", sequenceName = "\"TrMov_Reclamo_idRec_seq\"", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "reclamo_sequence")
	private Integer idReclamo;
	
	@Column(name = "\"dni\"", nullable = false)
	private Integer dni;
	
	@Column(name = "\"descripcion\"", nullable = false)
	private String descripcion;
	
	@Column(name = "\"vehiculo\"")
	private String vehiculo;
	
	@Column(name = "\"fecCre\"")
	private Date fechaCreacion;
	
	
	public Reclamo (){
		
	}
	
	
	public Integer getIdReclamo() {
		return idReclamo;
	}

	public void setIdReclamo(Integer idReclamo) {
		this.idReclamo = idReclamo;
	}

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(String vehiculo) {
		this.vehiculo = vehiculo;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
}
