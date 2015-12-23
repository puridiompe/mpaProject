package com.puridiompe.mpa.rest.controller.general.message;

import java.util.List;

import com.puridiompe.mpa.business.general.dto.ActaDto;
import com.puridiompe.mpa.business.general.dto.FilterDto;
import com.puridiompe.mpa.common.rest.message.ResponseBody;

public class GetActaByUsernameResponse extends ResponseBody{

	private List<ActaDto> actaUsername;
	private List<FilterDto> filterList;

	public List<ActaDto> getActaUsername() {
		return actaUsername;
	}

	public void setActaUsername(List<ActaDto> actaUsername) {
		this.actaUsername = actaUsername;
	}

	public List<FilterDto> getFilterList() {
		return filterList;
	}

	public void setFilterList(List<FilterDto> filterList) {
		this.filterList = filterList;
	}
	
	
}
