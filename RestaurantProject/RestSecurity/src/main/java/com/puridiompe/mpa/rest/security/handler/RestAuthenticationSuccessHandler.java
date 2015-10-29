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
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.puridiompe.mpa.business.security.dto.UsuarioDto;
import com.puridiompe.mpa.common.rest.message.ResponseMessage;
import com.puridiompe.mpa.rest.security.message.LoginResponse;

/**
 * @author Johnny
 *
 */
@Component
public class RestAuthenticationSuccessHandler extends
		SimpleUrlAuthenticationSuccessHandler {

	@Autowired
	private MessageSource messageSource;

	@Autowired
	private MappingJackson2HttpMessageConverter messageConverter;

	private ObjectMapper mapper;

	@Autowired
	private HeaderAuthenticationHandler headerAuthenticationHandler;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		clearAuthenticationAttributes(request);
//		Logger.info(this, "==================== SUCCESS ====================");

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.setStatus(HttpServletResponse.SC_OK);

		LoginResponse loginResponse = new LoginResponse();

//		String username = ((UsuarioDto) authentication.getPrincipal())
//				.getUsername();
		
		UsuarioDto user = ((UsuarioDto) authentication.getPrincipal());
		
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		headerAuthenticationHandler.addHeader(response, user.getUsername(), user.getImei());
		// response.setHeader(arg0, token);

		loginResponse.setUsername(authentication.getName());
		loginResponse.setStatus("OK");
		//loginResponse.setLastLogin(new Date());
		loginResponse.setLastLogin(user.getLastLogin());
		loginResponse.setNombres(user.getNombres());
		loginResponse.setApellidoPaterno(user.getApellidoPaterno());
		loginResponse.setApellidoMaterno(user.getApellidoMaterno());
		loginResponse.setPerfil(user.getAuthorities());
		
		ResponseMessage<LoginResponse> responseMessage = new ResponseMessage<LoginResponse>();
		responseMessage.setBody(loginResponse);

		PrintWriter writer = response.getWriter();

		mapper.writeValue(writer, responseMessage);

		writer.flush();
		writer.close();

		clearAuthenticationAttributes(request);
	}

	@PostConstruct
	private void initialize() {
		mapper = messageConverter.getObjectMapper();
	}

}
