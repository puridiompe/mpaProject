package com.puridiompe.mpa.rest.controller.general;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.puridiompe.mpa.business.exception.BusinessException;
import com.puridiompe.mpa.business.general.GestionarCiudadanoBusiness;
import com.puridiompe.mpa.business.general.dto.CiudadanoDto;
import com.puridiompe.mpa.common.rest.message.RequestMessage;
import com.puridiompe.mpa.common.rest.message.ResponseMessage;
import com.puridiompe.mpa.rest.controller.general.message.GetCiudadanoRequest;
import com.puridiompe.mpa.rest.controller.general.message.GetCiudadanoResponse; 

@RestController
@RequestMapping("/transportes/ciudadano")
public class RegistroCiudadanoController {
	
	@Autowired
	private GestionarCiudadanoBusiness gestionarCiudadano;
	
	@RequestMapping(value = "/setAndUpdate ", method = RequestMethod.PUT, headers = "Accept=application/json", produces = MediaType.APPLICATION_JSON_VALUE)
	public boolean setCiudadano(@RequestBody RequestMessage<GetCiudadanoRequest> request)
			throws BusinessException {
		
		GetCiudadanoRequest ciudadanoRequest = request.getBody();
		
		gestionarCiudadano.setCiudadano(ciudadanoRequest.getCiudadano().getDni(), ciudadanoRequest.getCiudadano().getApellidoPaterno(),
				ciudadanoRequest.getCiudadano().getApellidoMaterno(), ciudadanoRequest.getCiudadano().getNombres(),ciudadanoRequest.getCiudadano().getEmail(), ciudadanoRequest.getCiudadano().getImei());

		return true;

	}
	
	@RequestMapping(value = "/get", method = RequestMethod.POST, headers = "Accept=application/json", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseMessage<GetCiudadanoResponse> updateCiudadano(@RequestBody RequestMessage<GetCiudadanoRequest> request)
			throws BusinessException {
		
		GetCiudadanoRequest ciudadanoRequest = request.getBody();
		CiudadanoDto ciudadanoObject = gestionarCiudadano.getCiudadano(ciudadanoRequest.getCiudadano().getImei());
		
		ResponseMessage<GetCiudadanoResponse> response = new ResponseMessage<GetCiudadanoResponse>();
		GetCiudadanoResponse ciudadanoResponse = new GetCiudadanoResponse();
		
		ciudadanoResponse.setCiudadano(ciudadanoObject);
		response.setBody(ciudadanoResponse);

		return response;

	}

}
