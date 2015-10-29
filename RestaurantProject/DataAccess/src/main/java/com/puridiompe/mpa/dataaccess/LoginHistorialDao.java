package com.puridiompe.mpa.dataaccess;

import com.puridiompe.mpa.business.general.dto.LoginHistorialDto;


public interface LoginHistorialDao {
	
	public Boolean setLoginHistorial(LoginHistorialDto lastLogin);
	public LoginHistorialDto getLastbyUsername(String username);
	public LoginHistorialDto getLastbyImei(String username,String imei);
}
