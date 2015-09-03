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
import com.puridiompe.mpa.business.general.GestionarPermisoOperacionEspecialBusiness;
import com.puridiompe.mpa.business.general.dto.PermisoOperacionEspecialDto;
import com.puridiompe.mpa.rest.controller.general.message.GetPerOperEspRequest;
import com.puridiompe.mpa.rest.controller.general.message.GetPerOperEspResponse;
import com.puridiompe.mpa.rest.controller.message.RequestMessage;
import com.puridiompe.mpa.rest.controller.message.ResponseMessage;

@RestController
@RequestMapping("/transportes/permisoEspecial")
public class RegistroPerOperEspecialController {

	@Autowired
	private GestionarPermisoOperacionEspecialBusiness gestionarPermisoBusiness;
	

	@RequestMapping(value = "/setare", method = RequestMethod.POST, headers = "Accept=application/json", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseMessage<GetPerOperEspResponse> getPermiso(
			@RequestBody @Valid RequestMessage<GetPerOperEspRequest> request)
			throws BusinessException {

		GetPerOperEspRequest permisoRequest = request.getBody();

		PermisoOperacionEspecialDto permisoObject = gestionarPermisoBusiness
				.getPermisoOperacionEspecial(permisoRequest.getPermiso().getVehiculo());
				

		ResponseMessage<GetPerOperEspResponse> response = new ResponseMessage<GetPerOperEspResponse>();

		GetPerOperEspResponse permisoResponse = new GetPerOperEspResponse();
		
		permisoResponse.setPermiso(permisoObject);

		response.setBody(permisoResponse);

		return response;
	}
}
