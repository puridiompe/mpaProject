package com.puridiompe.mpa.business.general;

import java.security.GeneralSecurityException;
import java.util.Date;

import com.puridiompe.mpa.business.general.dto.LoginHistorialDto;

public interface GestionarLoginHistorialBusiness {
	
	public void setLoginHistorial(String username,String imei);
	
	public void updateFechaToken(String username,String imei,Date fechaToken) throws GeneralSecurityException;
	
	//public void verifyFechaToken(Date fechaToken);
	
	//public LoginHistorialDto getLastLoginbyUsername(String username);
	
	//public LoginHistorialDto getLastLoginbyImei(String imei);

}
