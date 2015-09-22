/**
 * 
 */
package com.puridiompe.mpa.rest.security.filter;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.puridiompe.mpa.common.context.ApplicationContextProvider;
import com.puridiompe.mpa.rest.security.message.LoginRequest;
import com.puridiompe.mpa.rest.security.token.LoginAuthenticationToken;

/**
 * @author Johnny
 *
 */
public class LoginAuthenticationFilter extends
		AbstractAuthenticationProcessingFilter {

	private MappingJackson2HttpMessageConverter messageConverter;

	private ObjectMapper mapper;

	public LoginAuthenticationFilter() {
		super(new AntPathRequestMatcher("/login", "POST"));
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request,
			HttpServletResponse response) throws AuthenticationException {
		if (!request.getMethod().equals("POST")) {
			throw new AuthenticationServiceException(
					"Authentication method not supported: "
							+ request.getMethod());
		}
		
		String username = null;
		String password = null;
		String imei = null;

		try {

			LoginRequest requestObject = mapper.readValue(request.getReader(),
					LoginRequest.class);

			username = requestObject.getUsername();
			password = requestObject.getPassword();
			imei = requestObject.getImei();

		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (username == null) {
			username = "";
		}

		if (password == null) {
			password = "";
		}

		username = username.trim();

		UsernamePasswordAuthenticationToken authRequest = new LoginAuthenticationToken(
				username, password, imei);

		// Allow subclasses to set the "details" property
		// setDetails(request, authRequest);

		authRequest.setDetails(authenticationDetailsSource
				.buildDetails(request));

		return this.getAuthenticationManager().authenticate(authRequest);
	}

	/**
	 * @param messageConverter the messageConverter to set
	 */
	public void setMessageConverter(
			MappingJackson2HttpMessageConverter messageConverter) {
		this.messageConverter = messageConverter;
		
		this.mapper = messageConverter.getObjectMapper();
	}
}
