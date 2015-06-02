package com.puridiompe.mpa.papeletas.domain.persistence;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author PuridiomPe
 * @version 1.0
 * 
 *
 */
@Entity
@Table(name = "\"muni_conductor\"")
public class MuniConductor {

	@Id
	@Column(name = "\"nupap\"", length = 8)
	private String numeroPapeleta;
	
	@Column(name = "\"placa\"", length = 8)
	private String placa;
	
	@Column(name = "\"fecha\"", length = 20)
	private String fecha;
	
	@Column(name = "\"cdpar\"", length = 1)
	private String codigopar;
	
	@Column(name = "\"cdinf\"", length = 4)
	private String codigoInfraccion;
	
	@Column(name = "\"dsinf\"", length = 90)
	private String descripcionInfraccion;
	
	@Column(name = "\"monto\"", precision = 10, scale = 2)
	private BigDecimal monto;
	
	@Column(name = "\"rebaja\"", precision = 10, scale = 2)
	private BigDecimal rebaja;
	
	@Column(name = "\"valor\"", precision = 10, scale = 2)
	private BigDecimal valor;
	
	@Column(name = "\"clase\"", length = 20)
	private String clase;
	
	@Column(name = "\"marca\"", length = 30)
	private String marca;
	
	@Column(name = "\"modelo\"", length = 30)
	private String modelo;
	
	@Column(name = "\"estado\"", length = 20)
	private String estado;
	
	@Column(name = "\"licencia\"", length = 10)
	private String licencia;
	
	@Column(name = "\"cdpro\"", length = 8)
	private String codigoProceso;
	
	@Column(name = "\"nmcomplet1\"", length = 90)
	private String nombreCompleto1;
	
	@Column(name = "\"cdlic\"", length = 8)
	private String codigoLicencia;
	
	@Column(name = "\"nmcomplet2\"", length = 90)
	private String nombreCompleto2;
	
	@Column(name = "\"ndocide\"", length = 15)
	private String numeroDocumentoIdentificacion;
	
	@Column(name = "\"dsdomicili\"", length = 100)
	private String descripcionDomicilio;
	

	/**
	 * Default Constructor
	 */
	public MuniConductor() {

	}


	/**
	 * Getters and Setters
	 * @return
	 */
	public String getNumeroPapeleta() {
		return numeroPapeleta;
	}


	public void setNumeroPapeleta(String numeroPapeleta) {
		this.numeroPapeleta = numeroPapeleta;
	}


	public String getPlaca() {
		return placa;
	}


	public void setPlaca(String placa) {
		this.placa = placa;
	}


	public String getFecha() {
		return fecha;
	}


	public void setFecha(String fecha) {
		this.fecha = fecha;
	}


	public String getCodigopar() {
		return codigopar;
	}


	public void setCodigopar(String codigopar) {
		this.codigopar = codigopar;
	}


	public String getCodigoInfraccion() {
		return codigoInfraccion;
	}


	public void setCodigoInfraccion(String codigoInfraccion) {
		this.codigoInfraccion = codigoInfraccion;
	}


	public String getDescripcionInfraccion() {
		return descripcionInfraccion;
	}


	public void setDescripcionInfraccion(String descripcionInfraccion) {
		this.descripcionInfraccion = descripcionInfraccion;
	}


	public BigDecimal getMonto() {
		return monto;
	}


	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}


	public BigDecimal getRebaja() {
		return rebaja;
	}


	public void setRebaja(BigDecimal rebaja) {
		this.rebaja = rebaja;
	}


	public BigDecimal getValor() {
		return valor;
	}


	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}


	public String getClase() {
		return clase;
	}


	public void setClase(String clase) {
		this.clase = clase;
	}


	public String getMarca() {
		return marca;
	}


	public void setMarca(String marca) {
		this.marca = marca;
	}


	public String getModelo() {
		return modelo;
	}


	public void setModelo(String modelo) {
		this.modelo = modelo;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public String getLicencia() {
		return licencia;
	}


	public void setLicencia(String licencia) {
		this.licencia = licencia;
	}


	public String getCodigoProceso() {
		return codigoProceso;
	}


	public void setCodigoProceso(String codigoProceso) {
		this.codigoProceso = codigoProceso;
	}


	public String getNombreCompleto1() {
		return nombreCompleto1;
	}


	public void setNombreCompleto1(String nombreCompleto1) {
		this.nombreCompleto1 = nombreCompleto1;
	}


	public String getCodigoLicencia() {
		return codigoLicencia;
	}


	public void setCodigoLicencia(String codigoLicencia) {
		this.codigoLicencia = codigoLicencia;
	}


	public String getNombreCompleto2() {
		return nombreCompleto2;
	}


	public void setNombreCompleto2(String nombreCompleto2) {
		this.nombreCompleto2 = nombreCompleto2;
	}


	public String getNumeroDocumentoIdentificacion() {
		return numeroDocumentoIdentificacion;
	}


	public void setNumeroDocumentoIdentificacion(
			String numeroDocumentoIdentificacion) {
		this.numeroDocumentoIdentificacion = numeroDocumentoIdentificacion;
	}


	public String getDescripcionDomicilio() {
		return descripcionDomicilio;
	}


	public void setDescripcionDomicilio(String descripcionDomicilio) {
		this.descripcionDomicilio = descripcionDomicilio;
	}

}
