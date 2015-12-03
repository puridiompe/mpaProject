/**
 * 
 */
package com.puridiompe.mpa.business.impl.security;


import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.puridiompe.mpa.business.security.GestionarUserRightsBusiness;
import com.puridiompe.mpa.business.security.dto.PerfilDto;
import com.puridiompe.mpa.business.security.dto.UsuarioDto;
import com.puridiompe.mpa.common.security.SystemModule;
import com.puridiompe.mpa.common.security.SystemRole;
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
		UsuarioDto usuario = (UsuarioDto) user;
		List<PerfilDto> perfiles =  usuario.getAuthorities();
		
		for (PerfilDto pefil :perfiles)
			switch(pefil.getRolSistema()){
			case CIUDADANO:
				switch (module){
				case PERMISOS:return true;
				case INFRACCIONES:return true;
				case NOTICIAS:return true;
				case CIUDADANO:return true;
				case RECLAMOS:return true;
				default: return false;
				}
			case INSPECTOR:
				switch (module){
				case PERMISOS:return true;
				case INFRACCIONES:return true;
				case PAPELETAS:return true;
				case GEO_LOCALIZACION:return true;
				case RECLAMOS:return true;
				default: return false;
				}
			case SUPERVISOR:
				switch (module){
				case PERMISOS:return true;
				case INFRACCIONES:return true;
				case PAPELETAS:return true;
				case GEO_LOCALIZACION:return true;
				case CIUDADANO:return true;
				case NOTICIAS:return true;
				case RECLAMOS:return true;
				default: return false;
				}
			case ADMINISTRADOR:
				switch (module){
				case ADMINISTRACION:return true;
				}
				break;
			default:
				return false;
			}

		return false;
	}

	@Override
	public boolean hasPermissionRight(UserDetails user, SystemModule module,
			String permission) {
		// TODO Auto-generated method stub
		return true;
	}

}
