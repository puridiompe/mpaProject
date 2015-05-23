/**
 * 
 */
package com.puridiompe.infracciones.rest.controller.message;

/**
 * @author Puridiom-PE
 *
 */
public class ResponseMessage<T extends ResponseBody> {

	private ResponseHeader header;

	private T body;

	/**
	 * @return the header
	 */
	public ResponseHeader getHeader() {
		return header;
	}

	/**
	 * @param header
	 *            the header to set
	 */
	public void setHeader(ResponseHeader header) {
		this.header = header;
	}

	/**
	 * @return the body
	 */
	public T getBody() {
		return body;
	}

	/**
	 * @param body
	 *            the body to set
	 */
	public void setBody(T body) {
		this.body = body;
	}
}
