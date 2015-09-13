/**
 * 
 */
package com.puridiompe.mpa.business.impl.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.puridiompe.mpa.business.security.GestionarUserDetailsBusiness;
import com.puridiompe.mpa.business.security.dto.UsuarioDto;
import com.puridiompe.mpa.dataaccess.UsuarioDao;

/**
 * @author Johnny
 *
 */
@Service
public class GestionarUserDetailsBusinessImpl implements
		GestionarUserDetailsBusiness {

	@Autowired
	private UsuarioDao usuarioDao;
	
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		return usuarioDao.getUsuarioByUsername(username);
	}

	@Override
	public UsuarioDto getUsuario(String username) {
		return usuarioDao.getUsuarioByUsername(username);
	}

	@Override
	public UsuarioDto validateUsuario(String username, String password) {
		// TODO Auto-generated method stub
		return usuarioDao.getUsuarioByUsername(username);
	}
	

}
