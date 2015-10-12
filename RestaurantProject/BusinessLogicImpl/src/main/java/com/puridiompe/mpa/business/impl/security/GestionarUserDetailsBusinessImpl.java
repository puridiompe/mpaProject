/**
 * 
 */
package com.puridiompe.mpa.business.impl.security;

import java.util.Random;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.puridiompe.mpa.business.security.GestionarUserDetailsBusiness;
import com.puridiompe.mpa.business.security.dto.PerfilDto;
import com.puridiompe.mpa.business.security.dto.UsuarioDto;
import com.puridiompe.mpa.common.annotation.InjectLogger;
import com.puridiompe.mpa.common.security.SystemRole;
import com.puridiompe.mpa.dataaccess.UsuarioDao;

/**
 * @author Johnny
 *
 */
@Service
public class GestionarUserDetailsBusinessImpl implements
		GestionarUserDetailsBusiness {

	@InjectLogger
	private Logger logger;

	@Autowired
	private UsuarioDao usuarioDao;
	
	@Override
	public UserDetails createAnonymusUser() {
		UsuarioDto userObject =  new UsuarioDto();
		userObject.setUsername(getAnonymusUsername());
		
		PerfilDto perfil = usuarioDao.getPerfilByRol(SystemRole.CIUDADANO);
		
		userObject.getAuthorities().add(perfil);
		
		logger.info("Anonymus user {} was created", userObject.getUsername());
		
		return userObject;
	}
	
	@Override
	public UserDetails loadAnonymusUser(String username) {
		UsuarioDto userObject =  new UsuarioDto();
		userObject.setUsername(username);
		
		PerfilDto perfil = usuarioDao.getPerfilByRol(SystemRole.CIUDADANO);
		
		userObject.getAuthorities().add(perfil);
		
		return userObject;
	}

	@Override
	public boolean isAnonymusUser(String username) {
		return username != null && username.startsWith("anyusr_");
	}
	
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		UsuarioDto userObject =  usuarioDao.getUsuarioByUsername(username);
		
		return userObject;
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

	@Override
	public boolean setLastLogin(String username) {
		return usuarioDao.setLastLogin(username);
	}

	@Override
	public boolean setCurrentDevice(UserDetails user,String imei) {
		UsuarioDto userObject = (UsuarioDto) user;
		
		userObject.setImei(imei);
		
		return usuarioDao.setCurrentDevice(userObject.getUsername(), imei);
	}
	
	/**
	 * Generates anonymus name for user
	 * 
	 * @return
	 */
	private String getAnonymusUsername() {
		int start = 1000000;
		int end = 10000000;

		Random random = new Random();

		// get the range, casting to long to avoid overflow problems
		long range = (long) end - (long) start + 1;
		// compute a fraction of the range, 0 <= frac < range
		long fraction = (long) (range * random.nextDouble());
		int randomNumber = (int) (fraction + start);

		return "anyusr_" + randomNumber;
	}

	

	

}
