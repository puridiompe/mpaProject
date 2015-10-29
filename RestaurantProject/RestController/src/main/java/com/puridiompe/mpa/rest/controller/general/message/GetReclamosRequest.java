package com.puridiompe.mpa.rest.controller.general.message;

import com.puridiompe.mpa.business.general.dto.ReclamosDto;
import com.puridiompe.mpa.common.rest.message.RequestBody;

public class GetReclamosRequest extends RequestBody {

	private ReclamosDto reclamos;

	public ReclamosDto getReclamos() {
		return reclamos;
	}

	public void setReclamos(ReclamosDto reclamos) {
		this.reclamos = reclamos;
	}
}
