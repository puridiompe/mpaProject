/**
 * 
 */
package com.puridiompe.mpa.common.rest.message;

import java.util.List;

/**
 * @author Puridiom-PE
 *
 */
public class ResponseError extends ResponseBody {

	private final List<ErrorDetail> errors;

	public ResponseError(List<ErrorDetail> errors) {
		this.errors = errors;
	}

	/**
	 * @return the errors
	 */
	public List<ErrorDetail> getErrors() {
		return errors;
	}

	// public final String url;
	// public final String exception;
	//
	// public ResponseError(String url, Exception exception) {
	// this.url = url;
	// this.exception = exception.getMessage();
	// }
	//
	// public ResponseError(String url, String errorMessage) {
	// this.url = url;
	// this.exception = errorMessage;
	// }

}
