package com.puridiompe.mpa.rest.controller.general.message;

import java.util.List;

import com.puridiompe.mpa.business.general.dto.ActaDto;
import com.puridiompe.mpa.common.rest.message.ResponseBody;

public class GetActaResponse extends ResponseBody {

	private ActaDto acta;
	
	private Integer numeroActas;
	
	private List<ActaDto> infraccionesFrecuentes;

	public ActaDto getActa() {
		return acta;
	}

	public void setActa(ActaDto acta) {
		this.acta = acta;
	}

	public Integer getNumeroActas() {
		return numeroActas;
	}

	public void setNumeroActas(Integer numeroActas) {
		this.numeroActas = numeroActas;
	}

	public List<ActaDto> getInfraccionesFrecuentes() {
		return infraccionesFrecuentes;
	}

	public void setInfraccionesFrecuentes(List<ActaDto> infraccionesFrecuentes) {
		this.infraccionesFrecuentes = infraccionesFrecuentes;
	}
	
}
