package com.puridiompe.mpa.sistran.domain.persistence;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "\"TrEsp_AutTraEscVeh\"")
public class PermisoOperacionEscolar {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "\"id\"", nullable = false, unique = true)
	private Integer id;
	
	@Column(name = "\"numAut\"", nullable = false, unique = true)
	private Integer numeroAuto;
	
	@Column(name = "\"vehiculo\"", length = 6)
	private String vehiculo;
	
	@Column(name = "\"hisVeh\"")
	private Integer historialVehiculo;
	
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
	private boolean original ;
	
	@Column(name = "\"numExp\"")
	private String numeroExpediente;
	
	@Column(name = "\"fecExp\"")
	private Date fechaExpiracion;
	
	@Column(name = "\"observaci\"")
	private String observacion;
	
	@Column(name = "\"estado\"")
	private Integer estado;
	
	@Column(name = "\"ultimo\"", length = 1)
	private String ultimo;
	
	@Column(name = "\"usuario\"")
	private String usuario;
	
	@Column(name = "\"fecAct\"")
	private Date fechaActual;

	
	
	/**
	 * Default Constructor
	 */
	public PermisoOperacionEscolar() {
		
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

	public String getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(String vehiculo) {
		this.vehiculo = vehiculo;
	}

	public Integer getHistorialVehiculo() {
		return historialVehiculo;
	}

	public void setHistorialVehiculo(Integer historialVehiculo) {
		this.historialVehiculo = historialVehiculo;
	}

	public Date getFechaEmision(){
		return fechaEmision;
	}
	
	public void setFechaEmision(Date fechaEmision){
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

	public void setNumeroImpuesto(Integer numeroImp) {
		this.numeroImpuesto = numeroImp;
	}

	public boolean isOriginal() {
		return original;
	}

	public void setOriginal(boolean original) {
		this.original = original;
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

	public void setFechaExpiracion(Date fechaExpediente) {
		this.fechaExpiracion = fechaExpediente;
	}

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	
	public String getUltimo() {
		return ultimo;
	}

	public void setUltimo(String ultimo) {
		this.ultimo = ultimo;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	public Date getFechaActual(){
		return fechaActual;
	}
	
	public void setFechaActual(Date fechaActual){
		this.fechaActual = fechaActual;
	}
}
