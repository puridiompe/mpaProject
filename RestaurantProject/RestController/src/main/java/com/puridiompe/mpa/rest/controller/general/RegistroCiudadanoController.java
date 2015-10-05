package com.puridiompe.mpa.rest.controller.general;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.puridiompe.mpa.business.exception.BusinessException;
import com.puridiompe.mpa.business.general.GestionarCiudadanoBusiness;
import com.puridiompe.mpa.common.rest.message.RequestMessage;
import com.puridiompe.mpa.rest.controller.general.message.GetCiudadanoRequest; 

@RestController
@RequestMapping("/transportes/ciudadano")
public class RegistroCiudadanoController {
	
	@Autowired
	private GestionarCiudadanoBusiness gestionarCiudadano;
	
	@RequestMapping(value = "/set", method = RequestMethod.PUT, headers = "Accept=application/json", produces = MediaType.APPLICATION_JSON_VALUE)
	public boolean addReclamo(@RequestBody RequestMessage<GetCiudadanoRequest> request)
			throws BusinessException {
		
		GetCiudadanoRequest ciudadanoRequest = request.getBody();
		
		gestionarCiudadano.setCiudadano(ciudadanoRequest.getCiudadano().getDni(), ciudadanoRequest.getCiudadano().getApellidoPaterno(),
				ciudadanoRequest.getCiudadano().getApellidoMaterno(), ciudadanoRequest.getCiudadano().getNombres(),ciudadanoRequest.getCiudadano().getEmail());

		return true;

	}

}
