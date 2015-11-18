package com.puridiompe.mpa.business.general.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReclamoDto {

	private Integer idReclamo;
	
	private Integer dni;
	
	private String nombres;
	
	private String apellidoPaterno;
	
	private String apellidoMaterno;
	
	private String email;
	
	private String descripcion;
	
	private String vehiculo;
	
	private Date fechaCreacion;
//	
//	private Date fechaModificacion;
	
	private List<String> imagenesBase64;
	
	private String imei;
	
//	private String estado;
	
	private String estadoReclamo;
	
	private String estadoCiudadano;
	
	private String codigo;
	
	private BigDecimal latitud;	 
	
	private BigDecimal longitud;
	
	private ResumenImagenDto resumenImagen;
	
	private List<ReclamoComentarioDto> comentarios;
	

	
/////////////////////////////////////////////////////////
	private String numRec;
	
	private List<ReclamoComentarioDto> reclamoComentarios;
	
	
	public ReclamoDto (){
		imagenesBase64 = new ArrayList<String>();		
	}

	/**
	 * @return the idReclamo
	 */
	public Integer getIdReclamo() {
		return idReclamo;
	}

	/**
	 * @param idReclamo the idReclamo to set
	 */
	public void setIdReclamo(Integer idReclamo) {
		this.idReclamo = idReclamo;
	}

	/**
	 * @return the dni
	 */
	public Integer getDni() {
		return dni;
	}

	/**
	 * @param dni the dni to set
	 */
	public void setDni(Integer dni) {
		this.dni = dni;
	}

	/**
	 * @return the nombres
	 */
	public String getNombres() {
		return nombres;
	}

	/**
	 * @param nombres the nombres to set
	 */
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	/**
	 * @return the apellidoPaterno
	 */
	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	/**
	 * @param apellidoPaterno the apellidoPaterno to set
	 */
	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	/**
	 * @return the apellidoMaterno
	 */
	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	/**
	 * @param apellidoMaterno the apellidoMaterno to set
	 */
	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return the vehiculo
	 */
	public String getVehiculo() {
		return vehiculo;
	}

	/**
	 * @param vehiculo the vehiculo to set
	 */
	public void setVehiculo(String vehiculo) {
		this.vehiculo = vehiculo;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	/**
	 * @return the imagenesBase64
	 */
	public List<String> getImagenesBase64() {
		return imagenesBase64;
	}

	/**
	 * @param imagenesBase64 the imagenesBase64 to set
	 */
	public void setImagenesBase64(List<String> imagenesBase64) {
		this.imagenesBase64 = imagenesBase64;
	}

	/**
	 * @return the imei
	 */
	public String getImei() {
		return imei;
	}

	/**
	 * @param imei the imei to set
	 */
	public void setImei(String imei) {
		this.imei = imei;
	}

	/**
	 * @return the estado
	 */
	public String getEstadoReclamo() {
		return estadoReclamo;
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstadoReclamo(String estadoReclamo) {
		this.estadoReclamo = estadoReclamo;
	}
	
	/**
	 * @return the estado
	 */
	public String getEstadoCiudadano() {
		return estadoCiudadano;
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstadoCiudadano(String estadoCiudadano) {
		this.estadoCiudadano = estadoCiudadano;
	}

	/**
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	/**
	 * @return the latitud
	 */
	public BigDecimal getLatitud() {
		return latitud;
	}

	/**
	 * @param latitud the latitud to set
	 */
	public void setLatitud(BigDecimal latitud) {
		this.latitud = latitud;
	}

	/**
	 * @return the longitud
	 */
	public BigDecimal getLongitud() {
		return longitud;
	}

	/**
	 * @param longitud the longitud to set
	 */
	public void setLongitud(BigDecimal longitud) {
		this.longitud = longitud;
	}

	/**
	 * @return the resumenImagen
	 */
	public ResumenImagenDto getResumenImagen() {
		return resumenImagen;
	}

	/**
	 * @param resumenImagen the resumenImagen to set
	 */
	public void setResumenImagen(ResumenImagenDto resumenImagen) {
		this.resumenImagen = resumenImagen;
	}

	/**
	 * @return the comentarios
	 */
	public List<ReclamoComentarioDto> getComentarios() {
		return comentarios;
	}

	/**
	 * @param comentarios the comentarios to set
	 */
	public void setComentarios(List<ReclamoComentarioDto> comentarios) {
		this.comentarios = comentarios;
	}


//	public Integer getIdReclamo() {
//		return idReclamo;
//	}
//
//
//	public void setIdReclamo(Integer idReclamo) {
//		this.idReclamo = idReclamo;
//	}
//
//
//	public Integer getDni() {
//		return dni;
//	}
//
//
//	public void setDni(Integer dni) {
//		this.dni = dni;
//	}
//
//
//	public String getDescripcion() {
//		return descripcion;
//	}
//
//
//	public void setDescripcion(String descripcion) {
//		this.descripcion = descripcion;
//	}
//
//
//	public String getVehiculo() {
//		return vehiculo;
//	}
//
//
//	public void setVehiculo(String vehiculo) {
//		this.vehiculo = vehiculo;
//	}
//
//
//	public List<String> getImagenesBase64() {
//		return imagenesBase64;
//	}
//
//
//	public void setImagenesBase64(List<String> imagenesBase64) {
//		this.imagenesBase64 = imagenesBase64;
//	}
//
//
//	public String getImei() {
//		return imei;
//	}
//
//
//	public void setImei(String imei) {
//		this.imei = imei;
//	}
//
//
	public String getNumRec() {
		return numRec;
	}


	public void setNumRec(String numRec) {
		this.numRec = numRec;
	}
//
//
//	public String getEstado() {
//		return estado;
//	}
//
//
//	public void setEstado(String estado) {
//		this.estado = estado;
//	}
//
//
//	public Date getFecCre() {
//		return fecCre;
//	}
//
//
//	public void setFecCre(Date fecCre) {
//		this.fecCre = fecCre;
//	}
//
//
//	public Date getFecMod() {
//		return fecMod;
//	}
//
//
//	public void setFecMod(Date fecMod) {
//		this.fecMod = fecMod;
//	}
//	
//	
//	
	public List<ReclamoComentarioDto> getReclamoComentarios() {
		return reclamoComentarios;
	}
	
	public void setReclamoComentarios(List<ReclamoComentarioDto> reclamoComentarios) {
		this.reclamoComentarios = reclamoComentarios;
	}
//
//
//	public ResumenImagenDto getResumenImagen() {
//		return resumenImagen;
//	}
//
//
//	public void setResumenImagen(ResumenImagenDto resumenImagen) {
//		this.resumenImagen = resumenImagen;
//	}
//
//
//	public BigDecimal getLatitud() {
//		return latitud;
//	}
//
//
//	public void setLatitud(BigDecimal latitud) {
//		this.latitud = latitud;
//	}
//
//
//	public BigDecimal getLongitud() {
//		return longitud;
//	}
//
//
//	public void setLongitud(BigDecimal longitud) {
//		this.longitud = longitud;
//	}
//	public List<String> getReclamoComentarios() {
//		return reclamoComentarios;
//	}
//
//
//	public void setReclamoComentarios(List<String> reclamoComentarios) {
//		this.reclamoComentarios = reclamoComentarios;
//	}
	
}