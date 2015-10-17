/**
 * 
 */
package com.puridiompe.mpa.rest.controller.seguridad;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.puridiompe.mpa.business.exception.BusinessException;
import com.puridiompe.mpa.business.general.GestionarDeviceBusiness;
import com.puridiompe.mpa.business.security.GestionarUserDetailsBusiness;
import com.puridiompe.mpa.business.security.dto.UsuarioDto;
import com.puridiompe.mpa.common.rest.message.RequestMessage;
import com.puridiompe.mpa.common.rest.message.ResponseMessage;
import com.puridiompe.mpa.common.security.exception.RegisteredPublicImeiException;
import com.puridiompe.mpa.rest.controller.BaseController;
import com.puridiompe.mpa.rest.controller.general.message.GetDeviceRequest;
import com.puridiompe.mpa.rest.controller.seguridad.message.ApplicationResponse;
import com.puridiompe.mpa.rest.security.handler.HeaderAuthenticationHandler;
import com.puridiompe.mpa.rest.security.util.Network;

/**
 * @author Johnny
 *
 */
@RestController
@RequestMapping("/transportes/init")
public class ApplicationInitializerController extends BaseController {

	@Autowired
	private HeaderAuthenticationHandler authenticationHandler;

	@Autowired
	private GestionarUserDetailsBusiness gestionarUserDetailsBusiness;

	@Autowired
	private GestionarDeviceBusiness gestionarDeviceBusiness;

	@RequestMapping(method = RequestMethod.POST, headers = "Accept=application/json", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseMessage initialize(@RequestBody RequestMessage<GetDeviceRequest> request,
			HttpServletRequest servletRequest, HttpServletResponse response) throws BusinessException, RegisteredPublicImeiException {

		GetDeviceRequest deviceRequest = request.getBody();

		String imei = Network.getClientImei(deviceRequest.getDevice().getImei(), servletRequest);

		gestionarDeviceBusiness.checkDeviceByImei(imei);

		ApplicationResponse applicationResponse = new ApplicationResponse();

		UsuarioDto user = (UsuarioDto) gestionarUserDetailsBusiness.createAnonymusUser();

		// LoginResponse loginResponse = new LoginResponse();

		// *loginResponse.setUsername(user.getUsername());
		// *loginResponse.setStatus("OK");
		// loginResponse.setLastLogin(user.getLastLogin());
		// loginResponse.setNombres(user.getNombres());
		// loginResponse.setApellidoPaterno(user.getApellidoPaterno());
		// loginResponse.setApellidoMaterno(user.getApellidoMaterno());
		// *loginResponse.setPerfil(user.getAuthorities());

		applicationResponse.setPerfil(user.getAuthorities());
		ResponseMessage<ApplicationResponse> responseMessage = new ResponseMessage<ApplicationResponse>();
		responseMessage.setBody(applicationResponse);

		authenticationHandler.addHeader(response, user.getUsername(), imei);

		return responseMessage;
	}

}
