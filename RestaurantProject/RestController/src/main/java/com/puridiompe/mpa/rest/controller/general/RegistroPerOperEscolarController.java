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
import com.puridiompe.mpa.business.general.GestionarPermisoOperacionEscolarBusiness;
import com.puridiompe.mpa.business.general.dto.PermisoOperacionEscolarDto;
import com.puridiompe.mpa.common.rest.message.RequestMessage;
import com.puridiompe.mpa.common.rest.message.ResponseMessage;
import com.puridiompe.mpa.rest.controller.BaseController;
import com.puridiompe.mpa.rest.controller.general.message.GetPerOperEscolarRequest;
import com.puridiompe.mpa.rest.controller.general.message.GetPerOperEscolarResponse;

@RestController
@RequestMapping("/transportes/permisoEscolar")
public class RegistroPerOperEscolarController extends BaseController {

	@Autowired
	private GestionarPermisoOperacionEscolarBusiness gestionarPermisoBusiness;
	
	@RequestMapping(value = "/escolar", method = RequestMethod.POST, headers = "Accept=application/json", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseMessage<GetPerOperEscolarResponse> getPermiso(
			@RequestBody @Valid RequestMessage<GetPerOperEscolarRequest> request)
			throws BusinessException {

		GetPerOperEscolarRequest permisoRequest = request.getBody();

		PermisoOperacionEscolarDto permisoObject = gestionarPermisoBusiness
				.getPermisoOperacionEscolar(permisoRequest.getPermiso().getVehiculo());
				

		ResponseMessage<GetPerOperEscolarResponse> response = new ResponseMessage<GetPerOperEscolarResponse>();

		GetPerOperEscolarResponse permisoResponse = new GetPerOperEscolarResponse();
		
		permisoResponse.setPermiso(permisoObject);

		response.setBody(permisoResponse);

		return response;
	}
}
