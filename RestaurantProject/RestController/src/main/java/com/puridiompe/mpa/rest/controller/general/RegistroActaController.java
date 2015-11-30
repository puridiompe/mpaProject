package com.puridiompe.mpa.rest.controller.general;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.puridiompe.mpa.business.exception.BusinessException;
import com.puridiompe.mpa.business.general.GestionarActaBusiness;
import com.puridiompe.mpa.business.general.dto.ActaDto;
import com.puridiompe.mpa.common.rest.message.RequestMessage;
import com.puridiompe.mpa.common.rest.message.ResponseMessage;
import com.puridiompe.mpa.common.security.SecurityContextHelper;
import com.puridiompe.mpa.common.security.exception.SecurityException;
import com.puridiompe.mpa.common.type.ReclamoState;
import com.puridiompe.mpa.rest.controller.general.message.GetActaRequest;
import com.puridiompe.mpa.rest.controller.general.message.GetActaResponse;

@RestController
@RequestMapping("/transportes/acta")
public class RegistroActaController {

	@Autowired
	private GestionarActaBusiness gestionarActaBusiness;
	
	@RequestMapping(value = "/set", method = RequestMethod.PUT, headers = "Accept=application/json", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseMessage<GetActaResponse>  setActa(@RequestBody RequestMessage<GetActaRequest> request)
			throws BusinessException, SecurityException {		
			
		ResponseMessage<GetActaResponse> response = new ResponseMessage<GetActaResponse>();
		
		ActaDto actaDto = request.getBody().getActa();
		actaDto.setEstado(ReclamoState.RECIBIDO.toString());
		actaDto.setUsername(SecurityContextHelper.getCurrentUsername());

		ActaDto actaObject = gestionarActaBusiness.setActa(actaDto);
		
		GetActaResponse actaResponse = new GetActaResponse();
		actaResponse.setActa(actaObject);
		response.setBody(actaResponse);
		
		return response;
	}
	
}
