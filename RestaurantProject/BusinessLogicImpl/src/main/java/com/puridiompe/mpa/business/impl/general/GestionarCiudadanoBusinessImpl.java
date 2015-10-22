package com.puridiompe.mpa.business.impl.general;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.puridiompe.mpa.business.exception.BusinessException;
import com.puridiompe.mpa.business.general.GestionarCiudadanoBusiness;
import com.puridiompe.mpa.business.general.dto.CiudadanoDto;
import com.puridiompe.mpa.common.security.SecurityContextHelper;
import com.puridiompe.mpa.common.security.exception.SecurityException;
import com.puridiompe.mpa.dataaccess.CiudadanoDao;

@Service
public class GestionarCiudadanoBusinessImpl implements GestionarCiudadanoBusiness{

	@Autowired
	CiudadanoDao ciudadanoDao;
	
	@Override
	public CiudadanoDto getCiudadano(Integer dni){
		
		CiudadanoDto ciudadanoDto = ciudadanoDao.getCiudadano(dni);
		
		return ciudadanoDto;
	}
	
	@Override
	public void setCiudadano(Integer dni, String apellidoPaterno, String apellidoMaterno, String nombres,
			String email) throws BusinessException, SecurityException {

			String currentImei = SecurityContextHelper.getCurrentImei();

			ciudadanoDao.setCiudadano(dni, apellidoPaterno, apellidoMaterno, nombres, email);
	}
	
	@Override
	public void setCiudadanoBatch(List<CiudadanoDto> ciudadanos){
		
		int arraySize = ciudadanos.size();
//		boolean isLast = false;
		
		for(int i = 0; i < arraySize; i++){
//			String currentImei = null;
//			try {
//				currentImei = SecurityContextHelper.getCurrentImei();
//			} catch (SecurityException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			if(i == arraySize-1){
//				isLast = true;
//				ciudadanoDao.setCiudadano(ciudadanos.get(i).getDni(), ciudadanos.get(i).getApellidoPaterno(), ciudadanos.get(i).getApellidoMaterno(), ciudadanos.get(i).getNombres(), ciudadanos.get(i).getEmail(), currentImei, ciudadanos.get(i).getOfflineTime(), isLast);
//			}else{				
//				ciudadanoDao.setCiudadano(ciudadanos.get(i).getDni(), ciudadanos.get(i).getApellidoPaterno(), ciudadanos.get(i).getApellidoMaterno(), ciudadanos.get(i).getNombres(), ciudadanos.get(i).getEmail(), currentImei, ciudadanos.get(i).getOfflineTime(), isLast);
//			}
			ciudadanoDao.setCiudadano(ciudadanos.get(i).getDni(), ciudadanos.get(i).getApellidoPaterno(), ciudadanos.get(i).getApellidoMaterno(), ciudadanos.get(i).getNombres(), ciudadanos.get(i).getEmail());
		}
		
	}

}
