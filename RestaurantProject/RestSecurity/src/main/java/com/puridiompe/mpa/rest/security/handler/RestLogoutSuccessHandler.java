/**
 * 
 */
package com.puridiompe.mpa.rest.security.handler;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.puridiompe.mpa.common.rest.message.ResponseMessage;
import com.puridiompe.mpa.rest.security.message.LogoutResponse;

/**
 * @author
 *
 */
@Component
public class RestLogoutSuccessHandler extends SimpleUrlLogoutSuccessHandler {

	@Autowired
	private MessageSource messageSource;

	@Autowired
	private MappingJackson2HttpMessageConverter messageConverter;

	private ObjectMapper mapper;
	
	@Autowired
	private HeaderAuthenticationHandler authenticationHandler;
	
	@Override
	public void onLogoutSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		String refererUrl = request.getHeader("Referer");
//		Logger.info(this, "Logout from: " + refererUrl);
//
//		Logger.info(this, "==================== SUCCESS ====================");

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.setStatus(HttpServletResponse.SC_OK);
		
		authenticationHandler.resetHeader(response);
		
		LogoutResponse logoutResponse = new LogoutResponse();

		logoutResponse.setStatus("OK");
		logoutResponse.setLastLogout(new Date());

		ResponseMessage<LogoutResponse> responseMessage = new ResponseMessage<LogoutResponse>();
		responseMessage.setBody(logoutResponse);

		PrintWriter writer = response.getWriter();

		mapper.writeValue(writer, responseMessage);

		writer.flush();
		writer.close();
	}

	@PostConstruct
	private void initialize() {
		mapper = messageConverter.getObjectMapper();
	}
}
