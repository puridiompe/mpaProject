package com.puridiompe.mpa.sistran.domain.persistence;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.jboss.logging.annotations.Field;

/**
 * 
 * @author Lucho
 *
 */

@Entity
@Table(name = "\"trgen_infracciones\"")
public class Infraccion {
	
	 @Id
	 @Column(name = "\"id\"", nullable = false, unique = true)
	 private Integer idInfraccion;
	 
	 @Column(name = "\"codigo\"", length = 7)
	 private String codigo;
	 
	 @Column(name = "\"descripcion\"")	 
	 private String descripcion;
	 
	 @Column(name = "\"gravedad\"", length = 20)
	 private String gravedad;
	 
	 @Column(name = "\"monto\"")
	 private BigDecimal monto;
	 
	 @Column(name = "\"descuento\"")
	 private BigDecimal descuento;
	 
	 @Column(name = "\"sancion\"")
	 private String sancion;
	 
	 @Column(name = "\"puntos\"")
	 private Integer puntos;
	 
	 @Column(name = "\"medprev\"")
	 private String medidaPreventiva;
	 
	 /**
	  * default constructor
	  */
	 
	 public Infraccion(){
		 
	 }
	 
	 /**
	  * Setters and Getters
	  * @return
	  */

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