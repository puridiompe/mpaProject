package com.puridiompe.mpa.rest.controller.general.message;

import java.util.List;

import com.puridiompe.mpa.business.general.dto.InfraccionDto;
import com.puridiompe.mpa.common.rest.message.ResponseBody;


/**
 * 
 * @author Lucho
 *
 */

public class GetInfraccionesResponse extends ResponseBody{
	
	private List<InfraccionDto> infracciones;
	
	public List<InfraccionDto> getInfracciones(){
		return infracciones;
	}
	
	public void setInfracciones(List<InfraccionDto> infracciones){
		this.infracciones = infracciones;
	}

}