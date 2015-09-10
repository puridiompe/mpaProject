package com.puridiompe.mpa.rest.controller.general;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.puridiompe.mpa.business.exception.BusinessException;
import com.puridiompe.mpa.business.general.GestionarPermisoGeneralBusiness;
import com.puridiompe.mpa.business.general.dto.PermisoGeneralDto;
import com.puridiompe.mpa.common.rest.message.RequestMessage;
import com.puridiompe.mpa.common.rest.message.ResponseMessage;
import com.puridiompe.mpa.rest.controller.general.message.GetPermisoGeneralRequest;
import com.puridiompe.mpa.rest.controller.general.message.GetPermisoGeneralResponse;

@RestController
@RequestMapping("/transportes/permisoGeneral")
public class RegistroPermisoGeneralController {

	@Autowired
	private  GestionarPermisoGeneralBusiness permisoGeneral; 
	
	@RequestMapping(value = "/get", method = RequestMethod.POST, headers = "Accept=application/json", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseMessage<GetPermisoGeneralResponse> getPermiso(
			@RequestBody @Valid RequestMessage<GetPermisoGeneralRequest> request)
			throws BusinessException {
	
		GetPermisoGeneralRequest permisoRequest = request.getBody();
		
		PermisoGeneralDto permisoGeneralObject = permisoGeneral.getPermisoGeneral(permisoRequest.getPermisoGeneral().getVehiculo());

		ResponseMessage<GetPermisoGeneralResponse> response = new ResponseMessage<GetPermisoGeneralResponse>();

		GetPermisoGeneralResponse permisoResponse = new GetPermisoGeneralResponse();
		
		permisoResponse.setPermisoGeneral(permisoGeneralObject);

		response.setBody(permisoResponse);

		return response;
	}
}
