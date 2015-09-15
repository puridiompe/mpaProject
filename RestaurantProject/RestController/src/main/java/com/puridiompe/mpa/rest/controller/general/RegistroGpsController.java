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
import com.puridiompe.mpa.business.general.GestionarGpsBusiness;
import com.puridiompe.mpa.business.general.dto.GpsDto;
import com.puridiompe.mpa.common.rest.message.RequestMessage;
import com.puridiompe.mpa.common.rest.message.ResponseMessage;
import com.puridiompe.mpa.rest.controller.BaseController;
import com.puridiompe.mpa.rest.controller.general.message.GetGpsRequest;
import com.puridiompe.mpa.rest.controller.general.message.GetGpsResponse;
import com.puridiompe.mpa.rest.controller.general.message.GetGpssResponse;
import com.puridiompe.mpa.rest.controller.general.validation.GetGpsValidator;


/**
 * @author Lucho
 *
 */

@RestController
@RequestMapping("/transportes/gps")
public class RegistroGpsController extends BaseController {
	
	@Autowired
	private GestionarGpsBusiness gestionarGpsBusiness;
	
	@Autowired
	private GetGpsValidator getGpsValidator;
	
	@InitBinder
	protected void InitBinder(WebDataBinder binder){
		binder.setValidator(getGpsValidator);
	}
	
	@RequestMapping(value = "/get", method = RequestMethod.POST, headers = "Accept=application/json", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseMessage<GetGpsResponse> getGps(
			@RequestBody @Valid RequestMessage<GetGpsRequest> request)
			throws BusinessException {
		
		GetGpsRequest gpsRequest = request.getBody();
		
		GpsDto gpsObject = gestionarGpsBusiness.getGpsByImei(gpsRequest.getGps().getImei());
		
		ResponseMessage<GetGpsResponse> response = new ResponseMessage<GetGpsResponse>();
		
		GetGpsResponse gpsResponse = new GetGpsResponse();
		
		gpsResponse.setGps(gpsObject);
		
		response.setBody(gpsResponse);
		
		return response;		
	}	
	
	@RequestMapping(value = "/getAll", method = RequestMethod.POST, headers = "Accept=application/json", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseMessage<GetGpssResponse> getGpss()			
			throws BusinessException {		
		
		
		List<GpsDto> gpssObject = gestionarGpsBusiness.getAll();
		
		ResponseMessage<GetGpssResponse> response = new ResponseMessage<GetGpssResponse>();
		
		GetGpssResponse gpssResponse = new GetGpssResponse();
		
		gpssResponse.setGpss(gpssObject);
		
		response.setBody(gpssResponse);
		
		return response;		
	}	

}