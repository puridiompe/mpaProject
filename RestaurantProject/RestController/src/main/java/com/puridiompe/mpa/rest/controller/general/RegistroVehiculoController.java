/**
 * 
 */
package com.puridiompe.mpa.rest.controller.general;

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
import com.puridiompe.mpa.business.general.GestionarVehiculoBusiness;
import com.puridiompe.mpa.business.general.dto.VehiculoDto;
import com.puridiompe.mpa.rest.controller.BaseController;
import com.puridiompe.mpa.rest.controller.general.message.GetVehiculoRequest;
import com.puridiompe.mpa.rest.controller.general.message.GetVehiculoResponse;
import com.puridiompe.mpa.rest.controller.general.validation.GetVehiculoValidator;
import com.puridiompe.mpa.rest.controller.message.RequestMessage;
import com.puridiompe.mpa.rest.controller.message.ResponseMessage;

/**
 * @author Johnny
 *
 */
@RestController
@RequestMapping("/transportes/vehiculo")
public class RegistroVehiculoController extends BaseController {

	@Autowired
	private GestionarVehiculoBusiness gestionarVehiculoBusiness;

	@Autowired
	private GetVehiculoValidator getVehiculoValidator;
	
	

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(getVehiculoValidator);
	}

	@RequestMapping(value = "/get", method = RequestMethod.POST, headers = "Accept=application/json", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseMessage<GetVehiculoResponse> getVehiculo(
			@RequestBody @Valid RequestMessage<GetVehiculoRequest> request)
			throws BusinessException {

		GetVehiculoRequest vehiculoRequest = request.getBody();

		VehiculoDto vehiculoObject = gestionarVehiculoBusiness
				.getVehiculo(vehiculoRequest.getVehiculo().getIdPlaca());

		ResponseMessage<GetVehiculoResponse> response = new ResponseMessage<GetVehiculoResponse>();

		GetVehiculoResponse vehiculoResponse = new GetVehiculoResponse();

		vehiculoResponse.setVehiculo(vehiculoObject);

		response.setBody(vehiculoResponse);

		return response;
	}
	
}
