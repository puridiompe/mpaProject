/**
 * 
 */
package com.puridiompe.mpa.business.exception;

/**
 * @author Johnny
 *
 */
@SuppressWarnings("serial")
public class GenericBusinessException extends BusinessException {

	public GenericBusinessException(String code, String message) {
		super(code, message);
	}

	public GenericBusinessException(String code, String message,
			Exception exception) {
		super(code, message, exception);
	}

}
