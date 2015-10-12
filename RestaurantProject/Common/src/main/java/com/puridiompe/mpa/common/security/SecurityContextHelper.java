/**
 * 
 */
package com.puridiompe.mpa.common.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;

import com.puridiompe.mpa.common.security.entity.LoginAuthenticationToken;
import com.puridiompe.mpa.common.security.exception.AuthenticationImeiNotFoundException;
import com.puridiompe.mpa.common.security.exception.AuthenticationUsernameNotFoundException;
import com.puridiompe.mpa.common.security.exception.InvalidAuthenticationObjectException;
import com.puridiompe.mpa.common.security.exception.NullAuthenticationException;
import com.puridiompe.mpa.common.security.exception.SecurityContextNotFoundException;
import com.puridiompe.mpa.common.security.exception.SecurityException;

/**
 * @author Johnny
 *
 */
public class SecurityContextHelper {

	/**
	 * Get username from authentication object
	 * 
	 * @return
	 * @throws SecurityException
	 */
	public static String getCurrentUsername() throws SecurityException {
		Authentication authenticationObject = getCurrentAuthenticationObject();

		String currentUsername = ((LoginAuthenticationToken) authenticationObject)
				.getName();

		if (StringUtils.isEmpty(currentUsername)) {

			throw new AuthenticationUsernameNotFoundException(
					"Username was not found in authentication object");
		}

		return currentUsername;
	}

	/**
	 * Get imei from authentication object
	 * 
	 * @return
	 * @throws SecurityException
	 */
	public static String getCurrentImei() throws SecurityException {

		Authentication authenticationObject = getCurrentAuthenticationObject();

		String currentImei = ((LoginAuthenticationToken) authenticationObject)
				.getImei();

		if (StringUtils.isEmpty(currentImei)) {

			throw new AuthenticationImeiNotFoundException(
					"Imei was not found in authentication object");
		}

		return currentImei;
	}

	/**
	 * Get authentication object from security context
	 * 
	 * @return
	 * @throws SecurityException
	 */
	private static Authentication getCurrentAuthenticationObject()
			throws SecurityException {

		SecurityContext context = SecurityContextHolder.getContext();

		if (context == null) {
			throw new SecurityContextNotFoundException(
					"Security context does not found");
		}

		Authentication authentication = context.getAuthentication();

		if (authentication == null) {
			throw new NullAuthenticationException(
					"Authentication is null in current security context");
		}

		if (!(authentication instanceof LoginAuthenticationToken)) {
			throw new InvalidAuthenticationObjectException(
					"Authentication does not have a valid type in security context");
		}

		return authentication;
	}

}
