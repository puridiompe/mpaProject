/**
 * 
 */
package com.puridiompe.mpa.business.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;

import com.puridiompe.mpa.business.security.evaluator.CustomPermissionEvaluator;
import com.puridiompe.mpa.business.security.handler.CustomMethodSecurityExpressionHandler;

/**
 * @author Johnny
 *
 */
@Configuration
@ComponentScan("com.puridiompe.mpa.business.security.evaluator")
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class SecurityMethodConfiguration extends
		GlobalMethodSecurityConfiguration {

	@Autowired
	private CustomPermissionEvaluator permissionEvaluator;

	@Override
	protected MethodSecurityExpressionHandler createExpressionHandler() {
		CustomMethodSecurityExpressionHandler methodSecurityExpressionHandler = new CustomMethodSecurityExpressionHandler();
		methodSecurityExpressionHandler
				.setPermissionEvaluator(permissionEvaluator);

		return methodSecurityExpressionHandler;
	}
}
