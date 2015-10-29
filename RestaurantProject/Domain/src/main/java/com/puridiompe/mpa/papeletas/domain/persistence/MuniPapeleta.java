package com.puridiompe.mpa.papeletas.domain.persistence;

import java.math.BigDecimal;
import java.util.Date;

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
@Table(name = "\"muni_papeleta\"")
public class MuniPapeleta {

	@Id
	@Column(name = "\"nupap\"", length = 8)
	private String numeroPapeleta;
	
	@Column(name = "\"placa\"", length = 8)
	private String placa;
	
	@Column(name = "\"fecha\"")
	private Date fecha;
	
	@Column(name = "\"fecvenc\"")
	private Date fechaVencimiento;
	
	@Column(name = "\"cdpar\"", length = 1)
	private String codigopar;
	
	@Column(name = "\"cdinf\"", length = 4)
	private String codigoInfraccion;
	
	@Column(name = "\"dsinf\"", length = 90)
	private String descripcionInfraccion;
	
	@Column(name = "\"monto\"", precision = 10, scale = 2)
	private BigDecimal monto;
	
	@Column(name = "\"porce\"", length = 90)
	private String porcentaje;
	
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
	
	@Column(name = "\"nmcompleto\"", length = 90)
	private String nombreCompleto;
	
	@Column(name = "\"cdlic\"", length = 8)
	private String codigoLicencia;
	
	@Column(name = "\"nmcomplet1\"", length = 90)
	private String nombreCompleto1;
	
	@Column(name = "\"ndocide\"", length = 15)
	private String numeroDocumentoIdentificacion;
	
	@Column(name = "\"dsdomicili\"", length = 100)
	private String descripcionDomicilio;
	
	@Column(name = "\"duple\"", length = 1)
	private String duple;
	
	@Column(name = "\"cdco\"", length = 6)
	private String codigoCo;
	
	@Column(name = "\"cdde\"", length = 6)
	private String codigoDe;
	
	@Column(name = "\"peri\"", length = 4)
	private String peri;
	
	@Column(name = "\"cdex\"", length = 12)
	private String cedex;
	
	@Column(name = "\"nrdo\"", length = 12)
	private String numeroDo;
	
	@Column(name = "\"recibo\"", length = 9)
	private String recibo;
	
	@Column(name = "\"fecha1\"")
	private Date fecha1;
	
	@Column(name = "\"nroconst\"", length = 7)
	private String numeroConstante;
	
	@Column(name = "\"nrre\"")
	private BigDecimal nrre;
	
	@Column(name = "\"fere\"")
	private Date fere;
	
	@Column(name = "\"fecnot\"")
	private Date fecnot;
	
	
	/**
	 * Default Constructor
	 */
	public MuniPapeleta() {

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


	public Date getFecha() {
		return fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}


	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
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


	public String getPorcentaje() {
		return porcentaje;
	}


	public void setPorcentaje(String porcentaje) {
		this.porcentaje = porcentaje;
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


	public String getNombreCompleto() {
		return nombreCompleto;
	}


	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}


	public String getCodigoLicencia() {
		return codigoLicencia;
	}


	public void setCodigoLicencia(String codigoLicencia) {
		this.codigoLicencia = codigoLicencia;
	}


	public String getNombreCompleto1() {
		return nombreCompleto1;
	}


	public void setNombreCompleto1(String nombreCompleto1) {
		this.nombreCompleto1 = nombreCompleto1;
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


	public String getDuple() {
		return duple;
	}


	public void setDuple(String duple) {
		this.duple = duple;
	}


	public String getCodigoCo() {
		return codigoCo;
	}


	public void setCodigoCo(String codigoCo) {
		this.codigoCo = codigoCo;
	}


	public String getCodigoDe() {
		return codigoDe;
	}


	public void setCodigoDe(String codigoDe) {
		this.codigoDe = codigoDe;
	}


	public String getPeri() {
		return peri;
	}


	public void setPeri(String peri) {
		this.peri = peri;
	}


	public String getCedex() {
		return cedex;
	}


	public void setCedex(String cedex) {
		this.cedex = cedex;
	}


	public String getNumeroDo() {
		return numeroDo;
	}


	public void setNumeroDo(String numeroDo) {
		this.numeroDo = numeroDo;
	}


	public String getRecibo() {
		return recibo;
	}


	public void setRecibo(String recibo) {
		this.recibo = recibo;
	}


	public Date getFecha1() {
		return fecha1;
	}


	public void setFecha1(Date fecha1) {
		this.fecha1 = fecha1;
	}


	public String getNumeroConstante() {
		return numeroConstante;
	}


	public void setNumeroConstante(String numeroConstante) {
		this.numeroConstante = numeroConstante;
	}


	public BigDecimal getNrre() {
		return nrre;
	}


	public void setNrre(BigDecimal nrre) {
		this.nrre = nrre;
	}


	public Date getFere() {
		return fere;
	}


	public void setFere(Date fere) {
		this.fere = fere;
	}


	public Date getFecnot() {
		return fecnot;
	}


	public void setFecnot(Date fecnot) {
		this.fecnot = fecnot;
	}

}
