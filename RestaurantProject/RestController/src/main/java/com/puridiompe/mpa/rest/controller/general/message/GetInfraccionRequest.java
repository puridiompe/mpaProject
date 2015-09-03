package com.puridiompe.mpa.rest.controller.general.message;

import com.puridiompe.mpa.business.general.dto.InfraccionDto;
import com.puridiompe.mpa.rest.controller.message.RequestBody;

/**
 * 
 * @author Lucho
 *
 */

public class GetInfraccionRequest extends RequestBody{
	
	private InfraccionDto infraccion;
	
	public InfraccionDto getInfraccion(){
		return infraccion;
	}
	
	public void setInfraccion(InfraccionDto infraccion){
		this.infraccion = infraccion;
	}

}
