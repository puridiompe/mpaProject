package com.puridiompe.mpa.business.impl.general;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.puridiompe.mpa.business.general.GestionarUsuarioBusiness;
import com.puridiompe.mpa.business.general.dto.UsuarioDto;
import com.puridiompe.mpa.dataaccess.UsuarioDao;


/**
 * @author Johnny
 *
 */
@Service
public class GestionarUsuarioBusinessImpl implements  GestionarUsuarioBusiness{

	@Autowired
	private UsuarioDao usuarioDao;
	
	@Override
	public UsuarioDto getUsuario(String idUsuario) {
		return usuarioDao.getUsuarioById(idUsuario);
	}
	
	@Override // could be  change to boolean 
	public UsuarioDto validateUsuario(String idUsuario,String password){
		return  usuarioDao.validateUsuario(idUsuario, password);
	}
	

}
