package com.puridiompe.mpa.business.impl.general;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.puridiompe.mpa.business.general.GestionarReclamoBusiness;
import com.puridiompe.mpa.business.general.dto.ReclamoDto;
import com.puridiompe.mpa.common.security.SecurityContextHelper;
import com.puridiompe.mpa.common.security.exception.SecurityException;
import com.puridiompe.mpa.dataaccess.ReclamoDao;

@Service
public class GestionarReclamoBusinessImpl implements GestionarReclamoBusiness {

	@Autowired
	private ReclamoDao reclamoDao;
	
	@Override
	public ReclamoDto setReclamo(ReclamoDto request) throws SecurityException {		
		
		Integer idReclamo =  reclamoDao.saveReclamo(request);
		
		return reclamoDao.getById(idReclamo);	
		
	}

	@Override
	public List<ReclamoDto> getReclamosFrecuentes() {
		return reclamoDao.getReclamosFrecuentes();
	}
	
	@Override
	public Integer getLastDniByImei(String imei){
		return reclamoDao.getLastDniByImei(imei);
	}
	
	@Override
	public List<ReclamoDto> getAll(){
		return reclamoDao.getAll();
	}

}
