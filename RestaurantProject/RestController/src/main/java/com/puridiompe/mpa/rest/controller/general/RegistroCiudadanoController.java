package com.puridiompe.mpa.rest.controller.general;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.puridiompe.mpa.business.exception.BusinessException;
import com.puridiompe.mpa.business.general.GestionarCiudadanoBusiness;
import com.puridiompe.mpa.business.general.dto.CiudadanoDto;
import com.puridiompe.mpa.common.exception.SaveCiudadanoException;
import com.puridiompe.mpa.common.rest.message.RequestMessage;
import com.puridiompe.mpa.common.rest.message.ResponseMessage;
import com.puridiompe.mpa.common.security.SecurityContextHelper;
import com.puridiompe.mpa.common.security.exception.SecurityException;
import com.puridiompe.mpa.rest.controller.general.message.GetCiudadanosRequest;
import com.puridiompe.mpa.rest.controller.general.message.GetCiudadanoRequest;
import com.puridiompe.mpa.rest.controller.general.message.GetCiudadanoResponse;
import com.puridiompe.mpa.rest.controller.general.validation.GetCiudadanoValidator; 

@RestController
@RequestMapping("/transportes/ciudadano")
public class RegistroCiudadanoController {
	
	@Autowired
	private GestionarCiudadanoBusiness gestionarCiudadano;
	
	@Autowired
	private GetCiudadanoValidator getCiudadanoValidator;
	
	@InitBinder
	protected void InitBinder (WebDataBinder binder){
		binder.setValidator(getCiudadanoValidator);
	}
	
	@RequestMapping(value = "/setAndUpdate ", method = RequestMethod.PUT, headers = "Accept=application/json", produces = MediaType.APPLICATION_JSON_VALUE)
	public Integer setCiudadano(@RequestBody RequestMessage<GetCiudadanosRequest> request, BindingResult result) 
			throws BusinessException, SecurityException, SaveCiudadanoException{		
		
		List<CiudadanoDto> ciudadanos = request.getBody().getCiudadanos();
		
		if(result.hasErrors()){
			throw new SaveCiudadanoException("No se pudieron guardar los ciudadanos enviados");
		
		}else{
			if(ciudadanos != null && !ciudadanos.isEmpty()){				
				gestionarCiudadano.setCiudadanoBatch(ciudadanos);				
			}else{
				throw new SaveCiudadanoException("El array de ciudadanos está vacio o es nulo");				
			}

			return ciudadanos.size();
		}


	}
	
	@RequestMapping(value = "/get", method = RequestMethod.POST, headers = "Accept=application/json", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseMessage<GetCiudadanoResponse> updateCiudadano(@RequestBody RequestMessage<GetCiudadanoRequest> request)
			throws BusinessException, SecurityException {
		
//		String currentImei = SecurityContextHelper.getCurrentImei();	
		
		
		GetCiudadanoRequest ciudadanoRequest = request.getBody();
		CiudadanoDto ciudadanoObject = gestionarCiudadano.getCiudadano(ciudadanoRequest.getCiudadano().getDni());
		
		ResponseMessage<GetCiudadanoResponse> response = new ResponseMessage<GetCiudadanoResponse>();
		GetCiudadanoResponse ciudadanoResponse = new GetCiudadanoResponse();
		
		ciudadanoResponse.setCiudadano(ciudadanoObject);
		response.setBody(ciudadanoResponse);

		return response;

	}

}
