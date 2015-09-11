package com.puridiompe.mpa.business.general.dto;

import java.math.BigDecimal;


/**
 * 
 * @author Lucho
 *
 */

public class InfraccionDto {
	
	 private Integer idInfraccion;

	 private String codigo;	 

	 private String descripcion;
	 
	 private String gravedad;	 
	 
	 private BigDecimal monto;	 
	 
	 private BigDecimal descuento;	 
	 
	 private String sancion;	 
	 
	 private Integer puntos;	 
	 
	 private String medidaPreventiva;
	 
	 public InfraccionDto(){
		 
	 }

	public Integer getIdInfraccion() {
		return idInfraccion;
	}

	public void setIdInfraccion(Integer idInfraccion) {
		this.idInfraccion = idInfraccion;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getGravedad() {
		return gravedad;
	}

	public void setGravedad(String gravedad) {
		this.gravedad = gravedad;
	}

	public BigDecimal getMonto() {
		return monto;
	}

	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}

	public BigDecimal getDescuento() {
		return descuento;
	}

	public void setDescuento(BigDecimal descuento) {
		this.descuento = descuento;
	}

	public String getSancion() {
		return sancion;
	}

	public void setSancion(String sancion) {
		this.sancion = sancion;
	}

	public Integer getPuntos() {
		return puntos;
	}

	public void setPuntos(Integer puntos) {
		this.puntos = puntos;
	}

	public String getMedidaPreventiva() {
		return medidaPreventiva;
	}

	public void setMedidaPreventiva(String medidaPreventiva) {
		this.medidaPreventiva = medidaPreventiva;
	}

}