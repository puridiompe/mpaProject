/**
 * 
 */
package com.puridiompe.mpa.rest.controller.general.message;

import com.puridiompe.mpa.business.general.dto.InfraccionDto;
import com.puridiompe.mpa.rest.controller.message.ResponseBody;

/**
 * @author Lucho
 *
 */
public class GetInfraccionResponse extends ResponseBody{
	
	private InfraccionDto infraccion;
	
	public InfraccionDto getInfraccion(){
		return infraccion;
	}
	
	public void setInfraccion(InfraccionDto infraccion){
		this.infraccion = infraccion;
	}

}
