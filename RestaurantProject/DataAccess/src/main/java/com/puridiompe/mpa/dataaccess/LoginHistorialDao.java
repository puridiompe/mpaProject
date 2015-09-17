package com.puridiompe.mpa.dataaccess;

import com.puridiompe.mpa.business.general.dto.LoginHistorialDto;

public interface LoginHistorialDao {
	
	public void setLoginHistorial(LoginHistorialDto lastLogin);
}
