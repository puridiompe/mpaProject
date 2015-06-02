package com.puridiompe.mpa.sistran.domain.persistence;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author PuridiomPe
 * @version 1.0
 * 
 *
 */

@Entity
@Table(name = "\"TrEsp_PerOpe\"")
public class PermisoOperacionEspecial {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "\"id\"", nullable = false, unique = true)
	private Integer id;
	
	@Column(name = "\"numPerOpe\"")
	private Integer numeroPermisoOperacion;
	
	@Column(name = "\"flota\"")
	private Integer flota;
	
	@Column(name = "\"vehiculo\"", length = 6)
	private String vehiculo;
	
	@Column(name = "\"fecEmi\"")
	private Date fechaEmision;
	
	@Column(name = "\"fecVen\"")
	private Date fechaVencimiento;
	
	@Column(name = "\"numRec\"")
	private Integer numeroRecibo;
	
	@Column(name = "\"fecPag\"")
	private Date fechaPago;
	
	@Column(name = "\"numImp\"")
	private Integer numeroImpuesto;
	
	@Column(name = "\"original\"")
	private boolean original;
	
	@Column(name = "\"tipOpe\"", length = 1)
	private String tipoOperacion;
	
	@Column(name = "\"numExp\"")
	private String numeroExpediente;
	
	@Column(name = "\"fecExp\"")
	private Date fechaExpiracion;
	
	@Column(name = "\"observaci\"")
	private String observacion;
	
	@Column(name = "\"estado\"")
	private Integer estado;
	
	@Column(name = "\"hisVeh\"")
	private Integer historiaVehiculo;
	
	@Column(name = "\"hisPro\"")
	private Integer historiaProceso;
	
	@Column(name = "\"usuario\"")
	private String usuario;
	
	@Column(name = "\"fecAct\"")
	private Date fechaActivacion;
	
	
	
	/**
	 * Default Constructor
	 */
	public PermisoOperacionEspecial() {
	
	}



	/**
	 * Getters and Setters
	 * @return
	 */
	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	
	public Integer getNumeroPermisoOperacion() {
		return numeroPermisoOperacion;
	}



	public void setNumeroPermisoOperacion(Integer numeroPermisoOperacion) {
		this.numeroPermisoOperacion = numeroPermisoOperacion;
	}



	public Integer getFlota() {
		return flota;
	}



	public void setFlota(Integer flota) {
		this.flota = flota;
	}



	public String getVehiculo() {
		return vehiculo;
	}



	public void setVehiculo(String vehiculo) {
		this.vehiculo = vehiculo;
	}



	public Date getFechaEmision() {
		return fechaEmision;
	}



	public void setFechaEmision(Date fechaEmision) {
		this.fechaEmision = fechaEmision;
	}



	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}



	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}



	public Integer getNumeroRecibo() {
		return numeroRecibo;
	}



	public void setNumeroRecibo(Integer numeroRecibo) {
		this.numeroRecibo = numeroRecibo;
	}



	public Date getFechaPago() {
		return fechaPago;
	}



	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}



	public Integer getNumeroImpuesto() {
		return numeroImpuesto;
	}



	public void setNumeroImpuesto(Integer numeroImpuesto) {
		this.numeroImpuesto = numeroImpuesto;
	}



	public boolean isOriginal() {
		return original;
	}



	public void setOriginal(boolean original) {
		this.original = original;
	}



	public String getTipoOperacion() {
		return tipoOperacion;
	}



	public void setTipoOperacion(String tipoOperacion) {
		this.tipoOperacion = tipoOperacion;
	}



	public String getNumeroExpediente() {
		return numeroExpediente;
	}



	public void setNumeroExpediente(String numeroExpediente) {
		this.numeroExpediente = numeroExpediente;
	}



	public Date getFechaExpiracion() {
		return fechaExpiracion;
	}



	public void setFechaExpiracion(Date fechaExpiracion) {
		this.fechaExpiracion = fechaExpiracion;
	}



	public String getObservacion() {
		return observacion;
	}



	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}



	public Integer getEstado() {
		return estado;
	}



	public void setEstado(Integer estado) {
		this.estado = estado;
	}



	public Integer getHistoriaVehiculo() {
		return historiaVehiculo;
	}



	public void setHistoriaVehiculo(Integer historiaVehiculo) {
		this.historiaVehiculo = historiaVehiculo;
	}



	public Integer getHistoriaProceso() {
		return historiaProceso;
	}



	public void setHistoriaProceso(Integer historiaProceso) {
		this.historiaProceso = historiaProceso;
	}



	public String getUsuario() {
		return usuario;
	}



	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}



	public Date getFechaActivacion() {
		return fechaActivacion;
	}



	public void setFechaActivacion(Date fechaActivacion) {
		this.fechaActivacion = fechaActivacion;
	}

	
}


