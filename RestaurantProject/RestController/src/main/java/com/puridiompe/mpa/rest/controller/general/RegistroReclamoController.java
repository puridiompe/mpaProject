package com.puridiompe.mpa.rest.controller.general;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.puridiompe.mpa.business.exception.BusinessException;
import com.puridiompe.mpa.business.general.GestionarReclamoBusiness;
import com.puridiompe.mpa.common.rest.message.RequestMessage;
import com.puridiompe.mpa.common.rest.message.ResponseMessage;
import com.puridiompe.mpa.rest.controller.general.message.GetReclamoRequest;
import com.puridiompe.mpa.rest.controller.general.message.GetReclamoResponse;

@RestController
@RequestMapping("/transportes/reclamo")
public class RegistroReclamoController {

	@Autowired
	private GestionarReclamoBusiness gestionarReclamo;
	
	@RequestMapping(value = "/setReclamo", method = RequestMethod.PUT, headers = "Accept=application/json", produces = MediaType.APPLICATION_JSON_VALUE)
	public boolean addReclamo(
			@RequestBody RequestMessage<GetReclamoRequest> request)
			throws BusinessException {
		
		GetReclamoRequest reclamoRequest = request.getBody();
		
		gestionarReclamo.setReclamo(reclamoRequest.getReclamo().getDni(), reclamoRequest.getReclamo().getDescripcion(),
									reclamoRequest.getReclamo().getVehiculo());

		return true;

	}
}
