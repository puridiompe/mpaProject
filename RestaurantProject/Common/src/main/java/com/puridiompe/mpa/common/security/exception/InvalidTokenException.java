package com.puridiompe.mpa.common.security.exception;

import org.springframework.security.core.AuthenticationException;



@SuppressWarnings("serial")
public class InvalidTokenException extends AuthenticationException {

	public InvalidTokenException(String message) {
		super(message);
	}
}
