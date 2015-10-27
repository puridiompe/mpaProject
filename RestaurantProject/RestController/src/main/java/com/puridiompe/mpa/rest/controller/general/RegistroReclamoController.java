package com.puridiompe.mpa.rest.controller.general;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.puridiompe.mpa.business.exception.BusinessException;
import com.puridiompe.mpa.business.general.GestionarReclamoBusiness;
import com.puridiompe.mpa.business.general.dto.ReclamoDto;
import com.puridiompe.mpa.common.rest.message.RequestMessage;
import com.puridiompe.mpa.common.rest.message.ResponseMessage;
import com.puridiompe.mpa.common.security.SecurityContextHelper;
import com.puridiompe.mpa.common.security.exception.SecurityException;
import com.puridiompe.mpa.common.type.ReclamoState;
import com.puridiompe.mpa.rest.controller.general.message.GetReclamoRequest;
import com.puridiompe.mpa.rest.controller.general.message.GetReclamoResponse;

@RestController
@RequestMapping("/transportes/reclamo")
public class RegistroReclamoController {

	@Autowired
	private GestionarReclamoBusiness gestionarReclamo;

	@RequestMapping(value = "/setReclamo", method = RequestMethod.PUT, headers = "Accept=application/json", produces = MediaType.APPLICATION_JSON_VALUE)
	public boolean addReclamo(@RequestBody RequestMessage<GetReclamoRequest> request)
			throws BusinessException, SecurityException {

		GetReclamoRequest reclamoRequest = request.getBody();

		gestionarReclamo.setReclamo(reclamoRequest.getReclamo().getDni(), reclamoRequest.getReclamo().getDescripcion(),
				reclamoRequest.getReclamo().getVehiculo(), reclamoRequest.getReclamo().getImagenesBase64(), ReclamoState.RECIBIDO.toString());

		return true;

	}
	
	@RequestMapping(value = "/setToEnProceso", method = RequestMethod.PUT, headers = "Accept=application/json", produces = MediaType.APPLICATION_JSON_VALUE)
	public boolean setToEnProceso(@RequestBody RequestMessage<GetReclamoRequest> request)
			throws BusinessException, SecurityException {

		GetReclamoRequest reclamoRequest = request.getBody();

		gestionarReclamo.setReclamo(reclamoRequest.getReclamo().getDni(), reclamoRequest.getReclamo().getDescripcion(),
				reclamoRequest.getReclamo().getVehiculo(), reclamoRequest.getReclamo().getImagenesBase64(), ReclamoState.ENPROCESO.toString());

		return true;
	}
	
	@RequestMapping(value = "/setToArchivado", method = RequestMethod.PUT, headers = "Accept=application/json", produces = MediaType.APPLICATION_JSON_VALUE)
	public boolean setToArchivado(@RequestBody RequestMessage<GetReclamoRequest> request)
			throws BusinessException, SecurityException {

		GetReclamoRequest reclamoRequest = request.getBody();

		gestionarReclamo.setReclamo(reclamoRequest.getReclamo().getDni(), reclamoRequest.getReclamo().getDescripcion(),
				reclamoRequest.getReclamo().getVehiculo(), reclamoRequest.getReclamo().getImagenesBase64(), ReclamoState.ARCHIVADO.toString());

		return true;

	}

	@RequestMapping(value = "/getAll", method = RequestMethod.POST, headers = "Accept=application/json", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseMessage<GetReclamoResponse> getReclamosFrecuentes() throws BusinessException {

		List<ReclamoDto> reclamosObject = gestionarReclamo.getReclamosFrecuentes();

		ResponseMessage<GetReclamoResponse> response = new ResponseMessage<GetReclamoResponse>();

		GetReclamoResponse reclamoFrecuenteResponse = new GetReclamoResponse();

		reclamoFrecuenteResponse.setReclamosFrecuentes(reclamosObject);

		response.setBody(reclamoFrecuenteResponse);

		return response;
	}

	@RequestMapping(value = "/getLastDniByImei", method = RequestMethod.POST, headers = "Accept=application/json", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseMessage<GetReclamoResponse> getLastDniByImei(
			@RequestBody RequestMessage<GetReclamoRequest> request) throws BusinessException, SecurityException {

		String currentImei = SecurityContextHelper.getCurrentImei();

		Integer dni = gestionarReclamo.getLastDniByImei(currentImei);// request.getBody().getReclamo().getImei());
		ResponseMessage<GetReclamoResponse> response = new ResponseMessage<GetReclamoResponse>();

		GetReclamoResponse lastDnibyImeiResponse = new GetReclamoResponse();

		ReclamoDto forResponse = new ReclamoDto();
		forResponse.setDni(dni);

		lastDnibyImeiResponse.setReclamo(forResponse);

		response.setBody(lastDnibyImeiResponse);

		return response;
	}

	@RequestMapping(value = "/getAllReclamo", method = RequestMethod.POST, headers = "Accept=application/json", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseMessage<GetReclamoResponse> getAll()
			throws BusinessException {

		ResponseMessage<GetReclamoResponse> response = new ResponseMessage<GetReclamoResponse>();

		GetReclamoResponse reclamoResponse = new GetReclamoResponse();

		List<ReclamoDto> forResponse = gestionarReclamo.getAll();

		reclamoResponse.setReclamosFrecuentes(forResponse);

		response.setBody(reclamoResponse);

		return response;
	}
}
