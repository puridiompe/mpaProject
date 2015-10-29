package com.puridiompe.mpa.dataaccess.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.puridiompe.mpa.business.general.dto.LoginHistorialDto;
import com.puridiompe.mpa.common.type.Datetime;
import com.puridiompe.mpa.dataaccess.LoginHistorialDao;
import com.puridiompe.mpa.movil.domain.persistence.LoginHistorial;
import com.puridiompe.mpa.movil.repository.persistence.LoginHistorialRepository;


@Component
public class LoginHistorialDaoImpl implements  LoginHistorialDao{
	
	
	@Autowired
	private LoginHistorialRepository loginHistorialRepository;
	
	@Transactional(value = "movilTransactionManager")
	@Override
	public Boolean setLoginHistorial(LoginHistorialDto lastLoginObject) {
		
		LoginHistorial lastLogin = new LoginHistorial() ;
		if (lastLoginObject != null){
			BeanUtils.copyProperties(lastLoginObject, lastLogin);
			loginHistorialRepository.save(lastLogin);
			return true;
		}
		else 
			return false;
			
	}

	@Transactional(value = "movilTransactionManager", readOnly = true)
	@Override
	public LoginHistorialDto getLastbyUsername(String username) {
		
		LoginHistorialDto lastloginObject = new LoginHistorialDto();
		List<LoginHistorial> loginHistorial = loginHistorialRepository.findByIdUsuario(username);
		
		if(loginHistorial.size()>0){
			LoginHistorial lastLogin = loginHistorial.get(loginHistorial.size()-1);
			BeanUtils.copyProperties(lastLogin, lastloginObject);
			return lastloginObject;
		}else{
			return null;
		}
	}
	
	
	@Transactional(value = "movilTransactionManager", readOnly = true)
	@Override
	public LoginHistorialDto getLastbyImei(String username,String imei) {
		
		LoginHistorialDto lastloginObject = new LoginHistorialDto();
		List<LoginHistorial> loginHistorial = loginHistorialRepository.findByIdImei(username,imei);
		
		if(loginHistorial.size()>0){
			LoginHistorial lastLogin = loginHistorial.get(0);
			BeanUtils.copyProperties(lastLogin, lastloginObject);
			return lastloginObject;
		}else{
			return null;
		}
	
	}
}
