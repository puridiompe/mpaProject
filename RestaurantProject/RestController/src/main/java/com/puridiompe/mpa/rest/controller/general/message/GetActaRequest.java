package com.puridiompe.mpa.rest.controller.general.message;

import com.puridiompe.mpa.business.general.dto.ActaDto;
import com.puridiompe.mpa.common.rest.message.RequestBody;

public class GetActaRequest extends RequestBody{

	private ActaDto acta;

	public ActaDto getActa() {
		return acta;
	}

	public void setActa(ActaDto acta) {
		this.acta = acta;
	}
}
