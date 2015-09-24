/**
 * 
 */
package com.puridiompe.mpa.rest.security.filter;

import java.io.IOException;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.puridiompe.mpa.rest.security.message.LoginRequest;
import com.puridiompe.mpa.rest.security.token.LoginAuthenticationToken;

/**
 * @author Johnny
 *
 */
public class LoginAuthenticationFilter extends
		AbstractAuthenticationProcessingFilter {

	private static final Logger logger = LoggerFactory
			.getLogger(LoginAuthenticationFilter.class);

	private String localIp;

	private Set<String> localAddresses = new HashSet<String>();
	
	private MappingJackson2HttpMessageConverter messageConverter;

	private ObjectMapper mapper;

	public LoginAuthenticationFilter() {
		super(new AntPathRequestMatcher("/login", "POST"));
		
		localIp = getServerIp(localAddresses);
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
			
			if (imei == null || imei.length() <= 0) {
				imei = getClientRemoteIp(request);
			}
			
			logger.info("Login - Username : " + username);
			
			logger.info("Login - Imei : " + imei);
			
			if (localAddresses.contains(imei)) {
				logger.info("Login in local connection");
				imei = localIp;
			}

		} catch (JsonParseException e) {
			logger.error("Error in JsonParse", e);
			
		} catch (JsonMappingException e) {
			logger.error("Error in JsonMapping", e);
		} catch (IOException e) {
			logger.error("Error in IO", e);
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
	 * @param messageConverter
	 *            the messageConverter to set
	 */
	public void setMessageConverter(
			MappingJackson2HttpMessageConverter messageConverter) {
		this.messageConverter = messageConverter;

		this.mapper = messageConverter.getObjectMapper();
	}
	
	/**
	 * Gets remote client ip address from request object
	 * 
	 * @param request
	 * @return
	 */
	private String getClientRemoteIp(HttpServletRequest request) {
		String remoteAddress = request.getHeader("X-Forwarded-For");
		String clientIpAddress = null;
		
		if (remoteAddress != null && remoteAddress.length() > 0)
		{
			logger.debug("X-Forwarded-For " + remoteAddress);
			
			clientIpAddress = remoteAddress.split(",")[0];
			
		} else {
			remoteAddress = request.getHeader("X-FORWARDED-FOR");
			
			if (remoteAddress != null && remoteAddress.length() > 0)
			{
				logger.debug("X-FORWARDED-FOR " + remoteAddress);
				
				clientIpAddress = remoteAddress.split(",")[0];
			}
		}
		
		if (clientIpAddress == null) {
			
			clientIpAddress = request.getRemoteAddr();
			
			logger.debug("RemoteAddress " + clientIpAddress);
		}
		
		return clientIpAddress;
	}

	/**
	 * Gets local server Ip 
	 * 
	 * @return
	 */
	private String getServerIp(Set<String> localAddresses) {

		String localIp = null;
		Enumeration<NetworkInterface> interfaces = null;

		try {
			interfaces = NetworkInterface.getNetworkInterfaces();
		} catch (SocketException exception) {
			logger.error("Error getting Network Interfaces", exception);
		}

		if (interfaces != null) {

			while (interfaces.hasMoreElements()) {
				NetworkInterface current = interfaces.nextElement();

				logger.debug("Curent NetworkInterface " + current);

				try {
					if (!current.isUp() || current.isLoopback()
							|| current.isVirtual()) {
						continue;
					}
				} catch (SocketException exception) {
					logger.error("Error when Network Interface is evaluated",
							exception);
				}

				Enumeration<InetAddress> addresses = current.getInetAddresses();

				while (addresses.hasMoreElements()) {
					InetAddress current_addr = addresses.nextElement();
					
					logger.debug("FFCurrent HostAddress "
							+ current_addr.getHostAddress());

					if (current_addr.isLoopbackAddress()) {
						continue;
					}

					logger.debug("Current HostAddress "
							+ current_addr.getHostAddress());
					
					localAddresses.add(current_addr.getHostAddress());

					if (current_addr instanceof Inet4Address) {

						logger.debug("Current HostAddress is Inet4Address");

						localIp = current_addr.getHostAddress();

						//break;
					} else if (current_addr instanceof Inet6Address) {

						logger.debug("Current HostAddress is Inet6Address");
					} else {
						logger.debug("Current HostAddress is other type");
					}
				}
			}
		}

		return localIp;
	}
}
