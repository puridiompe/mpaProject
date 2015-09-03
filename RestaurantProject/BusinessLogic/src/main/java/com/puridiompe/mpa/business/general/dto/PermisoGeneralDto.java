package com.puridiompe.mpa.business.general.dto;

public class PermisoGeneralDto {

	private String vehiculo;
	private PermisoOperacionEscolarDto permisoEscolar;
	private PermisoOperacionEspecialDto permisoEspecial;
	//private PermisoOperacionTrabajadorDto permisoTrabajador;
	private PermisoOperacionTurismoDto permisoTurismo;
	
	public PermisoGeneralDto(){
		
	}
	
	/**
	 * Getters and Setters
	 * 
	 * @return
	 */
	
	public String getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(String vehiculo) {
		this.vehiculo = vehiculo;
	}

	public PermisoOperacionEscolarDto getPermisoEscolar() {
		return permisoEscolar;
	}

	public void setPermisoEscolar(PermisoOperacionEscolarDto permisoEscolar) {
		this.permisoEscolar = permisoEscolar;
	}

	public PermisoOperacionEspecialDto getPermisoEspecial() {
		return permisoEspecial;
	}

	public void setPermisoEspecial(PermisoOperacionEspecialDto permisoEspecial) {
		this.permisoEspecial = permisoEspecial;
	}
/*
	public PermisoOperacionTrabajadorDto getPermisoTrabajador() {
		return permisoTrabajador;
	}

	public void setPermisoTrabajador(PermisoOperacionTrabajadorDto permisoTrabajador) {
		this.permisoTrabajador = permisoTrabajador;
	}
*/
	public PermisoOperacionTurismoDto getPermisoTurismo() {
		return permisoTurismo;
	}

	public void setPermisoTurismo(PermisoOperacionTurismoDto permisoTurismo) {
		this.permisoTurismo = permisoTurismo;
	}
			
}
