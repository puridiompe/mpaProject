package com.puridiompe.mpa.business.general.dto;

import java.util.ArrayList;
import java.util.List;

public class ResumenImagenDto {

	private int numeroImagenes;
	private List<String> pesoImagen;
	
	public ResumenImagenDto() {
		this.pesoImagen = new ArrayList<String>();
	}

	public int getNumeroImagenes() {
		return numeroImagenes;
	}

	public void setNumeroImagenes(int numeroImagenes) {
		this.numeroImagenes = numeroImagenes;
	}

	public List<String> getPesoImagen() {
		return pesoImagen;
	}

	public void setPesoImagen(List<String> pesoImagen) {
		this.pesoImagen = pesoImagen;
	}
	
}
