package com.puridiompe.mpa.rest.controller.general.message;

import java.util.List;

import com.puridiompe.mpa.business.general.dto.ReclamoDto;
import com.puridiompe.mpa.common.rest.message.ResponseBody;

public class GetReclamoResponse extends ResponseBody{
	
	private ReclamoDto reclamo;

	public ReclamoDto getReclamo() {
		return reclamo;
	}

	public void setReclamo(ReclamoDto reclamo) {
		this.reclamo = reclamo;
	}
	
	private List<ReclamoDto> reclamosFrecuentes;
	
	public List<ReclamoDto> getReclamosFrecuentes(){
		return reclamosFrecuentes;
	}
	
	public void setReclamosFrecuentes(List<ReclamoDto> reclamosFrecuentes){
		this.reclamosFrecuentes = reclamosFrecuentes;
	}
	
	private Integer numeroReclamos;

	public Integer getNumeroReclamos() {
		return numeroReclamos;
	}

	public void setNumeroReclamos(Integer numeroReclamos) {
		this.numeroReclamos = numeroReclamos;
	}
}
