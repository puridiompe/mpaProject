/**
 * 
 */
package com.puridiompe.mpa.business.security.handler;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.access.expression.method.MethodSecurityExpressionOperations;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.authentication.AuthenticationTrustResolverImpl;
import org.springframework.security.core.Authentication;

/**
 * @author Johnny
 *
 */
public class CustomMethodSecurityExpressionHandler extends
		DefaultMethodSecurityExpressionHandler {

	private AuthenticationTrustResolver trustResolver = new AuthenticationTrustResolverImpl();

	private String defaultRolePrefix = "ROLE_";

	@Override
	protected MethodSecurityExpressionOperations createSecurityExpressionRoot(
			Authentication authentication, MethodInvocation invocation) {

		CustomMethodSecurityExpressionRoot root = new CustomMethodSecurityExpressionRoot(
				authentication);
		root.setThis(invocation.getThis());
		root.setPermissionEvaluator(getPermissionEvaluator());
		root.setTrustResolver(this.trustResolver);
		root.setRoleHierarchy(getRoleHierarchy());
		root.setDefaultRolePrefix(this.defaultRolePrefix);

		root.setMethod(invocation.getMethod());

		return root;
	}
}
