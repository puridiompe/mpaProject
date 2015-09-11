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
import com.puridiompe.mpa.rest.controller.general.message.GetInfraccionesRequest;
import com.puridiompe.mpa.rest.controller.general.message.GetInfraccionesResponse;
import com.puridiompe.mpa.rest.controller.general.validation.GetInfraccionesValidator;


/**
 * @author Lucho
 *
 */

@RestController
@RequestMapping("/transportes/infracciones")
public class RegistroInfraccionesController extends BaseController {
	
	@Autowired
	private GestionarInfraccionBusiness gestionarInfraccionBusiness;
	
	@Autowired
	private GetInfraccionesValidator getInfraccionesValidator;
	
	@InitBinder
	protected void InitBinder(WebDataBinder binder){
		binder.setValidator(getInfraccionesValidator);
	}
	
	@RequestMapping(value = "/get", method = RequestMethod.POST, headers = "Accept=application/json", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseMessage<GetInfraccionesResponse> findAll(
			@RequestBody @Valid RequestMessage<GetInfraccionesRequest> request)
			throws BusinessException {
		
		GetInfraccionesRequest infraccionesRequest = request.getBody();
		
		List<InfraccionDto> infraccionesObject = gestionarInfraccionBusiness.findAll();
//		List<InfraccionDto> infraccionesObject = null;
		
		ResponseMessage<GetInfraccionesResponse> response = new ResponseMessage<GetInfraccionesResponse>();
		
		GetInfraccionesResponse infraccionesResponse = new GetInfraccionesResponse();
		
		infraccionesResponse.setInfracciones(infraccionesObject);
		
		response.setBody(infraccionesResponse);
		
		return response;
		
	}
}