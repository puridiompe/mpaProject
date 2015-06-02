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
@Table(name = "\"TrUrb_PerOpe\"")
public class PermisoOperacionUrbano {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "\"id\"", nullable = false, unique = true)
	private Integer id;
	
	@Column(name = "\"numero\"")
	private Integer numero;
	
	@Column(name = "\"liquidaci\"")
	private Integer liquidacion;
	
	@Column(name = "\"detLiq\"")
	private Integer detalleLiquidacion;
	
	@Column(name = "\"flota\"")
	private Integer flota;
	
	@Column(name = "\"hisEmp\"")
	private Integer historiaEmpresa;
	
	@Column(name = "\"colEmp\"")
	private String colorEmpresa;
	
	@Column(name = "\"hisSoc\"")
	private Integer historicoSocial;
	
	@Column(name = "\"hisVeh\"")
	private Integer historiaVehiculo;
	
	@Column(name = "\"hisPro\"")
	private Integer historiaProceso;
	
	@Column(name = "\"colVeh\"")
	private String colorVehiculo;
	
	@Column(name = "\"autorizac\"")
	private Integer autorizacion;
	
	@Column(name = "\"hisRut\"")
	private Integer historiaRuta;
	
	@Column(name = "\"cerConEmi\"")
	private Integer certificadoConducirEmitido;
	
	@Column(name = "\"fecEmi\"")
	private Date fechaEmision;
	
	@Column(name = "\"fecIni\"")
	private Date fechaInicio;
	
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
	
	@Column(name = "\"observaci\"")
	private String obsevacion;
	
	@Column(name = "\"estado\"")
	private Integer estado;
	
	@Column(name = "\"usuario\"")
	private String usuario;
	
	@Column(name = "\"fecAct\"")
	private Date fechaActivacion;
	
	
	
	/**
	 * Default Constructor
	 */
	public PermisoOperacionUrbano() {
	
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



	public Integer getNumero() {
		return numero;
	}



	public void setNumero(Integer numero) {
		this.numero = numero;
	}



	public Integer getLiquidacion() {
		return liquidacion;
	}



	public void setLiquidacion(Integer liquidacion) {
		this.liquidacion = liquidacion;
	}



	public Integer getDetalleLiquidacion() {
		return detalleLiquidacion;
	}



	public void setDetalleLiquidacion(Integer detalleLiquidacion) {
		this.detalleLiquidacion = detalleLiquidacion;
	}



	public Integer getFlota() {
		return flota;
	}



	public void setFlota(Integer flota) {
		this.flota = flota;
	}



	public Integer getHistoriaEmpresa() {
		return historiaEmpresa;
	}



	public void setHistoriaEmpresa(Integer historiaEmpresa) {
		this.historiaEmpresa = historiaEmpresa;
	}



	public String getColorEmpresa() {
		return colorEmpresa;
	}



	public void setColorEmpresa(String colorEmpresa) {
		this.colorEmpresa = colorEmpresa;
	}



	public Integer getHistoricoSocial() {
		return historicoSocial;
	}



	public void setHistoricoSocial(Integer historicoSocial) {
		this.historicoSocial = historicoSocial;
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



	public String getColorVehiculo() {
		return colorVehiculo;
	}



	public void setColorVehiculo(String colorVehiculo) {
		this.colorVehiculo = colorVehiculo;
	}



	public Integer getAutorizacion() {
		return autorizacion;
	}



	public void setAutorizacion(Integer autorizacion) {
		this.autorizacion = autorizacion;
	}



	public Integer getHistoriaRuta() {
		return historiaRuta;
	}



	public void setHistoriaRuta(Integer historiaRuta) {
		this.historiaRuta = historiaRuta;
	}



	public Integer getCertificadoConducirEmitido() {
		return certificadoConducirEmitido;
	}



	public void setCertificadoConducirEmitido(Integer certificadoConducirEmitido) {
		this.certificadoConducirEmitido = certificadoConducirEmitido;
	}



	public Date getFechaEmision() {
		return fechaEmision;
	}



	public void setFechaEmision(Date fechaEmision) {
		this.fechaEmision = fechaEmision;
	}



	public Date getFechaInicio() {
		return fechaInicio;
	}



	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
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



	public String getObsevacion() {
		return obsevacion;
	}



	public void setObsevacion(String obsevacion) {
		this.obsevacion = obsevacion;
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


}


