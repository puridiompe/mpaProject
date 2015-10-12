/**
 * 
 */
package com.puridiompe.mpa.business.impl.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.puridiompe.mpa.business.security.GestionarUserRightsBusiness;
import com.puridiompe.mpa.common.security.SystemModule;

/**
 * @author Johnny
 *
 */
@Service
public class GestionarUserRightsBusinessImpl implements
		GestionarUserRightsBusiness {

	@Override
	public boolean hasModuleRight(UserDetails user, SystemModule module) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean hasPermissionRight(UserDetails user, SystemModule module,
			String permission) {
		// TODO Auto-generated method stub
		return true;
	}

}
