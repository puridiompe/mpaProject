/**
 * 
 */
package pe.andromeda.restaurant.rest.controller.message;

/**
 * @author Puridiom-PE
 *
 */
public class RequestMessage<T extends RequestBody> {

	private RequestHeader header;

	private T body;

	/**
	 * @return the header
	 */
	public RequestHeader getHeader() {
		return header;
	}

	/**
	 * @param header
	 *            the header to set
	 */
	public void setHeader(RequestHeader header) {
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
