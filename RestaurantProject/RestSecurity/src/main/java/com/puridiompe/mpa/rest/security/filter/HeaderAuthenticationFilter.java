/**
 * 
 */
package com.puridiompe.mpa.rest.security.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.filter.GenericFilterBean;

import com.puridiompe.mpa.business.security.dto.UsuarioDto;
import com.puridiompe.mpa.rest.security.handler.HeaderAuthenticationHandler;
import com.puridiompe.mpa.rest.security.token.LoginAuthenticationToken;

/**
 * @author Johnny
 *
 */
public class HeaderAuthenticationFilter extends GenericFilterBean {

	private UserDetailsService userDetailsService;
	
	private HeaderAuthenticationHandler authenticationHandler;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {

		UserDetails userDetails = loadUserDetails((HttpServletRequest) request);
		SecurityContext contextBeforeChainExecution = createSecurityContext(userDetails);

		try {
			SecurityContextHolder.setContext(contextBeforeChainExecution);
			if (contextBeforeChainExecution.getAuthentication() != null
					&& contextBeforeChainExecution.getAuthentication()
							.isAuthenticated()) {
//				String userName = (String) contextBeforeChainExecution
//						.getAuthentication().getPrincipal();
				UsuarioDto usuario = (UsuarioDto) contextBeforeChainExecution
						.getAuthentication().getPrincipal();
				String userName = usuario.getUsername();
				String imei = usuario.getImei();
				authenticationHandler.addHeader((HttpServletResponse) response, userName, imei);
			}
			filterChain.doFilter(request, response);
		} finally {
			// Clear the context and free the thread local
			SecurityContextHolder.clearContext();
		}
		
//	 } catch (AuthenticationException authenticationException) {
//         //If it fails clear this threads context and kick off the authentication entry point process.
//         SecurityContextHolder.clearContext();
//         authenticationEntryPoint.commence(request, response, authenticationException);
//     }
	}

	private SecurityContext createSecurityContext(UserDetails userDetails) {
		if (userDetails != null) {
			SecurityContextImpl securityContext = new SecurityContextImpl();
//			Authentication authentication = new UsernamePasswordAuthenticationToken(
//					userDetails.getUsername(), userDetails.getPassword(),
//					userDetails.getAuthorities());
			Authentication authentication = new LoginAuthenticationToken(
					userDetails, null,
					userDetails.getAuthorities(), ((UsuarioDto)userDetails).getImei());
			securityContext.setAuthentication(authentication);
			return securityContext;
		}
		return SecurityContextHolder.createEmptyContext();
	}

	private UserDetails loadUserDetails(HttpServletRequest request) {
		String userName = authenticationHandler.getUserName(request);

		return userName != null ? userDetailsService
				.loadUserByUsername(userName) : null;
	}

	public void userDetailsService(UserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}

	public void authenticationHandler(HeaderAuthenticationHandler headerAuthenticationHandler) {
		this.authenticationHandler = headerAuthenticationHandler;
	}

}
