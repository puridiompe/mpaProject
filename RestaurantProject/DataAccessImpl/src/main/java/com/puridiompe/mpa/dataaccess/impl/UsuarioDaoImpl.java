package com.puridiompe.mpa.dataaccess.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.puridiompe.mpa.business.general.dto.LoginHistorialDto;
import com.puridiompe.mpa.business.security.dto.PerfilDto;
//import com.puridiompe.mpa.business.general.dto.RolDto;
//import com.puridiompe.mpa.business.general.dto.UsuarioDto;
import com.puridiompe.mpa.business.security.dto.UsuarioDto;
import com.puridiompe.mpa.dataaccess.UsuarioDao;
import com.puridiompe.mpa.sistran.domain.persistence.Device;
import com.puridiompe.mpa.sistran.domain.persistence.LoginHistorial;
import com.puridiompe.mpa.sistran.domain.persistence.Rol;
import com.puridiompe.mpa.sistran.domain.persistence.RolUsuario;
import com.puridiompe.mpa.sistran.domain.persistence.Usuario;
import com.puridiompe.mpa.sistran.repository.persistence.DeviceRepository;
import com.puridiompe.mpa.sistran.repository.persistence.LoginHistorialRepository;
import com.puridiompe.mpa.sistran.repository.persistence.RolRepository;
import com.puridiompe.mpa.sistran.repository.persistence.RolUsuarioRepository;
import com.puridiompe.mpa.sistran.repository.persistence.UsuarioRepository;


@Component
public class UsuarioDaoImpl implements UsuarioDao {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private RolUsuarioRepository rolUsuarioRepository;
	
	@Autowired
	private RolRepository rolRepository;
	
	@Autowired
	private DeviceRepository deviceRepository;
	
	@Autowired
	 private LoginHistorialRepository loginHistorialRepository;
	
	@Transactional(value = "sistranTransactionManager", readOnly = true)
	@Override
	public UsuarioDto getUsuarioByUsername(String username) {

		UsuarioDto usuarioObject = new UsuarioDto();
		Usuario usuario = usuarioRepository.findByUsername(username);
		List<RolUsuario> rolUsu = new ArrayList<>(); 
		List<LoginHistorial> loginHistorial = new ArrayList<>();
		
		if (usuario != null) {
			BeanUtils.copyProperties(usuario, usuarioObject);
			rolUsu = rolUsuarioRepository.findByIdUsuario(usuario.getIdUsuario());
			loginHistorial = loginHistorialRepository.findByIdUsuario(usuario.getIdUsuario());
			
			if(loginHistorial.size()>0){
				usuarioObject.setLastLogin(loginHistorial.get(loginHistorial.size()-1).getFechaHora());
			}
			if(!rolUsu.isEmpty()){
		
				for(RolUsuario r : rolUsu){
					Rol rol = rolRepository.findByIdRol(r.getIdRol());
					PerfilDto rolObject;
					try {
						rolObject = new PerfilDto(rol.getRol(),rol.getFecMod());
						rolObject.setIdRol(rol.getIdRol());
						usuarioObject.getAuthorities().add(rolObject);
						
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
		List<LoginHistorial> loginHistorial = new ArrayList<>();
		
		if (usuario != null) {
			BeanUtils.copyProperties(usuario, usuarioObject);
			rolUsu= rolUsuarioRepository.findByIdUsuario(usuario.getIdUsuario());
			if(loginHistorial!=null){
				usuarioObject.setLastLogin(loginHistorial.get(loginHistorial.size()-1).getFechaHora());
			}
			if(!rolUsu.isEmpty()){
				
				for(RolUsuario r : rolUsu){
					Rol rol = rolRepository.findByIdRol(r.getIdRol());
					PerfilDto rolObject;
					try {
						rolObject = new PerfilDto();
						BeanUtils.copyProperties(rol, rolObject);
						usuarioObject.getAuthorities().add(rolObject);
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

	@Transactional(value = "sistranTransactionManager")
	@Override
	public Boolean setCurrentDevice(String username,String imei) {
		
		UsuarioDto usuarioObject = new UsuarioDto();
		Usuario usuario = usuarioRepository.findByUsername(username);
		
		// Verificar y Borrar 
		if (usuario != null) {
			BeanUtils.copyProperties(usuario, usuarioObject);
			List<Device> devices = new ArrayList<>();
			devices = deviceRepository.findByUserId(usuarioObject.getIdUsuario());
			
				for (Device d : devices){
					d.setUsarioId(null);
					deviceRepository.save(d);
				}
				
			Device newDevice = deviceRepository.findByImei(imei);
			if(newDevice!=null){
				newDevice.setUsarioId(usuarioObject.getIdUsuario());
				deviceRepository.save(newDevice);
			}else {
				newDevice = new Device();
				newDevice.setImei(imei);
				newDevice.setActive("N");
				newDevice.setUsarioId(usuarioObject.getIdUsuario());
				deviceRepository.save(newDevice);
			}
			
			return true;
			
		}else 
			return false;
	}
	
	@Transactional(value = "sistranTransactionManager")
	@Override
	public Boolean setLastLogin(String username) {
		
		Usuario usuario = usuarioRepository.findByUsername(username);
		if (usuario != null) {
			
			LoginHistorial loginHistorial = new LoginHistorial() ;
			loginHistorial.setIdUsuario(usuario.getIdUsuario());
			loginHistorial.setEstado(true);
			loginHistorial.setFechaHora(new Date());
			loginHistorialRepository.save(loginHistorial);
			return true;
		}
		else 
			return false;
	}

}



