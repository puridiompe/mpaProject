/**
 * 
 */
package com.puridiompe.mpa.rest.security.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.puridiompe.mpa.business.security.GestionarUserDetailsBusiness;
import com.puridiompe.mpa.rest.security.token.LoginAuthenticationToken;

/**
 * @author Johnny
 *
 */
public class CustomAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

	@Autowired
	private GestionarUserDetailsBusiness gestionarUserDetailsBusiness;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	protected void additionalAuthenticationChecks(UserDetails userDetails,
			UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
		if (authentication.getCredentials() == null) {
			// Logger.debug(this, "Authentication failed: no credentials
			// provided");

			throw new BadCredentialsException(
					messages.getMessage("AbstractUserDetailsAuthenticationProvider.badCredentials", "Bad credentials"));
		}

		String presentedPassword = authentication.getCredentials().toString();
		
		// Check encoded password
		// if (!passwordEncoder.matches(presentedPassword,userDetails.getPassword())) {
		if (!presentedPassword.equals(userDetails.getPassword())) {
			// Logger.debug(this,
			// "Authentication failed: password does not match stored value");

			throw new BadCredentialsException(
					messages.getMessage("AbstractUserDetailsAuthenticationProvider.badCredentials", "Bad credentials"));
		}
		
		// invocar funcion  actualizar el device  userdaetail
		String imei = ((LoginAuthenticationToken) authentication).getImei(); 
		
		 gestionarUserDetailsBusiness.setCurrentDevice(userDetails, imei);
		 gestionarUserDetailsBusiness.setLastLogin(userDetails.getUsername());
	}

	@Override
	protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication)
			throws AuthenticationException {
		UserDetails user = null;

		try {
			user = gestionarUserDetailsBusiness.loadUserByUsername(username);
		} catch (UsernameNotFoundException notFound) {
			// Logger.error(this, notFound);

			throw notFound;
		} catch (Exception repositoryProblem) {
			// Logger.error(this, repositoryProblem);

			throw new InternalAuthenticationServiceException(repositoryProblem.getMessage(), repositoryProblem);
		}

		if (user == null) {
			// Logger.error(this, "GestionarUserDetailsBusiness returned null");

			throw new InternalAuthenticationServiceException(
					//"UserDetailsService returned null, an user is required for authentication");
			messages.getMessage("AbstractUserDetailsAuthenticationProvider.InternalAuthenticationService", "UserDetailsService returned null, an user is required for authentication"));
		}

		return user;
	}

}
