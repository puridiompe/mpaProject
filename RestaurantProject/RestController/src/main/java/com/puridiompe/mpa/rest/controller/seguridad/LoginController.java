
package com.puridiompe.mpa.rest.controller.seguridad;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.puridiompe.mpa.business.exception.BusinessException;
import com.puridiompe.mpa.business.security.GestionarUserDetailsBusiness;
import com.puridiompe.mpa.business.security.dto.UsuarioDto;
import com.puridiompe.mpa.common.rest.message.RequestMessage;
import com.puridiompe.mpa.common.rest.message.ResponseMessage;
import com.puridiompe.mpa.rest.controller.BaseController;
import com.puridiompe.mpa.rest.controller.general.message.GetUsuarioRequest;
import com.puridiompe.mpa.rest.controller.general.message.GetUsuarioResponse;
import com.puridiompe.mpa.rest.controller.general.validation.GetUsuarioValidator;

@RestController
@RequestMapping("/transportes/login")
public class LoginController {
	
	@Autowired
	private GestionarUserDetailsBusiness gestionarUsuarioBusiness;
	
	//
	//@Autowired
	//private GetUsuarioValidator getUsuarioValidator;
	
//	@InitBinder
//	protected void initBinder(WebDataBinder binder) {
//		binder.setValidator(getUsuarioValidator);
//	}
	
	@RequestMapping(value = "/get", method = RequestMethod.POST, headers = "Accept=application/json", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseMessage<GetUsuarioResponse> getUsuario(
			@RequestBody @Valid RequestMessage<GetUsuarioRequest> request)
			throws BusinessException {

		GetUsuarioRequest usuarioRequest = request.getBody();

		UsuarioDto usuarioObject = gestionarUsuarioBusiness
				.getUsuario(usuarioRequest.getUsuario().getUsername());

		ResponseMessage<GetUsuarioResponse> response = new ResponseMessage<GetUsuarioResponse>();

		GetUsuarioResponse usuarioResponse = new GetUsuarioResponse();
		usuarioResponse.setUsuario(usuarioObject);
		response.setBody(usuarioResponse);
		
		return response;
	}
	
	
	@RequestMapping(value = "/validate", method = RequestMethod.POST, headers = "Accept=application/json", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseMessage<GetUsuarioResponse> validateUsuario(
			@RequestBody @Valid RequestMessage<GetUsuarioRequest> request)
			throws BusinessException {

		GetUsuarioRequest usuarioRequest = request.getBody();

		UsuarioDto usuarioObject = gestionarUsuarioBusiness
				.validateUsuario(usuarioRequest.getUsuario().getUsername(), 
						          usuarioRequest.getUsuario().getPassword());

		//UsuarioDto usuarioObject = gestionarUsuarioBusiness
			//	.getUsuario(usuarioRequest.getUsuario().getIdUsuario());
		
		ResponseMessage<GetUsuarioResponse> response = new ResponseMessage<GetUsuarioResponse>();

		GetUsuarioResponse usuarioResponse = new GetUsuarioResponse();
		usuarioResponse.setUsuario(usuarioObject);
		response.setBody(usuarioResponse);
		
		return response;
	}

}
