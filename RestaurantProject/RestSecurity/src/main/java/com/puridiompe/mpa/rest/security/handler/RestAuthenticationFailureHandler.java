/**
 * 
 */
package com.puridiompe.mpa.rest.security.handler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.PostConstruct;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.puridiompe.mpa.common.rest.message.ResponseError;
import com.puridiompe.mpa.common.rest.message.ResponseMessage;
import com.puridiompe.mpa.common.rest.util.RestMessage;

/**
 * @author Johnny
 *
 */
@Component
public class RestAuthenticationFailureHandler extends
		SimpleUrlAuthenticationFailureHandler {

	@Autowired
	private MessageSource messageSource;

	@Autowired
	private MappingJackson2HttpMessageConverter messageConverter;

	private ObjectMapper mapper;

	@Override
	public void onAuthenticationFailure(HttpServletRequest request,
			HttpServletResponse response, AuthenticationException exception)
			throws IOException, ServletException {

//		Logger.info(this, "==================== AUTH FAILURE ====================");
//
//		Logger.error(this, exception);

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

		ResponseMessage<ResponseError> responseObject = new ResponseMessage<ResponseError>();

		responseObject.setBody(RestMessage.getResponseError(messageSource,
				"error.authentication.system"));

		PrintWriter writer = response.getWriter();

		mapper.writeValue(writer, responseObject);
		writer.flush();
		writer.close();
	}

	@PostConstruct
	private void initialize() {
		mapper = messageConverter.getObjectMapper();
	}

}