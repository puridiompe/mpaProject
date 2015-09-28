/**
 * 
 */
package com.puridiompe.mpa.rest.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.puridiompe.mpa.business.exception.BusinessException;
import com.puridiompe.mpa.common.rest.message.ErrorDetail;
import com.puridiompe.mpa.common.rest.message.ResponseError;
import com.puridiompe.mpa.common.rest.message.ResponseMessage;


/**
 * @author Puridiom-PE
 *
 */
public abstract class BaseController {

	@Autowired
	private MessageSource messageSource;

	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(Exception.class)
	public @ResponseBody ResponseMessage<ResponseError> handleException(
			HttpServletRequest request, Exception exception) {

//		Logger.error(this, exception);

		ResponseMessage<ResponseError> response = new ResponseMessage<ResponseError>();

		response.setBody(getResponseError("error.general.system",
				exception.getMessage()));

		return response;

	}

	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	@ExceptionHandler(AuthenticationException.class)
	public @ResponseBody ResponseMessage<ResponseError> handleAuthenticationException(
			HttpServletRequest request, AuthenticationException exception) {

//		Logger.error(this, exception);

		ResponseMessage<ResponseError> response = new ResponseMessage<ResponseError>();

		response.setBody(getResponseError("error.authentication.system"));

		return response;
	}

	@ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
	@ExceptionHandler(AccessDeniedException.class)
	public @ResponseBody ResponseMessage<ResponseError> handleAccessDeniedException(
			HttpServletRequest request, AccessDeniedException exception) {

//		Logger.error(this, exception);

		ResponseMessage<ResponseError> response = new ResponseMessage<ResponseError>();

		response.setBody(getResponseError("error.accessdenied.system"));

		return response;
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public @ResponseBody ResponseMessage<ResponseError> handleValidationException(
			MethodArgumentNotValidException ex) {
		Locale locale = LocaleContextHolder.getLocale();
		List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
		List<ErrorDetail> errors = new ArrayList<ErrorDetail>();

		for (FieldError fieldError : fieldErrors) {
			String errorMessage = messageSource.getMessage(fieldError, locale);

			errors.add(new ErrorDetail(errorMessage));
		}

		// List<ObjectError> globalErrors = ex.getBindingResult()
		// .getGlobalErrors();
		// for (ObjectError objectError : globalErrors) {
		//
		// errors.add(new FormFieldError(objectError.getObjectName(),
		// objectError.getDefaultMessage()));
		// }
		// return new ResponseFieldError(errors);

		ResponseMessage<ResponseError> response = new ResponseMessage<ResponseError>();

		response.setBody(new ResponseError(errors));

		return response;
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(BusinessException.class)
	public @ResponseBody ResponseMessage<ResponseError> handleBusinessException(
			HttpServletRequest request, BusinessException exception) {

//		Logger.error(this, exception);

		ResponseMessage<ResponseError> response = new ResponseMessage<ResponseError>();

		response.setBody(getResponseError(exception.getMessage()));

		return response;

	}

	/**
	 * Get message with current Locale
	 * 
	 * @param messageCode
	 * @return
	 */
	protected String getMessage(String messageCode) {
		return getMessage(messageCode, LocaleContextHolder.getLocale());
	}

	/**
	 * Get message with a specific Locale
	 * 
	 * @param messageCode
	 * @param locale
	 * @return
	 */
	protected String getMessage(String messageCode, Locale locale) {
//		Logger.info(this, "Locale " + locale + " will be used for "
//				+ messageCode);

		return messageSource.getMessage(messageCode, null, locale);
	}

	private ResponseError getResponseError(String errorMessage) {
		return getResponseError(errorMessage, "");
	}

	private ResponseError getResponseError(String errorMessage,
			String detailError) {
		List<ErrorDetail> errors = new ArrayList<ErrorDetail>();
		Locale locale = LocaleContextHolder.getLocale();

//		Logger.info(this, "Locale " + locale
//				+ " will be used for error messages");

		// for (String message : errorMessage) {

		errors.add(new ErrorDetail(messageSource.getMessage(errorMessage, null,
				locale), detailError));
		// }

		return new ResponseError(errors);
	}
}
