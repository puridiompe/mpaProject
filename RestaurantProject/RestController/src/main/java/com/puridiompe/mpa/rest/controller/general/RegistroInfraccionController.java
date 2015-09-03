/**
 * 
 */
package com.puridiompe.mpa.rest.controller.general;

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
import com.puridiompe.mpa.rest.controller.BaseController;
import com.puridiompe.mpa.rest.controller.general.message.GetInfraccionRequest;
import com.puridiompe.mpa.rest.controller.general.message.GetInfraccionResponse;
import com.puridiompe.mpa.rest.controller.general.validation.GetInfraccionValidator;
import com.puridiompe.mpa.rest.controller.message.RequestMessage;
import com.puridiompe.mpa.rest.controller.message.ResponseMessage;

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
		
		InfraccionDto infraccionObject = gestionarInfraccionBusiness.getInfraccion(infraccionRequest.getInfraccion().getIdInfraccion());
		
		ResponseMessage<GetInfraccionResponse> response = new ResponseMessage<GetInfraccionResponse>();
		
		GetInfraccionResponse infraccionResponse = new GetInfraccionResponse();
		
		infraccionResponse.setInfraccion(infraccionObject);
		
		response.setBody(infraccionResponse);
		
		return response;
		
	}
}
