package com.puridiompe.mpa.business.general.dto;

public class CiudadanoDto {

	private Integer dni;
	
	private String apellidoPaterno;
	
	private String apellidoMaterno;
	
	private String nombres;
	
	private String email;
	
	private String estado;
//	
//	private Long offlineTime;
	
	/**
	 * Default Constructor
	 */
	public CiudadanoDto(){
		
	}

	/**
	 * Getters and Setters
	 * @return
	 */
	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}


//	public Long getOfflineTime() {
//		return offlineTime;
//	}
//
//	public void setOfflineTime(Long offlineTime) {
//		this.offlineTime = offlineTime;
//	}

}
