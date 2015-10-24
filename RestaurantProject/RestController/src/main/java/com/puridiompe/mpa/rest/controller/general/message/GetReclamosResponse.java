package com.puridiompe.mpa.rest.controller.general.message;

import com.puridiompe.mpa.business.general.dto.ReclamosDto;
import com.puridiompe.mpa.common.rest.message.ResponseBody;

public class GetReclamosResponse extends ResponseBody{

	private ReclamosDto reclamos;

	public ReclamosDto getReclamos() {
		return reclamos;
	}

	public void setReclamos(ReclamosDto reclamos) {
		this.reclamos = reclamos;
	}
	
}
