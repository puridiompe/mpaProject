package com.puridiompe.mpa.dataaccess;

import com.puridiompe.mpa.business.general.dto.UsuarioDto;


public interface UsuarioDao {

	public UsuarioDto getUsuarioById(String idUsuario);
	public UsuarioDto validateUsuario(String idUsuario,String password);
}