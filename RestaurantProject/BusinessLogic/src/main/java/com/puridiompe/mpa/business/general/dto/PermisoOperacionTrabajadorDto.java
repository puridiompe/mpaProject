package com.puridiompe.mpa.business.general.dto;

import java.util.Date;


public class PermisoOperacionTrabajadorDto {

		private Integer id;
		
		private Integer numeroAuto;
		
		private Integer conductor;
		
		private String vehiculo;
		
		private Date fechaEmision;
		
		private Date fechaVencimiento;
		
		private String numeroRecibo;
		
		private Date fechaPago;
		
		private Integer numeroImpuesto;
		
		private boolean original;
		
		private Integer numeroExpediente;
		
		private Date fechaExpiracion;
		
		private String Observacion;
		
		private Integer estado;
		
		private String Usuario;
		
		private Date fechaActivacion;

		
		/**
		 * Default Constructor
		 */
		public PermisoOperacionTrabajadorDto(){
			
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
