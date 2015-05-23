/**
 * 
 */
package com.puridiompe.mpa.rest.controller.seguridad.message;

import pe.andromeda.restaurant.rest.controller.message.RequestMessage;

/**
 * @author
 *
 */
public class LoginRequest extends RequestMessage {

	private String username;

	private String password;

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}
