/**
 * 
 */
package com.puridiompe.mpa.rest.controller.general.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.puridiompe.mpa.rest.controller.general.message.GetVehiculoRequest;
import com.puridiompe.mpa.rest.controller.message.RequestMessage;

/**
 * @author Johnny
 *
 */
@Component
public class GetVehiculoValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return RequestMessage.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		RequestMessage<GetVehiculoRequest> request = (RequestMessage<GetVehiculoRequest>) target;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors,
				"body.vehiculo.idPlaca",
				"validation.request.pedidos.comentario.required");

		// if (request.getBody().getPedido().getFechaSolicitud() == null) {
		//
		// errors.rejectValue("body.pedido.fechaSolicitud",
		// "validation.request.pedidos.fechaSolicitud.required");
		// }

		// ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName",
		// "required.firstName", "Firstname is required.");

	}

}
