/**
 * 
 */
package com.puridiompe.mpa.rest.controller.message;

/**
 * @author
 *
 */
public class ResponseError {

	public final String url;
	public final String exception;

	public ResponseError(String url, Exception exception) {
		this.url = url;
		this.exception = exception.getMessage();
	}

}
