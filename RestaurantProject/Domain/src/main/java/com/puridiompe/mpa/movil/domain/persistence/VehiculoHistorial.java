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
@Table(name = "\"TrMov_HisConVeh\"")
public class VehiculoHistorial {
	
	@Id
	@SequenceGenerator(name = "vehiculohistorial_sequence", sequenceName = "\"TrMov_HisConVeh_idHisConVeh_seq\"", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "vehiculohistorial_sequence")
	@Column(name = "\"idHisConVeh\"", unique=true, nullable=false)
	private Integer idHistorial;
	
	@Column(name = "\"username\"", nullable = false)
	private String usuario;
	
	@Column(name = "\"vehiculo\"", nullable = false)
	private String vehiculo;
	
	@Column(name = "\"imei\"", nullable = false)
	private String imei;
	
	@Column(name = "\"fecha\"", nullable = false)
	private Date fecha;
	
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

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
}
