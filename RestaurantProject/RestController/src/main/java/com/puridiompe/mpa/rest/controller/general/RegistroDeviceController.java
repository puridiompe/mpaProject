/**
 * 
 */
package com.puridiompe.mpa.rest.controller.general;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.puridiompe.mpa.business.exception.BusinessException;
import com.puridiompe.mpa.business.general.GestionarDeviceBusiness;
import com.puridiompe.mpa.business.general.dto.DeviceDto;
import com.puridiompe.mpa.common.rest.message.RequestMessage;
import com.puridiompe.mpa.common.rest.message.ResponseMessage;
import com.puridiompe.mpa.rest.controller.BaseController;
import com.puridiompe.mpa.rest.controller.general.message.GetDeviceRequest;
import com.puridiompe.mpa.rest.controller.general.message.GetDeviceResponse;
import com.puridiompe.mpa.rest.controller.general.message.GetDevicesResponse;
import com.puridiompe.mpa.rest.controller.general.validation.GetDeviceValidator;
import com.puridiompe.mpa.rest.security.message.LoginRequest;


/**
 * @author Lucho
 *
 */

@Controller
@RequestMapping("/transportes/device")
public class RegistroDeviceController extends BaseController {
	
	@Autowired
	private GestionarDeviceBusiness gestionarDeviceBusiness;
	
	@Autowired
	private GetDeviceValidator getDeviceValidator;
	
	@InitBinder
	protected void InitBinder(WebDataBinder binder){
		binder.setValidator(getDeviceValidator);
	}
	
	@RequestMapping(value = "/get", method = RequestMethod.POST, headers = "Accept=application/json", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseMessage<GetDeviceResponse> getDevice(
			@RequestBody @Valid RequestMessage<GetDeviceRequest> request)
			throws BusinessException {
		
		GetDeviceRequest deviceRequest = request.getBody();
		
		DeviceDto deviceObject = gestionarDeviceBusiness.getDeviceByImei(deviceRequest.getDevice().getImei());
		
		ResponseMessage<GetDeviceResponse> response = new ResponseMessage<GetDeviceResponse>();
		
		GetDeviceResponse deviceResponse = new GetDeviceResponse();
		
		deviceResponse.setDevice(deviceObject);
		
		response.setBody(deviceResponse);
		
		return response;		
	}	
	
	@RequestMapping(value = "/checkDevice")//, method = RequestMethod.POST, headers = "Accept=application/json")
	public String checkDevice(
			/*@RequestBody RequestMessage<GetDeviceRequest> request, */HttpServletRequest servletRequest)
			throws BusinessException {
		
		//GetDeviceRequest deviceRequest = request.getBody();
		
//		boolean isMpaDevice = gestionarDeviceBusiness
//				.checkDeviceByImei(deviceRequest.getDevice().getImei());
		
		boolean isMpaDevice = false;

		if (isMpaDevice) {
			return "forward:/test2";
		} else {
			LoginRequest loginRequest = new LoginRequest();
			
			loginRequest.setImei("asdada");
			loginRequest.setUsername("anonymus");
			
			servletRequest.setAttribute("anonymusRequest", loginRequest);
			
			return "forward:/transportes/device/getAll";
		}
	}
	
	@RequestMapping(value = "/getAll", method = RequestMethod.POST, headers = "Accept=application/json", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseMessage<GetDevicesResponse> getDevices()			
			throws BusinessException {		
		
		
		List<DeviceDto> devicesObject = gestionarDeviceBusiness.getAll();
		
		ResponseMessage<GetDevicesResponse> response = new ResponseMessage<GetDevicesResponse>();
		
		GetDevicesResponse devicesResponse = new GetDevicesResponse();
		
		devicesResponse.setDevices(devicesObject);
		
		response.setBody(devicesResponse);
		
		return response;		
	}	

}