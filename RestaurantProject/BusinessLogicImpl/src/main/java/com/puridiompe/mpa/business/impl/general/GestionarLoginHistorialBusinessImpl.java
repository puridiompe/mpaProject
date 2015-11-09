package com.puridiompe.mpa.business.impl.general;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.puridiompe.mpa.business.general.GestionarLoginHistorialBusiness;
import com.puridiompe.mpa.business.general.dto.LoginHistorialDto;
import com.puridiompe.mpa.common.security.exception.InvalidTokenException;
import com.puridiompe.mpa.dataaccess.LoginHistorialDao;


@Service
public class GestionarLoginHistorialBusinessImpl implements GestionarLoginHistorialBusiness {

	@Autowired
	private LoginHistorialDao loginHistorialDao;
	
	@Override
	public void  setLoginHistorial(String username,String imei) {
		LoginHistorialDto lastLogin = new LoginHistorialDto();
		lastLogin.setUsername(username);
		lastLogin.setImei(imei);
		lastLogin.setFechaToken(new Date());
		lastLogin.setFechaHora(new Date());
		loginHistorialDao.setLoginHistorial(lastLogin);
		
	}

	@Override
	public void updateFechaToken(String username ,String imei,Date newFechaToken) throws InvalidTokenException {
		LoginHistorialDto lastLogin = loginHistorialDao.getLastbyImei(username,imei);
	
		if(lastLogin != null && imei != null && newFechaToken != null){
			Date curFechatoken = lastLogin.getFechaToken();
			Long diferencia = 0L;
			diferencia =  newFechaToken.getTime() - curFechatoken.getTime();
			diferencia = (diferencia)/ (60 * 1000);
			System.out.println("La diferencia"+diferencia);
			if(diferencia >= -1){
			//if(curFechatoken.getTime() < newFechaToken.getTime()){
				//System.out.println("Algo para comparar"+curFechatoken);
				System.out.println("Actual: "+curFechatoken.getTime());
				//System.out.println("Algo para comparar"+newFechaToken);
				System.out.println("Nueva: "+newFechaToken.getTime());
				Date toSave = new Date (newFechaToken.getTime());
				//System.out.println("Algo para guardar"+toSave);
				lastLogin.setFechaToken(newFechaToken);
				loginHistorialDao.setLoginHistorial(lastLogin);
			}else{
				throw new InvalidTokenException("La fecha del token enviada no es correcta");
						
			}
			
		}
		
	}

}
