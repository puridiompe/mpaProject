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
	public void setReclamo(Integer dni, String descripcion, String vehiculo, List<String> imagenesBase64, String estado) throws SecurityException {
		
		String currentImei = SecurityContextHelper.getCurrentImei(); 
		
		reclamoDao.saveReclamo(dni, descripcion, vehiculo, imagenesBase64, currentImei, estado);
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
