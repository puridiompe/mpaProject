package com.puridiompe.mpa.business.general;

import java.util.Date;

import com.puridiompe.mpa.common.security.exception.InvalidTokenException;

public interface GestionarLoginHistorialBusiness {

	public void setLoginHistorial(String username, String imei);

	public void updateFechaToken(String username, String imei, Date fechaToken) throws InvalidTokenException;

	// public void verifyFechaToken(Date fechaToken);

	// public LoginHistorialDto getLastLoginbyUsername(String username);

	// public LoginHistorialDto getLastLoginbyImei(String imei);

}
