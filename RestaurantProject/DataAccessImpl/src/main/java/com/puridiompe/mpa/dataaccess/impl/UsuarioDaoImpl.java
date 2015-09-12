package com.puridiompe.mpa.dataaccess.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

//import com.puridiompe.mpa.business.general.dto.RolDto;
//import com.puridiompe.mpa.business.general.dto.UsuarioDto;
import com.puridiompe.mpa.business.security.dto.UsuarioDto;
import com.puridiompe.mpa.business.security.dto.PerfilDto;

import com.puridiompe.mpa.dataaccess.UsuarioDao;


import com.puridiompe.mpa.sistran.domain.persistence.Rol;
import com.puridiompe.mpa.sistran.domain.persistence.RolUsuario;
import com.puridiompe.mpa.sistran.domain.persistence.Usuario;
import com.puridiompe.mpa.sistran.repository.persistence.RolRepository;
import com.puridiompe.mpa.sistran.repository.persistence.RolUsuarioRepository;
import com.puridiompe.mpa.sistran.repository.persistence.UsuarioRepository;
import org.springframework.security.crypto.password.StandardPasswordEncoder;


@Component
public class UsuarioDaoImpl implements UsuarioDao {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private RolUsuarioRepository rolUsuarioRepository;
	
	@Autowired
	private RolRepository rolRepository;
	
	@Transactional(value = "sistranTransactionManager", readOnly = true)
	@Override
	public UsuarioDto getUsuarioByUsername(String username) {

		UsuarioDto usuarioObject = new UsuarioDto();
		Usuario usuario = usuarioRepository.findByUsername(username);
		List<RolUsuario> rolUsu = new ArrayList<>(); 
		
		if (usuario != null) {
			BeanUtils.copyProperties(usuario, usuarioObject);
			rolUsu = rolUsuarioRepository.findByIdUsuario(usuario.getIdUsuario());
			System.out.println("--"+usuario.getIdUsuario());
			System.out.println("--"+usuario.getUsername());
			System.out.println("--"+usuarioObject.getIdUsuario());
			System.out.println("--"+usuarioObject.getUsername());
	
			if(!rolUsu.isEmpty()){
		
				for(RolUsuario r : rolUsu){
					Rol rol = rolRepository.findByIdRol(r.getIdRol());
					PerfilDto rolObject;
					try {
						rolObject = new PerfilDto(rol.getRol(),rol.getFecMod());
						rolObject.setIdRol(rol.getIdRol());
						usuarioObject.getPerfiles().add(rolObject);
						
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		} else {
			return null;
		}
		return usuarioObject;
	}

	@Transactional(value = "sistranTransactionManager", readOnly = true)
	@Override
	public UsuarioDto validateUsuario(String username,String password) {
		
		UsuarioDto usuarioObject = new UsuarioDto();		
		Usuario usuario = usuarioRepository.validateUsuario(username, password);
		List<RolUsuario> rolUsu = new ArrayList<>(); 
		
		if (usuario != null) {
			BeanUtils.copyProperties(usuario, usuarioObject);
			rolUsu= rolUsuarioRepository.findByIdUsuario(usuario.getIdUsuario());
			System.out.println("--"+usuario.getIdUsuario());
	
			if(!rolUsu.isEmpty()){
				
				for(RolUsuario r : rolUsu){
					Rol rol = rolRepository.findByIdRol(r.getIdRol());
					PerfilDto rolObject;
					try {
						//rolObject = new PerfilDto("",null);
						rolObject = new PerfilDto();
						BeanUtils.copyProperties(rol, rolObject);
						usuarioObject.getPerfiles().add(rolObject);
						
						
						
					} catch (Exception e) {
						e.printStackTrace();
					}
					//usuarioObject.getRoles().add(rolObject);
				}
			}
		} else {
			return null;
		}
		return usuarioObject;
	}

}



