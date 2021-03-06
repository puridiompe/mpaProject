/**
 * 
 */
package com.puridiompe.mpa.rest.controller.general;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.puridiompe.mpa.business.exception.BusinessException;
import com.puridiompe.mpa.business.general.GestionarInfraccionBusiness;
import com.puridiompe.mpa.business.general.dto.InfraccionDto;
import com.puridiompe.mpa.common.rest.message.RequestMessage;
import com.puridiompe.mpa.common.rest.message.ResponseMessage;
import com.puridiompe.mpa.rest.controller.BaseController;
import com.puridiompe.mpa.rest.controller.general.message.GetInfraccionRequest;
import com.puridiompe.mpa.rest.controller.general.message.GetInfraccionResponse;
import com.puridiompe.mpa.rest.controller.general.message.GetInfraccionesResponse;
import com.puridiompe.mpa.rest.controller.general.validation.GetInfraccionValidator;


/**
 * @author Lucho
 *
 */

@RestController
@RequestMapping("/transportes/infraccion")
public class RegistroInfraccionController extends BaseController {
	
	@Autowired
	private GestionarInfraccionBusiness gestionarInfraccionBusiness;
	
	@Autowired
	private GetInfraccionValidator getInfraccionValidator;
	
	@InitBinder
	protected void InitBinder(WebDataBinder binder){
		binder.setValidator(getInfraccionValidator);
	}
	
	@RequestMapping(value = "/get", method = RequestMethod.POST, headers = "Accept=application/json", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseMessage<GetInfraccionResponse> getInfraccion(
			@RequestBody @Valid RequestMessage<GetInfraccionRequest> request)
			throws BusinessException {
		
		GetInfraccionRequest infraccionRequest = request.getBody();
		
		InfraccionDto infraccionObject = gestionarInfraccionBusiness.getInfraccionByCodigo(infraccionRequest.getInfraccion().getCodigo());
		
		ResponseMessage<GetInfraccionResponse> response = new ResponseMessage<GetInfraccionResponse>();
		
		GetInfraccionResponse infraccionResponse = new GetInfraccionResponse();
		
		infraccionResponse.setInfraccion(infraccionObject);
		
		response.setBody(infraccionResponse);
		
		return response;		
	}	
	
	@RequestMapping(value = "/getAll", method = RequestMethod.POST, headers = "Accept=application/json", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseMessage<GetInfraccionesResponse> getInfracciones()			
			throws BusinessException {		
		
		
		List<InfraccionDto> infraccionesObject = gestionarInfraccionBusiness.getAll();
		
		ResponseMessage<GetInfraccionesResponse> response = new ResponseMessage<GetInfraccionesResponse>();
		
		GetInfraccionesResponse infraccionesResponse = new GetInfraccionesResponse();
		
		infraccionesResponse.setInfracciones(infraccionesObject);
		
		response.setBody(infraccionesResponse);
		
		return response;		
	}	

}