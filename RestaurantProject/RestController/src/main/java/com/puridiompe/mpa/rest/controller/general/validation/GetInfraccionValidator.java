package com.puridiompe.mpa.rest.controller.general.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.puridiompe.mpa.common.rest.message.RequestMessage;
import com.puridiompe.mpa.rest.controller.general.message.GetInfraccionRequest;

/**
 * 
 * @author Lucho
 *
 */

@Component
public class GetInfraccionValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {		
		return RequestMessage.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		RequestMessage<GetInfraccionRequest> request = (RequestMessage<GetInfraccionRequest>) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,
							"body.infraccion.codigo",
							"validation.request.pedidos.comentario.required");
		
	}

}
