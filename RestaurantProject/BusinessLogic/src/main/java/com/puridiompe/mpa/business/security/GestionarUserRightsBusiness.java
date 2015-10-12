/**
 * 
 */
package com.puridiompe.mpa.business.security;

import org.springframework.security.core.userdetails.UserDetails;

import com.puridiompe.mpa.common.security.SystemModule;

/**
 * @author
 *
 */
public interface GestionarUserRightsBusiness {

	public boolean hasPermissionRight(UserDetails user, SystemModule module,
			String permission);

	public boolean hasModuleRight(UserDetails user, SystemModule module);
}
