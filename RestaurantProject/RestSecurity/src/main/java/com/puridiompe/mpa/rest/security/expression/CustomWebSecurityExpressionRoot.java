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

//	public boolean hasAccessAdministracion() {
//		return hasAccess(ModuloSistema.ADMINISTRACION);
//	}
//
//	public boolean hasAccessAlmacen() {
//		return hasAccess(ModuloSistema.ALMACEN);
//	}
//
//	public boolean hasAccessCocina() {
//		return hasAccess(ModuloSistema.COCINA);
//	}
//
//	public boolean hasAccessFacturacion() {
//		return hasAccess(ModuloSistema.FACTURACION);
//	}
//
//	public boolean hasAccessPedidos() {
//		return hasAccess(ModuloSistema.PEDIDOS);
//	}

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
