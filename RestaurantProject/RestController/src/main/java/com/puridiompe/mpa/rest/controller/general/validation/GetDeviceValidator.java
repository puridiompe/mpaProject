package com.puridiompe.mpa.rest.controller.general.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.puridiompe.mpa.common.rest.message.RequestMessage;
import com.puridiompe.mpa.rest.controller.general.message.GetDeviceRequest;

/**
 * 
 * @author Lucho
 *
 */

@Component
public class GetDeviceValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {		
		return RequestMessage.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		RequestMessage<GetDeviceRequest> request = (RequestMessage<GetDeviceRequest>) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,
							"body.device.deviceId",
							"validation.request.pedidos.comentario.required");
		
	}

}
