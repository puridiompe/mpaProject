package com.puridiompe.mpa.movil.domain.persistence;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.data.annotation.Transient;

import com.puridiompe.mpa.domain.persistence.utility.PersistenceAuditableEntity;

@SuppressWarnings("serial")
@Entity
@Table(name = "\"TrMov_Reclamo\"")
public class Reclamo extends PersistenceAuditableEntity<Integer>{
	
	@Id
	@Column(name = "\"idRec\"", unique = true, nullable = false)
	@SequenceGenerator(name = "reclamo_sequence", sequenceName = "\"TrMov_Reclamo_idRec_seq\"", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "reclamo_sequence")
	private Integer idReclamo;
	
	@Column(name = "\"dni\"", nullable = false)
	private Integer dni;
	
	@Column(name = "\"descripcion\"", nullable = false)
	private String descripcion;
	
	@Column(name = "\"vehiculo\"", nullable = false)
	private String vehiculo;
	
	@Column(name = "\"imei\"", length = 30, unique = true, nullable = false)
	private String imei;
	
	@Column(name = "\"numRec\"", length = 10, insertable = false)
	private String numRec;
	
	@Column(name = "\"latitud\"")
	private BigDecimal latitud;
	 
	@Column(name = "\"longitud\"")
	private BigDecimal longitud;
	
	
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

	public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

	
	public String getNumRec() {
		return numRec;
	}
	
	public void setNumRec(String numRec) {
		this.numRec = numRec;
	}


	public BigDecimal getLatitud() {
		return latitud;
	}


	public void setLatitud(BigDecimal latitud) {
		this.latitud = latitud;
	}


	public BigDecimal getLongitud() {
		return longitud;
	}


	public void setLongitud(BigDecimal longitud) {
		this.longitud = longitud;
	}

}
