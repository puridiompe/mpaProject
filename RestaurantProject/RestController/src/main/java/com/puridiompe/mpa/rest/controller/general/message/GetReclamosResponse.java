package com.puridiompe.mpa.rest.controller.general.message;

import java.util.List;

import com.puridiompe.mpa.business.general.dto.FilterDto;
import com.puridiompe.mpa.business.general.dto.ReclamoDto;
import com.puridiompe.mpa.common.rest.message.ResponseBody;

public class GetReclamosResponse extends ResponseBody{
	
	private List<FilterDto> filterList;

	private List<ReclamoDto> reclamos;

	public List<ReclamoDto> getReclamos() {
		return reclamos;
	}

	public void setReclamos(List<ReclamoDto> reclamos) {
		this.reclamos = reclamos;
	}

	public List<FilterDto> getFilterList() {
		return filterList;
	}

	public void setFilterList(List<FilterDto> filterList) {
		this.filterList = filterList;
	}
	
	
}
