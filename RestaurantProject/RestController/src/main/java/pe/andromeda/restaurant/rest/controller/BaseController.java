/**
 * 
 */
package pe.andromeda.restaurant.rest.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import pe.andromeda.restaurant.business.exception.BusinessException;
import pe.andromeda.restaurant.rest.controller.message.ResponseError;

/**
 * @author Puridiom-PE
 *
 */
public abstract class BaseController {

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(BusinessException.class)
	public @ResponseBody ResponseError handleException(
			HttpServletRequest request, Exception exception) {
		return new ResponseError(request.getRequestURI(), exception);

	}
}
