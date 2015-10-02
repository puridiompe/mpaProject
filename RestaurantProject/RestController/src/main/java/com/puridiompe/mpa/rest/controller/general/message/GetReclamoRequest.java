package com.puridiompe.mpa.rest.controller.general.message;

import com.puridiompe.mpa.business.general.dto.ReclamoDto;
import com.puridiompe.mpa.common.rest.message.RequestBody;

public class GetReclamoRequest extends RequestBody {

	private ReclamoDto reclamo;

	public ReclamoDto getReclamo() {
		return reclamo;
	}

	public void setReclamo(ReclamoDto reclamo) {
		this.reclamo = reclamo;
	}
	
	
}
