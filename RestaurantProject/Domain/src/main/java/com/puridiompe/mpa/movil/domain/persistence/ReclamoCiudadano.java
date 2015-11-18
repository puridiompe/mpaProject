/**
 * 
 */
package com.puridiompe.mpa.movil.domain.persistence;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Johnny
 *
 */
@SuppressWarnings("serial")
public class ReclamoCiudadano implements Serializable {
	private Integer idReclamo;

	private Integer dni;

	private String descripcion;

	private String vehiculo;

	private String imei;

	private String codigo;

	private Date fechaCreacion;
	
	private String estadoReclamo;
	
	private String apellidoPaterno;

	private String apellidoMaterno;

	private String nombres;

	private String email;
	
	private String estadoCiudadano;
	

	public ReclamoCiudadano(Integer idReclamo, Integer dni, String descripcion, String vehiculo, String imei, 
			String codigo,Date fechaCreacion, String estadoReclamo, String apellidoPaterno, String apellidoMaterno, String nombres, String email, String estadoCiudadano) {
		this.idReclamo = idReclamo;
		this.dni = dni;
		this.descripcion = descripcion;
		this.vehiculo = vehiculo;
		this.imei = imei;
		this.codigo = codigo;
		this.fechaCreacion = fechaCreacion;
		this.estadoReclamo = estadoReclamo;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		this.nombres = nombres;
		this.email = email;
		this.estadoCiudadano = estadoCiudadano;
	}

	/**
	 * @return the idReclamo
	 */
	public Integer getIdReclamo() {
		return idReclamo;
	}

	/**
	 * @return the dni
	 */
	public Integer getDni() {
		return dni;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @return the vehiculo
	 */
	public String getVehiculo() {
		return vehiculo;
	}

	/**
	 * @return the imei
	 */
	public String getImei() {
		return imei;
	}

	/**
	 * @return the numeroReclamo
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * @return the apellidoPaterno
	 */
	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	/**
	 * @return the apellidoMaterno
	 */
	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	/**
	 * @return the nombres
	 */
	public String getNombres() {
		return nombres;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @return the fechaCreacion
	 */
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	
	/**
	 * @return the estadoReclamo
	 */
	public String getEstadoReclamo() {
		return estadoReclamo;
	}
	
	/**
	 * @return the estadoCiudadano
	 */
	public String getEstadoCiudadano() {
		return estadoCiudadano;
	}
}