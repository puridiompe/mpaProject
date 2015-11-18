package com.puridiompe.mpa.rest.controller.general.message;

import java.util.List;

import com.puridiompe.mpa.business.general.dto.ReclamoDto;
import com.puridiompe.mpa.common.rest.message.RequestBody;

public class GetReclamosRequest extends RequestBody{

	private List<ReclamoDto> reclamos;

	public List<ReclamoDto> getReclamos() {
		return reclamos;
	}

	public void setReclamos(List<ReclamoDto> reclamos) {
		this.reclamos = reclamos;
	}
	
}
