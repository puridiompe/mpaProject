package com.puridiompe.mpa.common.rest.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

import com.puridiompe.mpa.common.rest.message.ErrorDetail;
import com.puridiompe.mpa.common.rest.message.ResponseError;

public class RestMessage {

	public static ResponseError getResponseError(MessageSource messageSource,
			String... errorMessage) {
		List<ErrorDetail> errors = new ArrayList<ErrorDetail>();
		Locale locale = LocaleContextHolder.getLocale();

//		Logger.info(RestMessageUtil.class, "Locale " + locale
//				+ " will be used for error messages");

		for (String message : errorMessage) {

			errors.add(new ErrorDetail(messageSource.getMessage(message, null,
					locale)));

			errors.add(new ErrorDetail(message));
		}

		return new ResponseError(errors);
	}
}
