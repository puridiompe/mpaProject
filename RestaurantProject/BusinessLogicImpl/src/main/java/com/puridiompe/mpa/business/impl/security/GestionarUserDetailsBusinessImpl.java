/**
 * 
 */
package com.puridiompe.mpa.business.impl.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.puridiompe.mpa.business.security.GestionarUserDetailsBusiness;

/**
 * @author Johnny
 *
 */
@Service
public class GestionarUserDetailsBusinessImpl implements
		GestionarUserDetailsBusiness {

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
