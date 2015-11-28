package com.puridiompe.mpa.sistran.domain.persistence;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "\"TrUrb_HisRut\"")
public class HisRuta {
	
	@Id
	@Column(name = "\"idHis\"", nullable = false, unique = true, length = 6)
	private Integer idHis;
	
	@Column(name = "\"id\"")
	private Integer id;
	
	@Column(name = "\"circuito\"")
	private Integer circuito;
	
	@Column(name = "\"codigo\"")
	private String codigo;
	
	@Column(name = "\"descripci\"")
	private String descripcion;
	
	@Column(name = "\"terminal\"")
	private String terminal;
	
	@Column(name = "\"numDoc\"")
	private String numeroDocumento;
	
	@Column(name = "\"fecDoc\"")
	private Date fechaDocumento;
	
	@Column(name = "\"recIda\"")
	private String recorridoIda;
	
	@Column(name = "\"recVue\"")
	private String recorridoVuelta;
	
	@Column(name = "\"observaci\"")
	private String observacion;
	
	@Column(name = "\"estado\"")
	private Integer estado;
	
	@Column(name = "\"usuario\"")
	private String usuario;
	
	@Column(name = "\"fecAct\"")
	private Date fechaActual;
	
	@Column(name = "\"operacion\"")
	private String operacion;
	
	public HisRuta(){
	
	}

	public Integer getIdHis() {
		return idHis;
	}

	public void setIdHis(Integer idHis) {
		this.idHis = idHis;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCircuito() {
		return circuito;
	}

	public void setCircuito(Integer circuito) {
		this.circuito = circuito;
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

	public String getTerminal() {
		return terminal;
	}

	public void setTerminal(String terminal) {
		this.terminal = terminal;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public Date getFechaDocumento() {
		return fechaDocumento;
	}

	public void setFechaDocumento(Date fechaDocumento) {
		this.fechaDocumento = fechaDocumento;
	}

	public String getRecorridoIda() {
		return recorridoIda;
	}

	public void setRecorridoIda(String recorridoIda) {
		this.recorridoIda = recorridoIda;
	}

	public String getRecorridoVuelta() {
		return recorridoVuelta;
	}

	public void setRecorridoVuelta(String recorridoVuelta) {
		this.recorridoVuelta = recorridoVuelta;
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

	public Date getFechaActual() {
		return fechaActual;
	}

	public void setFechaActual(Date fechaActual) {
		this.fechaActual = fechaActual;
	}

	public String getOperacion() {
		return operacion;
	}

	public void setOperacion(String operacion) {
		this.operacion = operacion;
	}
	
}
