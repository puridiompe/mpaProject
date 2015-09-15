package com.puridiompe.mpa.rest.controller.general.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.puridiompe.mpa.common.rest.message.RequestMessage;
import com.puridiompe.mpa.rest.controller.general.message.GetGpsRequest;

/**
 * 
 * @author Lucho
 *
 */

@Component
public class GetGpsValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {		
		return RequestMessage.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		RequestMessage<GetGpsRequest> request = (RequestMessage<GetGpsRequest>) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,
							"body.gps.imei",
							"validation.request.pedidos.comentario.required");
		
	}

}
