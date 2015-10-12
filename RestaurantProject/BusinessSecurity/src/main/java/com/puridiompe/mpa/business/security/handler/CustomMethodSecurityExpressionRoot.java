/**
 * 
 */
package com.puridiompe.mpa.business.security.handler;

import java.lang.reflect.Method;

import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.access.expression.SecurityExpressionRoot;
import org.springframework.security.access.expression.method.MethodSecurityExpressionOperations;
import org.springframework.security.core.Authentication;

import com.puridiompe.mpa.business.security.evaluator.CustomPermissionEvaluator;

/**
 * @author Johnny
 *
 */
class CustomMethodSecurityExpressionRoot extends SecurityExpressionRoot
		implements MethodSecurityExpressionOperations {

	private Object filterObject;

	private Object returnObject;

	private Object target;

	private Method method;

	private CustomPermissionEvaluator customPermissionEvaluator;

	CustomMethodSecurityExpressionRoot(Authentication authentication) {
		super(authentication);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setFilterObject(Object filterObject) {
		this.filterObject = filterObject;
	}

	@Override
	public Object getFilterObject() {
		return filterObject;
	}

	@Override
	public void setReturnObject(Object returnObject) {
		this.returnObject = returnObject;
	}

	@Override
	public Object getReturnObject() {
		return returnObject;
	}

	public void setThis(Object target) {
		this.target = target;
	}

	@Override
	public Object getThis() {
		return target;
	}

	// allow the method to be set
	public void setMethod(Method m) {
		this.method = m;
	}

	// optionally expose the method to be accessed in expressions
	public Method getMethod() {
		return method;
	}

	@Override
	public void setPermissionEvaluator(PermissionEvaluator permissionEvaluator) {
		super.setPermissionEvaluator(permissionEvaluator);

		this.customPermissionEvaluator = (CustomPermissionEvaluator) permissionEvaluator;
	}

	// create a method that will perform the check with
	// the method name transparently for you
	public boolean hasAccessPermission(Object target) {
		boolean result = false;

		CustomMethodSecurityExpressionRoot methodSecurityObject = (CustomMethodSecurityExpressionRoot) target;

		String permission = methodSecurityObject.getMethod().getName();

		result = this.customPermissionEvaluator.hasPermission(authentication,
				methodSecurityObject.getThis(), permission);

		return result;
	}

}
