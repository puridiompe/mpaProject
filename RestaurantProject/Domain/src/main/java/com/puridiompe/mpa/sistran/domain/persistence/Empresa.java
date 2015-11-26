package com.puridiompe.mpa.sistran.domain.persistence;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "\"TrGen_Empresa\"")
public class Empresa {

	@Id
	@Column(name = "\"codigo\"", nullable = false, unique = true)
	private String codigo;
	
	@Column(name = "\"codAnt\"")
	private String codAnt;
	
	@Column(name = "\"tipo\"")
	private Integer tipo;
	
	@Column(name = "\"ruc\"")
	private String ruc;
	
	@Column(name = "\"razSoc\"")
	private String razonSocial;
	
	@Column(name = "\"direccion\"")
	private String direccion;
	
	@Column(name = "\"distrito\"")
	private Integer distrito;
	
	@Column(name = "\"telefono\"")
	private String telefono;
	
	@Column(name = "\"telCom\"")
	private String telCom;
	
	@Column(name = "\"represent\"")
	private Integer represent;
	
	@Column(name = "\"fecReg\"")
	private Date fecReg;
	
	@Column(name = "\"fecCes\"")
	private Date fecCes;
	
	@Column(name = "\"sindicato\"")
	private String sindicato;
	
	@Column(name = "\"observaci\"")
	private String observacion;
	
	@Column(name = "\"numExp\"")
	private String numeroExpediente;
	
	@Column(name = "\"numParReg\"")
	private String numParReg;
	
	@Column(name = "\"numDoc\"")
	private String numeroDocumento;
	
	@Column(name = "\"fecDoc\"")
	private Date fechaDocumento;
	
	@Column(name = "\"estado\"")
	private Integer estado;
	
	@Column(name = "\"imgCas\"")
	private String imgCas;
	
	@Column(name = "\"desPar\"")
	private String desPar;
	
	@Column(name = "\"imgPar\"")
	private String imgPar;
	
	@Column(name = "\"usuario\"")
	private String usuario;
	
	@Column(name = "\"fecAct\"")
	private Date fecAct;
	
	public Empresa(){
		
	}

	public String getCodigo() {
		return codigo;
	}

	public String getCodAnt() {
		return codAnt;
	}

	public Integer getTipo() {
		return tipo;
	}

	public String getRuc() {
		return ruc;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public String getDireccion() {
		return direccion;
	}

	public Integer getDistrito() {
		return distrito;
	}

	public String getTelefono() {
		return telefono;
	}

	public String getTelCom() {
		return telCom;
	}

	public Integer getRepresent() {
		return represent;
	}

	public Date getFecReg() {
		return fecReg;
	}

	public Date getFecCes() {
		return fecCes;
	}

	public String getSindicato() {
		return sindicato;
	}

	public String getObservacion() {
		return observacion;
	}

	public String getNumeroExpediente() {
		return numeroExpediente;
	}

	public String getNumParReg() {
		return numParReg;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public Date getFechaDocumento() {
		return fechaDocumento;
	}

	public Integer getEstado() {
		return estado;
	}

	public String getImgCas() {
		return imgCas;
	}

	public String getDesPar() {
		return desPar;
	}

	public String getImgPar() {
		return imgPar;
	}

	public String getUsuario() {
		return usuario;
	}

	public Date getFecAct() {
		return fecAct;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public void setCodAnt(String codAnt) {
		this.codAnt = codAnt;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public void setDistrito(Integer distrito) {
		this.distrito = distrito;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public void setTelCom(String telCom) {
		this.telCom = telCom;
	}

	public void setRepresent(Integer represent) {
		this.represent = represent;
	}

	public void setFecReg(Date fecReg) {
		this.fecReg = fecReg;
	}

	public void setFecCes(Date fecCes) {
		this.fecCes = fecCes;
	}

	public void setSindicato(String sindicato) {
		this.sindicato = sindicato;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public void setNumeroExpediente(String numeroExpediente) {
		this.numeroExpediente = numeroExpediente;
	}

	public void setNumParReg(String numParReg) {
		this.numParReg = numParReg;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public void setFechaDocumento(Date fechaDocumento) {
		this.fechaDocumento = fechaDocumento;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public void setImgCas(String imgCas) {
		this.imgCas = imgCas;
	}

	public void setDesPar(String desPar) {
		this.desPar = desPar;
	}

	public void setImgPar(String imgPar) {
		this.imgPar = imgPar;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public void setFecAct(Date fecAct) {
		this.fecAct = fecAct;
	}
	
}
