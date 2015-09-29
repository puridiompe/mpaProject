package com.puridiompe.mpa.sistran.domain.persistence;

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
@Table(name = "\"TrGen_Vehiculo\"")
public class Vehiculo{

	@Id
	@Column(name = "\"placa\"", nullable = false, unique = true, length = 6)
	private String idPlaca;
	
	@Column(name = "\"numTarPro\"", length = 9)
	private String numeroTarjetaPropiedad;
	
	@Column(name = "\"departame\"")
	private Integer departamento;
	
	@Column(name = "\"numExp\"", length = 4)
	private String numeroExpediente;
	
	@Column(name = "\"fecIns\"")
	private Date fechaInscripcion;
	
	@Column(name = "\"fecPro\"")
	private Date fechaProceso;
	
	@Column(name = "\"categoria\"")
	private Integer categoria;
	
	@Column(name = "\"claCat\"")
	private Integer claseCategoria;
	
	@Column(name = "\"clase\"")
	private Integer clase;
	
	@Column(name = "\"marca\"")
	private Integer marca;
	
	@Column(name = "\"modelo\"")
	private String modelo;
	
	@Column(name = "\"añoFab\"")
	private Integer anioFabricacion;
	
	@Column(name = "\"combustib\"")
	private Integer combustible;
	
	@Column(name = "\"carroceri\"")
	private Integer carroceria;
	
	@Column(name = "\"ejes\"")
	private Integer ejes;
	
	@Column(name = "\"numMot\"")
	private String numeroMotor;
	
	@Column(name = "\"cilindros\"")
	private Integer cilindros;
	
	@Column(name = "\"numSer\"")
	private String numeroSerie;
	
	@Column(name = "\"ruedas\"")
	private Integer ruedas;
	
	@Column(name = "\"pasajeros\"")
	private Integer pasajeros;
	
	@Column(name = "\"asientos\"")
	private Integer asientos;
	
	@Column(name = "\"pesSec\"")
	private BigDecimal pesSec;
	
	@Column(name = "\"pesBru\"")
	private BigDecimal pesoBruto;
	
	@Column(name = "\"longitud\"")
	private BigDecimal longitud;
	
	@Column(name = "\"altura\"")
	private BigDecimal altura;
	
	@Column(name = "\"ancho\"")
	private BigDecimal ancho;
	
	@Column(name = "\"carUti\"")
	private BigDecimal carUti;
	
	@Column(name = "\"observaci\"")
	private String observacion;
	
	@Column(name = "\"estado\"")
	private Integer estado;
	
	@Column(name = "\"usuario\"")
	private String usuario;
	
	@Column(name = "\"fecAct\"")
	private Date fechaActivacion;
	
	@Column(name = "\"placa_antigua\"")
	private String placaAntigua;
	
	
	/**
	 * Default Constructor
	 */
	public Vehiculo() {
	
	}

	
	/**
	 * Getters and Setters
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

	public Integer getMarca() {
		return marca;
	}

	public void setMarca(Integer marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
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

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
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

	public String getPlacaAntigua() {
		return placaAntigua;
	}

	public void setPlacaAntigua(String placaAntigua) {
		this.placaAntigua = placaAntigua;
	}
	
}


