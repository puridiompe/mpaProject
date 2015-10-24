package com.puridiompe.mpa.rest.controller.general;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.puridiompe.mpa.business.exception.BusinessException;
import com.puridiompe.mpa.business.general.GestionarReclamosBusiness;
import com.puridiompe.mpa.business.general.dto.ReclamosDto;
import com.puridiompe.mpa.common.rest.message.RequestMessage;
import com.puridiompe.mpa.common.rest.message.ResponseMessage;
import com.puridiompe.mpa.common.security.SecurityContextHelper;
import com.puridiompe.mpa.common.security.exception.SecurityException;
import com.puridiompe.mpa.rest.controller.general.message.GetReclamosRequest;
import com.puridiompe.mpa.rest.controller.general.message.GetReclamosResponse;

@RestController
@RequestMapping("/transportes/reclamos")
public class RegistroReclamosController {

	@Autowired
	private GestionarReclamosBusiness gestionarReclamos;
	
	@RequestMapping(value = "/get", method = RequestMethod.POST, headers = "Accept=application/json", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseMessage<GetReclamosResponse> updateCiudadano(@RequestBody RequestMessage<GetReclamosRequest> request)
			throws BusinessException, SecurityException{
		

		String currentImei = SecurityContextHelper.getCurrentImei();
//		GetReclamosRequest reclamosRequest = request.getBody();
		ReclamosDto reclamosObject = gestionarReclamos.getReclamos(currentImei);
		
		ResponseMessage<GetReclamosResponse> response = new ResponseMessage<GetReclamosResponse>();
		GetReclamosResponse reclamosResponse = new GetReclamosResponse();
		
		reclamosResponse.setReclamos(reclamosObject);
		response.setBody(reclamosResponse);
		
		return response;
	}
}
