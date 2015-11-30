
package com.puridiompe.mpa.business.general.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Johnny
 *
 */
public class VehiculoDto {

	private String idPlaca;

	private String numeroTarjetaPropiedad;

	private Integer departamento;

	private String numeroExpediente;

	private Date fechaInscripcion;

	private Date fechaProceso;

	private Integer categoria;

	private Integer claseCategoria;

	private Integer clase;

	private String marca;

	private String modelo;
	
	private String color;

	private Integer anioFabricacion;

	private Integer combustible;

	private Integer carroceria;

	private Integer ejes;

	private String numeroMotor;

	private Integer cilindros;

	private String numeroSerie;

	private Integer ruedas;

	private Integer pasajeros;

	private Integer asientos;

	private BigDecimal pesSec;

	private BigDecimal pesoBruto;

	private BigDecimal longitud;

	private BigDecimal altura;

	private BigDecimal ancho;

	private BigDecimal carUti;

	private String observacion;

	private String placaAntigua;

	private List<PropietarioDto> propietarios;

	public VehiculoDto() {
		this.propietarios = new ArrayList<PropietarioDto>();
	}

	/**
	 * Getters and Setters
	 * 
	 * @return
	 */
	public String getIdPlaca() {
		return idPlaca;
	}

	public void setIdPlaca(String idPlaca) {
		this.idPlaca = idPlaca;
	}

	public String getNumeroTarjetaPropiedad() {
		return numeroTarjetaPropiedad;
	}

	public void setNumeroTarjetaPropiedad(String numeroTarjetaPropiedad) {
		this.numeroTarjetaPropiedad = numeroTarjetaPropiedad;
	}

	public Integer getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Integer departamento) {
		this.departamento = departamento;
	}

	public String getNumeroExpediente() {
		return numeroExpediente;
	}

	public void setNumeroExpediente(String numeroExpediente) {
		this.numeroExpediente = numeroExpediente;
	}

	public Date getFechaInscripcion() {
		return fechaInscripcion;
	}

	public void setFechaInscripcion(Date fechaInscripcion) {
		this.fechaInscripcion = fechaInscripcion;
	}

	public Date getFechaProceso() {
		return fechaProceso;
	}

	public void setFechaProceso(Date fechaProceso) {
		this.fechaProceso = fechaProceso;
	}

	public Integer getCategoria() {
		return categoria;
	}

	public void setCategoria(Integer categoria) {
		this.categoria = categoria;
	}

	public Integer getClaseCategoria() {
		return claseCategoria;
	}

	public void setClaseCategoria(Integer claseCategoria) {
		this.claseCategoria = claseCategoria;
	}

	public Integer getClase() {
		return clase;
	}

	public void setClase(Integer clase) {
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
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Integer getAnioFabricacion() {
		return anioFabricacion;
	}

	public void setAnioFabricacion(Integer anioFabricacion) {
		this.anioFabricacion = anioFabricacion;
	}

	public Integer getCombustible() {
		return combustible;
	}

	public void setCombustible(Integer combustible) {
		this.combustible = combustible;
	}

	public Integer getCarroceria() {
		return carroceria;
	}

	public void setCarroceria(Integer carroceria) {
		this.carroceria = carroceria;
	}

	public Integer getEjes() {
		return ejes;
	}

	public void setEjes(Integer ejes) {
		this.ejes = ejes;
	}

	public String getNumeroMotor() {
		return numeroMotor;
	}

	public void setNumeroMotor(String numeroMotor) {
		this.numeroMotor = numeroMotor;
	}

	public Integer getCilindros() {
		return cilindros;
	}

	public void setCilindros(Integer cilindros) {
		this.cilindros = cilindros;
	}

	public String getNumeroSerie() {
		return numeroSerie;
	}

	public void setNumeroSerie(String numeroSerie) {
		this.numeroSerie = numeroSerie;
	}

	public Integer getRuedas() {
		return ruedas;
	}

	public void setRuedas(Integer ruedas) {
		this.ruedas = ruedas;
	}

	public Integer getPasajeros() {
		return pasajeros;
	}

	public void setPasajeros(Integer pasajeros) {
		this.pasajeros = pasajeros;
	}

	public Integer getAsientos() {
		return asientos;
	}

	public void setAsientos(Integer asientos) {
		this.asientos = asientos;
	}

	public BigDecimal getPesSec() {
		return pesSec;
	}

	public void setPesSec(BigDecimal pesSec) {
		this.pesSec = pesSec;
	}

	public BigDecimal getPesoBruto() {
		return pesoBruto;
	}

	public void setPesoBruto(BigDecimal pesoBruto) {
		this.pesoBruto = pesoBruto;
	}

	public BigDecimal getLongitud() {
		return longitud;
	}

	public void setLongitud(BigDecimal longitud) {
		this.longitud = longitud;
	}

	public BigDecimal getAltura() {
		return altura;
	}

	public void setAltura(BigDecimal altura) {
		this.altura = altura;
	}

	public BigDecimal getAncho() {
		return ancho;
	}

	public void setAncho(BigDecimal ancho) {
		this.ancho = ancho;
	}

	public BigDecimal getCarUti() {
		return carUti;
	}

	public void setCarUti(BigDecimal carUti) {
		this.carUti = carUti;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public String getPlacaAntigua() {
		return placaAntigua;
	}

	public void setPlacaAntigua(String placaAntigua) {
		this.placaAntigua = placaAntigua;
	}

	/**
	 * @return the propietarios
	 */
	public List<PropietarioDto> getPropietarios() {
		return propietarios;
	}

	/**
	 * @param propietarios
	 *            the propietarios to set
	 */
	public void setPropietarios(List<PropietarioDto> propietarios) {
		this.propietarios = propietarios;
	}
}
