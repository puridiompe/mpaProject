package com.puridiompe.mpa.rest.controller.general.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.puridiompe.mpa.common.rest.message.RequestMessage;
import com.puridiompe.mpa.rest.controller.general.message.GetCiudadanosRequest;

@Component
public class GetCiudadanosValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		
		return RequestMessage.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		RequestMessage<GetCiudadanosRequest> request = (RequestMessage<GetCiudadanosRequest>) target;		
		
		
		for(Integer i = 0; i < request.getBody().getCiudadanos().size(); i++){
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,
								"body.ciudadanoArray["+i.toString()+"].dni",
								"validation.request.pedidos.comentario.required");
	
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,
					"body.ciudadanoArray["+i.toString()+"].apellidoPaterno",
					"validation.request.pedidos.comentario.required");
			
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,
					"body.ciudadanoArray["+i.toString()+"].apellidoMaterno",
					"validation.request.pedidos.comentario.required");
			
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,
					"body.ciudadanoArray["+i.toString()+"].email",
					"validation.request.pedidos.comentario.required");
		}
	}

}
