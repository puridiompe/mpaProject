package com.puridiompe.mpa.dataaccess.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.puridiompe.mpa.business.general.dto.UsuarioDto;
import com.puridiompe.mpa.dataaccess.UsuarioDao;
import com.puridiompe.mpa.sistran.domain.persistence.RolUsuario;
import com.puridiompe.mpa.sistran.domain.persistence.Usuario;
import com.puridiompe.mpa.sistran.repository.persistence.RolUsuarioRepository;
import com.puridiompe.mpa.sistran.repository.persistence.UsuarioRepository;

@Component
public class UsuarioDaoImpl implements UsuarioDao {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private RolUsuarioRepository rolUsuarioRepository;
	
	@Transactional(value = "sistranTransactionManager", readOnly = true)
	@Override
	public UsuarioDto getUsuarioById(String idUsuario) {

		UsuarioDto usuarioObject = new UsuarioDto();
		Usuario usuario = usuarioRepository.findByIdUsuario(idUsuario);

		if (usuario != null) {
			BeanUtils.copyProperties(usuario, usuarioObject);
			RolUsuario rol= rolUsuarioRepository.findByIdUsuario(usuario.getIdUsuario());
			if(rol!=null){
				System.out.println(rol.getIdRol());
				usuarioObject.setRol(rol.getIdRol());
			}//else 
				// does't have a role
		} else {
			return null;
		}

		return usuarioObject;
	}

	@Transactional(value = "sistranTransactionManager", readOnly = true)
	@Override
	public UsuarioDto validateUsuario(String idUsuario,String password) {
		
		UsuarioDto usuarioObject = new UsuarioDto();
		Usuario usuario = usuarioRepository.validateUsuario(idUsuario, password);
		System.out.print("usuario"+idUsuario +" contraseña"+password);
		//Usuario usuario = usuarioRepository.findByIdUsuario(idUsuario);
		
		if (usuario != null) {
			BeanUtils.copyProperties(usuario, usuarioObject);
			RolUsuario rol= rolUsuarioRepository.findByIdUsuario(usuario.getIdUsuario());
			if(rol!=null){
				System.out.println(rol.getIdRol());
				usuarioObject.setRol(rol.getIdRol());
			}//else 
				// does't have a role
		} else {
			return null;
		}
		return usuarioObject;
	}

}
