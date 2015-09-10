/**
 * 
 */
package com.puridiompe.mpa.rest.security.expression;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.expression.AbstractSecurityExpressionHandler;
import org.springframework.security.access.expression.SecurityExpressionOperations;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.authentication.AuthenticationTrustResolverImpl;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.expression.WebSecurityExpressionRoot;
import org.springframework.stereotype.Component;

import com.puridiompe.mpa.business.security.GestionarUserRightsBusiness;

/**
 * @author Johnny
 *
 */
@Component
public class CustomWebSecurityExpressionHandler extends
		AbstractSecurityExpressionHandler<FilterInvocation> {

	@Autowired
	private GestionarUserRightsBusiness gestionarUserRightsBusiness;

	private AuthenticationTrustResolver trustResolver = new AuthenticationTrustResolverImpl();

	@Override
	protected SecurityExpressionOperations createSecurityExpressionRoot(
			Authentication authentication, FilterInvocation fi) {

		WebSecurityExpressionRoot expressionRoot = new CustomWebSecurityExpressionRoot(
				authentication, fi, gestionarUserRightsBusiness);

		expressionRoot.setPermissionEvaluator(getPermissionEvaluator());
		expressionRoot.setTrustResolver(this.trustResolver);
		expressionRoot.setRoleHierarchy(getRoleHierarchy());

		return expressionRoot;
	}
}
