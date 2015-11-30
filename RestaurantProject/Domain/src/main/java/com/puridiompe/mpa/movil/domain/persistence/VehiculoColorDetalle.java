package com.puridiompe.mpa.movil.domain.persistence;

import java.io.Serializable;

@SuppressWarnings("serial")
public class VehiculoColorDetalle implements Serializable{

	String denominacion;
	String detalleColor;
	
	public VehiculoColorDetalle (String denominacion, String detalleColor){
		
		this.denominacion = denominacion;
		this.detalleColor = detalleColor;
	}

	public String getDenominacion() {
		return denominacion;
	}

	public String getDetalleColor() {
		return detalleColor;
	}
	
}
