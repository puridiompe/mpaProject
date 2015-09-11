package com.puridiompe.mpa.rest.controller.general.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.puridiompe.mpa.common.rest.message.RequestBody;
import com.puridiompe.mpa.common.rest.message.RequestMessage;
import com.puridiompe.mpa.rest.controller.general.message.GetInfraccionesRequest;


/**
 * 
 * @author Lucho
 *
 */

@Component
public class GetInfraccionesValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		
		return RequestBody.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		RequestMessage<GetInfraccionesRequest> request = (RequestMessage<GetInfraccionesRequest>) target;
		
		ValidationUtils.rejectIfEmpty(errors, "body.infracciones", "validation.request.pedidos.comentario.required");
		
	}
	

}