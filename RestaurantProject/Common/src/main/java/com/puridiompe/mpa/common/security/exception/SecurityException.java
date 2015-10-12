/**
 * 
 */
package com.puridiompe.mpa.common.security.exception;

import com.puridiompe.mpa.common.exception.HandledException;

/**
 * @author Johnny
 *
 */
@SuppressWarnings("serial")
public abstract class SecurityException extends HandledException {

	public SecurityException(String message) {
		super(message);
		// Log.error(this, "Exception[" + code + "] " + message);
	}

	public SecurityException(String message, Exception exception) {
		super(message, exception);
		// Log.error(this, "Exception[" + code + "] " + message);
	}

}
