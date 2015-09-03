package com.puridiompe.mpa.rest.controller.general.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.puridiompe.mpa.rest.controller.general.message.GetUsuarioRequest;
import com.puridiompe.mpa.rest.controller.message.RequestMessage;


public class GetUsuarioValidator  implements Validator  {

	@Override
	public boolean supports(Class<?> clazz) {
		return RequestMessage.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		RequestMessage<GetUsuarioRequest> request = (RequestMessage<GetUsuarioRequest>) target;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors,
				"body.login.idUsuario",
				"validation.request.pedidos.comentario.required");
	}

}
