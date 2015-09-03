package com.puridiompe.mpa.sistran.domain.persistence;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "\"TrEsp_AutTraTra\"")
public class PermisoOperacionTrabajador {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "\"id\"", nullable = false, unique = true)
	private Integer id;
	
	@Column(name = "\"numAut\"")
	private Integer numeroAuto;
	
	@Column(name = "\"conductor\"")
	private Integer conductor;
	
	@Column(name = "\"vehiculo\"", length = 6)
	private String vehiculo;
	
	@Column(name = "\"fecEmi\"")
	private Date fechaEmision;
	
	@Column(name = "\"fecVen\"")
	private Date fechaVencimiento;
	
	@Column(name = "\"numRec\"")
	private String numeroRecibo;
	
	@Column(name = "\"fecPag\"")
	private Date fechaPago;
	
	@Column(name = "\"numImp\"")
	private Integer numeroImpuesto;
	
	@Column(name = "\"original\"")
	private boolean original;
	
	@Column(name = "\"numExp\"")
	private Integer numeroExpediente;
	
	@Column(name = "\"fecExp\"")
	private Date fechaExpiracion;
	
	@Column(name = "\"observaci\"")
	private String Observacion;
	
	@Column(name = "\"estado\"")
	private Integer estado;
	
	@Column(name = "\"usuario\"")
	private String Usuario;
	
	@Column(name = "\"fecAct\"")
	private Date fechaActivacion;

	
	/**
	 * Default Constructor
	 */
	public PermisoOperacionTrabajador(){
		
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

	public Integer getNumeroAuto() {
		return numeroAuto;
	}

	public void setNumeroAuto(Integer numeroAuto) {
		this.numeroAuto = numeroAuto;
	}

	public Integer getConductor() {
		return conductor;
	}

	public void setConductor(Integer conductor) {
		this.conductor = conductor;
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

	public String getNumeroRecibo() {
		return numeroRecibo;
	}

	public void setNumeroRecibo(String numeroRecibo) {
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

	public Integer getNumeroExpediente() {
		return numeroExpediente;
	}

	public void setNumeroExpediente(Integer numeroExpediente) {
		this.numeroExpediente = numeroExpediente;
	}

	public Date getFechaExpiracion() {
		return fechaExpiracion;
	}

	public void setFechaExpiracion(Date fechaExpiracion) {
		this.fechaExpiracion = fechaExpiracion;
	}

	public String getObservacion() {
		return Observacion;
	}

	public void setObservacion(String observacion) {
		Observacion = observacion;
	}

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public String getUsuario() {
		return Usuario;
	}

	public void setUsuario(String usuario) {
		Usuario = usuario;
	}

	public Date getFechaActivacion() {
		return fechaActivacion;
	}

	public void setFechaActivacion(Date fechaActivacion) {
		this.fechaActivacion = fechaActivacion;
	}
}
