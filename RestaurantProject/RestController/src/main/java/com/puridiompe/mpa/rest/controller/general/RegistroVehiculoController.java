/**
 * 
 */
package com.puridiompe.mpa.rest.controller.general;

import java.util.List;

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
import com.puridiompe.mpa.business.general.GestionarPapeletaBusiness;
import com.puridiompe.mpa.business.general.GestionarVehiculoBusiness;
import com.puridiompe.mpa.business.general.dto.PapeletaDto;
import com.puridiompe.mpa.business.general.dto.ReclamoDto;
import com.puridiompe.mpa.business.general.dto.VehiculoDto;
import com.puridiompe.mpa.common.rest.message.RequestMessage;
import com.puridiompe.mpa.common.rest.message.ResponseMessage;
import com.puridiompe.mpa.common.security.exception.SecurityException;
import com.puridiompe.mpa.rest.controller.BaseController;
import com.puridiompe.mpa.rest.controller.general.message.GetPapeletaResponse;
import com.puridiompe.mpa.rest.controller.general.message.GetReclamoResponse;
import com.puridiompe.mpa.rest.controller.general.message.GetVehiculoRequest;
import com.puridiompe.mpa.rest.controller.general.message.GetVehiculoResponse;
import com.puridiompe.mpa.rest.controller.general.validation.GetVehiculoValidator;

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
	private GestionarPapeletaBusiness gestionarPapeletaBusiness;

	@Autowired
	private GetVehiculoValidator getVehiculoValidator;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(getVehiculoValidator);
	}

	@RequestMapping(value = "/get", method = RequestMethod.POST, headers = "Accept=application/json", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseMessage<GetVehiculoResponse> getVehiculo(
			@RequestBody @Valid RequestMessage<GetVehiculoRequest> request)
			throws BusinessException, SecurityException {

		GetVehiculoRequest vehiculoRequest = request.getBody();

		VehiculoDto vehiculoObject = gestionarVehiculoBusiness
				.getVehiculo(vehiculoRequest.getVehiculo().getIdPlaca());

		ResponseMessage<GetVehiculoResponse> response = new ResponseMessage<GetVehiculoResponse>();

		GetVehiculoResponse vehiculoResponse = new GetVehiculoResponse();

		vehiculoResponse.setVehiculo(vehiculoObject);

		response.setBody(vehiculoResponse);

		return response;
	}
	
	@RequestMapping(value = "/getPapeletas", method = RequestMethod.POST, headers = "Accept=application/json", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseMessage<GetPapeletaResponse> getPapeletas(
			@RequestBody @Valid RequestMessage<GetVehiculoRequest> request)			
			throws BusinessException {		
		
		GetVehiculoRequest vehiculoRequest = request.getBody();
		
		List<PapeletaDto> reclamosObject = gestionarPapeletaBusiness.getPapeletas(vehiculoRequest.getVehiculo().getIdPlaca());
		
		ResponseMessage<GetPapeletaResponse> response = new ResponseMessage<GetPapeletaResponse>();
		
		GetPapeletaResponse papeletaResponse = new GetPapeletaResponse();
		
		papeletaResponse.setPapeletas(reclamosObject);
		
		response.setBody(papeletaResponse);
		
		return response;		
	}
	
	@RequestMapping(value = "/getNumeroVehiculos", method = RequestMethod.POST, headers = "Accept=application/json", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseMessage<GetVehiculoResponse> getNumeroVehiculos() throws SecurityException {	
		
		Integer numeroVehiculos = gestionarVehiculoBusiness.countVehiculosByImei();
		
		ResponseMessage<GetVehiculoResponse> response = new ResponseMessage<GetVehiculoResponse>();
		
		GetVehiculoResponse numeroVehiculosResponse = new GetVehiculoResponse();
		
		numeroVehiculosResponse.setNumeroVehiculos(numeroVehiculos);
		
		response.setBody(numeroVehiculosResponse);
		
		return response;
	}
	
}
