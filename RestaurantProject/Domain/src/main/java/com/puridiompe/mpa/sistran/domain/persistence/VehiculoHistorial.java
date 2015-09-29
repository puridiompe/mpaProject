package com.puridiompe.mpa.sistran.domain.persistence;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "\"TrGen_Vehiculo_His\"")
public class VehiculoHistorial {
	
	@Id
	@SequenceGenerator(name = "pk_sequence", sequenceName = "trgen_vehiculo_his_id", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "pk_sequence")
	@Column(name = "\"idloghist\"", unique=true, nullable=false)
	private Integer idHistorial;
	
	@Column(name = "\"username\"", nullable = false)
	private String usuario;
	
	@Column(name = "\"vehiculo\"", nullable = false)
	private String vehiculo;
	
	@Column(name = "\"imei\"", nullable = false)
	private String imei;
	
	@Column(name = "\"fechaHora\"", nullable = false)
	private Date fechaHora;
	
	/**
	 * Default Constructor
	 */
	public VehiculoHistorial(){
		
	}

	/**
	 * Getters and Setters
	 * @return
	 */
	public Integer getIdHistorial() {
		return idHistorial;
	}

	public void setIdHistorial(Integer idHistorial) {
		this.idHistorial = idHistorial;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
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

	public Date getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(Date fechaHora) {
		this.fechaHora = fechaHora;
	}
	
}
