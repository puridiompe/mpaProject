package com.puridiompe.mpa.rest.controller.seguridad;

import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.puridiompe.mpa.business.exception.BusinessException;
import com.puridiompe.mpa.common.rest.message.RequestMessage;
import com.puridiompe.mpa.common.rest.message.ResponseMessage;
import com.puridiompe.mpa.rest.controller.general.message.GetUsuarioRequest;
import com.puridiompe.mpa.rest.controller.general.message.GetUsuarioResponse;

@RestController
@RequestMapping("/transportes/token")
public class TokenController {
	
	@RequestMapping(value = "/get", method = RequestMethod.POST, headers = "Accept=application/json", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseMessage<GetUsuarioResponse> getUsuario(
			@RequestBody @Valid RequestMessage<GetUsuarioRequest> request)
			throws BusinessException { return null; }

}
