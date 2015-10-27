package com.puridiompe.mpa.common.security.exception;

import org.springframework.security.core.AuthenticationException;

@SuppressWarnings("serial")
public class SessionException extends AuthenticationException {

	public SessionException(String message) {
		super(message);
	}
}
