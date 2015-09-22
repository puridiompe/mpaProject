/**
 * 
 */
package com.puridiompe.mpa.rest.security.token;

import java.util.Collection;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

/**
 * @author Johnny
 *
 */
@SuppressWarnings("serial")
public class LoginAuthenticationToken extends
		UsernamePasswordAuthenticationToken {

	private String imei;

	public LoginAuthenticationToken(Object principal, Object credentials, String imei) {
		super(principal, credentials);
		this.imei = imei;
	}
	
	public LoginAuthenticationToken(Object principal, Object credentials,
			Collection<? extends GrantedAuthority> authorities, String imei) {
		super(principal, credentials, authorities);
		this.imei = imei;
	}
	

	/**
	 * @return the imei
	 */
	public String getImei() {
		return imei;
	}

}
