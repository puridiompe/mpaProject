package com.puridiompe.mpa.rest.controller.general.message;

import java.util.List;

import com.puridiompe.mpa.business.general.dto.PapeletaDto;
import com.puridiompe.mpa.common.rest.message.ResponseBody;

public class GetPapeletaResponse extends ResponseBody{

	private List<PapeletaDto> papeletas;
	
	public List<PapeletaDto> getPapeletas(){
		return papeletas;
	}
	
	public void setPapeletas(List<PapeletaDto> papeletas){
		this.papeletas = papeletas;
	}
	
}
