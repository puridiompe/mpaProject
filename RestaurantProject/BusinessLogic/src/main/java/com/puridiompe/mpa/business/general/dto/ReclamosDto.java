package com.puridiompe.mpa.business.general.dto;

import java.util.ArrayList;
import java.util.List;

public class ReclamosDto {
	
	private List<ReclamoDto> listReclamo;
	private List<CiudadanoDto> listCiudadano;
	private List<ResumenImagenDto> listImagen;
	
	public ReclamosDto() {
		this.listReclamo = new ArrayList<ReclamoDto> ();
		this.listCiudadano = new ArrayList<CiudadanoDto> ();
		this.listImagen = new ArrayList<ResumenImagenDto> ();
	}

	public List<ReclamoDto> getListReclamo() {
		return listReclamo;
	}
	
	public void setListReclamo(List<ReclamoDto> listReclamo) {
		this.listReclamo = listReclamo;
	}
	
	public List<CiudadanoDto> getListCiudadano() {
		return listCiudadano;
	}
	
	public void setListCiudadano(List<CiudadanoDto> listCiudadano) {
		this.listCiudadano = listCiudadano;
	}

	public List<ResumenImagenDto> getListImagen() {
		return listImagen;
	}

	public void setListImagen(List<ResumenImagenDto> listImagen) {
		this.listImagen = listImagen;
	}	
	
}
