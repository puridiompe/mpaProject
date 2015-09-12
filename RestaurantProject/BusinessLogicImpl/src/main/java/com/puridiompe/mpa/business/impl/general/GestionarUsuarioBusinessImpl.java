package com.puridiompe.mpa.business.impl.general;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.puridiompe.mpa.business.general.GestionarUsuarioBusiness;

import com.puridiompe.mpa.business.security.dto.UsuarioDto;
//import com.puridiompe.mpa.business.general.dto.UsuarioDto;

import com.puridiompe.mpa.dataaccess.UsuarioDao;



@Service
public class GestionarUsuarioBusinessImpl implements  GestionarUsuarioBusiness{

	@Autowired
	private UsuarioDao usuarioDao;
	
	@Override
	public UsuarioDto getUsuario(String username) {
		return usuarioDao.getUsuarioByUsername(username);
	}
	
	@Override 
	public UsuarioDto validateUsuario(String idUsuario,String password){
		return  usuarioDao.validateUsuario(idUsuario, password);
	}
}
