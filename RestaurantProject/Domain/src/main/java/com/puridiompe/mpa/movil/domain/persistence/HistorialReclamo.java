package com.puridiompe.mpa.movil.domain.persistence;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "\"TrMov_HisReclamo\"")
public class HistorialReclamo {
	
	
	@Id
	@SequenceGenerator(name = "historial_reclamo_sequence", sequenceName = "\"TrMov_HisReclamo_idHisRec_seq\"", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "historial_reclamo_sequence")
	@Column(name ="\"idHisRec\"" , nullable = false)
	private Integer idHistorialReclamo;
	
	@Column(name = "\"idRec\"" , nullable = false)
	private Integer idReclamo;
	
	@Column(name = "\"usuario\"",  nullable = true)
	private String usuario;
	
	@Column(name = "\"tipUsu\"",  nullable = true)
	private String tipoUsuario;
	
	@Column(name =  "\"accion\"")
	private String accion;
	
	@Column(name =  "\"descripcion\"")
	private String descripcion;
	
	@Column(name = "\"imei\"",  nullable = false)
	private String imei;
	
	@Column(name = "\"fecha\"", nullable = false)
	private Date fecha;

	public Integer getIdHistorialReclamo() {
		return idHistorialReclamo;
	}

	public void setIdHistorialReclamo(Integer idHistorialReclamo) {
		this.idHistorialReclamo = idHistorialReclamo;
	}

	public Integer getIdReclamo() {
		return idReclamo;
	}

	public void setIdReclamo(Integer idReclamo) {
		this.idReclamo = idReclamo;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public String getAccion() {
		return accion;
	}

	public void setAccion(String accion) {
		this.accion = accion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	
	
	
	

	
	
}
