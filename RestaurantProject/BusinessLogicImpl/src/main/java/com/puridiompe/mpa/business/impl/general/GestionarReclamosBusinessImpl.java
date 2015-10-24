package com.puridiompe.mpa.business.impl.general;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.puridiompe.mpa.business.general.GestionarReclamosBusiness;
import com.puridiompe.mpa.business.general.dto.ReclamosDto;
import com.puridiompe.mpa.common.security.SecurityContextHelper;
import com.puridiompe.mpa.common.security.exception.SecurityException;
import com.puridiompe.mpa.dataaccess.ReclamosDao;

@Service
public class GestionarReclamosBusinessImpl implements GestionarReclamosBusiness {

	@Autowired
	ReclamosDao reclamosDao;
	
	@Override
	public ReclamosDto getReclamos(String imei) {
		
//		String currentImei = SecurityContextHelper.getCurrentImei();
		
		ReclamosDto reclamosDto = reclamosDao.getReclamosByImei(imei); 
		
		return reclamosDto;
	}

}
