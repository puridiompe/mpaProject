/**
 * 
 */
package com.puridiompe.mpa.rest.security.filter;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.util.Assert;
import org.springframework.web.filter.GenericFilterBean;

import com.puridiompe.mpa.business.general.GestionarLoginHistorialBusiness;
import com.puridiompe.mpa.business.general.GestionarDeviceBusiness;
import com.puridiompe.mpa.business.general.dto.DeviceDto;
import com.puridiompe.mpa.business.security.GestionarUserDetailsBusiness;
import com.puridiompe.mpa.business.security.dto.UsuarioDto;
import com.puridiompe.mpa.common.security.entity.LoginAuthenticationToken;
import com.puridiompe.mpa.common.security.exception.SessionException;
import com.puridiompe.mpa.rest.security.handler.HeaderAuthenticationHandler;

/**
 * @author Johnny
 *
 */
public class HeaderAuthenticationFilter extends GenericFilterBean {

	private GestionarDeviceBusiness gestionarDeviceBusiness;
	
	private GestionarUserDetailsBusiness userDetailsService;
	
	private HeaderAuthenticationHandler authenticationHandler;
	
	private AuthenticationFailureHandler failureHandler;

	private GestionarLoginHistorialBusiness loginHistorialService;
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {

		try {
			UserDetails userDetails = loadUserDetails((HttpServletRequest) request);
			SecurityContext contextBeforeChainExecution = createSecurityContext(userDetails);

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
				//aqui se le agrega el token  
				authenticationHandler.addHeader((HttpServletResponse) response, userName, imei);
			}
			filterChain.doFilter(request, response);
		} catch(AuthenticationException authenticationException){
			failureHandler.onAuthenticationFailure((HttpServletRequest)request, 
					(HttpServletResponse) response, authenticationException);
		}finally {
			// Clear the context and free the thread local
			SecurityContextHolder.clearContext();
		}
		
//	 } catch (AuthenticationException authenticationException) {
//         //If it fails clear this threads context and kick off the authentication entry point process.
//         SecurityContextHolder.clearContext();
//         authenticationEntryPoint.commence(request, response, authenticationException);
//     }
	}

	public void setAuthenticationFailureHandler(
			AuthenticationFailureHandler failureHandler) {
		Assert.notNull(failureHandler, "failureHandler cannot be null");
		this.failureHandler = failureHandler;
	}
	
	private SecurityContext createSecurityContext(UserDetails userDetails) {
		if (userDetails != null) {
			SecurityContextImpl securityContext = new SecurityContextImpl();
//			Authentication authentication = new UsernamePasswordAuthenticationToken(
//					userDetails.getUsername(), userDetails.getPassword(),
//					userDetails.getAuthorities());
			Authentication authentication = new LoginAuthenticationToken(
					userDetails, ((UsuarioDto)userDetails).getImei(),
					userDetails.getAuthorities());
			securityContext.setAuthentication(authentication);
			return securityContext;
		}
		return SecurityContextHolder.createEmptyContext();
	}

	private UserDetails loadUserDetails(HttpServletRequest request) {
		String user= authenticationHandler.getUser(request);
		//traer fecha de authenticationHandler 
	
		if (userDetailsService.isAnonymusUser(user)) { // ciudadano carga ignorar si es un ciudadano 
			String imei = authenticationHandler.getImei(request);
			DateTime  fechaToken = authenticationHandler.getTimestamp(request);
//			if (fechaToken != null && imei!=null){
//				loginHistorialService.updateFechaToken(user,imei, fechaToken.toDate());
//			}

			
			return userDetailsService.loadAnonymusUser(user, imei);
			
		} else {
			String username = authenticationHandler.getUserName(request);
			
			if(username != null){
				String imei = authenticationHandler.getImei(request); 
				DateTime  fechaToken = authenticationHandler.getTimestamp(request);
				if (fechaToken != null && imei!=null){
//					loginHistorialService.updateFechaToken(username,imei, fechaToken.toDate());
				
					DeviceDto deviceObject = gestionarDeviceBusiness.getDeviceByUsername(username);
					if(!imei.equals(deviceObject.getImei())){
						throw new SessionException("Sesion iniciada en otro dispositivo");				
					}
				}
			}
				
			return username != null ? userDetailsService
						.loadUserByUsername(username) : null;
			
		}
	}


	public void userDetailsService(GestionarUserDetailsBusiness userDetailsService) {
		this.userDetailsService = userDetailsService;
	}
	
	public void loginHistorialService(GestionarLoginHistorialBusiness loginHistorialService) {
		this.loginHistorialService = loginHistorialService;
	}
	public void gestionarDeviceBusiness(GestionarDeviceBusiness gestionarDeviceBusiness) {
		this.gestionarDeviceBusiness = gestionarDeviceBusiness;
	}

	public void authenticationHandler(HeaderAuthenticationHandler headerAuthenticationHandler) {
		this.authenticationHandler = headerAuthenticationHandler;
	}

}
