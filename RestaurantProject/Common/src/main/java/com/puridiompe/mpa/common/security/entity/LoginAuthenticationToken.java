/**
 * 
 */
package com.puridiompe.mpa.common.security.entity;

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
	
	public LoginAuthenticationToken(Object principal, String imei, Collection<? extends GrantedAuthority> authorities) {
		super(principal, null, authorities);
		this.imei = imei;
	}
	

	/**
	 * @return the imei
	 */
	public String getImei() {
		return imei;
	}

}
