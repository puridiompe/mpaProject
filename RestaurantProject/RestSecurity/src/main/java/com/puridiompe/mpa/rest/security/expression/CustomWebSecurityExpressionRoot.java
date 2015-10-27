/**
 * 
 */
package com.puridiompe.mpa.rest.security.expression;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.expression.WebSecurityExpressionRoot;

import com.puridiompe.mpa.business.security.GestionarUserRightsBusiness;
import com.puridiompe.mpa.common.security.SystemModule;

/**
 * @author Johnny
 *
 */
public class CustomWebSecurityExpressionRoot extends WebSecurityExpressionRoot {

	private GestionarUserRightsBusiness gestionarUserRightsBusiness;

	public CustomWebSecurityExpressionRoot(Authentication a,
			FilterInvocation fi,
			GestionarUserRightsBusiness gestionarUserRightsBusiness) {
		super(a, fi);
		this.gestionarUserRightsBusiness = gestionarUserRightsBusiness;
	}

	public boolean hasAccessVehiculo() {
		return hasAccess(SystemModule.PERMISOS);
	}

	public boolean hasAccessInfraccion() {
		return hasAccess(SystemModule.INFRACCIONES);
	}

	public boolean hasAccessNoticia() {
		return hasAccess(SystemModule.NOTICIAS);
	}

	public boolean hasAccessCiudadano() {
		return hasAccess(SystemModule.CIUDADANO);
	}

	public boolean hasAccessReclamo() {
		return hasAccess(SystemModule.RECLAMOS);
	}
	public boolean hasAccessGps() {
		return hasAccess(SystemModule.GEO_LOCALIZACION);
	}

	private boolean hasAccess(SystemModule modulo) {
		boolean hasAccess = false;
//		this.authentication = SecurityContextHolder.getContext()
//				.getAuthentication();
		
		if (!isAnonymous()) {
			
			if (this.authentication.getPrincipal() != null && this.authentication.getAuthorities() != null) {
				
				UserDetails usuario = (UserDetails) ((authentication == null) ? null
						: authentication.getPrincipal());
				
				hasAccess = gestionarUserRightsBusiness.hasModuleRight(usuario, modulo);
			}
		}
		
		return hasAccess;

	}
}
