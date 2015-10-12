/**
 * 
 */
package com.puridiompe.mpa.business.security.evaluator;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.puridiompe.mpa.business.security.GestionarUserRightsBusiness;
import com.puridiompe.mpa.common.security.SystemModule;

/**
 * @author Johnny
 *
 */
@Component
public class CustomPermissionEvaluator implements PermissionEvaluator {

	private static final Logger logger = LoggerFactory
			.getLogger(CustomPermissionEvaluator.class);

	private static final String SECURED_OBJECT_PACKAGE = "(com\\.puridiompe\\.)([a-z]+)(\\.business\\.)([a-z]+\\.)(.)+";

	private static final String SECURED_LAYER = ".business.impl.";

	@Autowired
	private GestionarUserRightsBusiness gestionarUserRightsBusiness;

	@Override
	public boolean hasPermission(Authentication authentication,
			Object targetDomainObject, Object permission) {
		logger.debug("Evaluating expression using hasPermission signature #1");

		logger.debug("Retrieving user's highest role");
		// String role = getRole(authentication);

		logger.debug("****************");
		// Logger.debug(this, "role: " + role);
		logger.debug("targetDomainObject: " + targetDomainObject);
		logger.debug("permission: " + permission);
		logger.debug("****************");

		boolean hasaccess = false;

		// Check the type of object
		logger.debug("User is trying to access the object: "
				+ targetDomainObject);

		if (targetDomainObject != null
				&& targetDomainObject.getClass().getName()
						.matches(SECURED_OBJECT_PACKAGE)) {

			String targetClassName = targetDomainObject.getClass().getName();
			int posLayer = targetClassName.indexOf(SECURED_LAYER);

			int posModule = targetClassName.substring(
					posLayer + SECURED_LAYER.length()).indexOf(".");

			String moduleName = targetClassName.substring(posLayer
					+ SECURED_LAYER.length(), posLayer + SECURED_LAYER.length()
					+ posModule);

			if (!StringUtils.isEmpty(moduleName)) {
				SystemModule modulo = SystemModule.getByName(moduleName);

//				if (modulo != null) {

					logger.debug("Check if user has permission");

					hasaccess = gestionarUserRightsBusiness.hasPermissionRight(
							(UserDetails) authentication.getPrincipal(),
							modulo, String.valueOf(permission));
//				}
			}

		}

		return hasaccess;
	}

	@Override
	public boolean hasPermission(Authentication authentication,
			Serializable targetId, String targetType, Object permission) {
		logger.debug("Evaluating expression using hasPermission signature #2");
		return false;
	}

}
