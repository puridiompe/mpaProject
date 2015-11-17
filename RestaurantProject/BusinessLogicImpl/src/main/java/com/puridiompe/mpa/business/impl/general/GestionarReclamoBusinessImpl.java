package com.puridiompe.mpa.business.impl.general;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.puridiompe.mpa.business.general.GestionarHistorialReclamoBusiness;
import com.puridiompe.mpa.business.general.GestionarReclamoBusiness;
import com.puridiompe.mpa.business.general.dto.ReclamoDto;
import com.puridiompe.mpa.business.general.dto.ResumenImagenDto;
import com.puridiompe.mpa.common.security.SecurityContextHelper;
import com.puridiompe.mpa.common.security.exception.SecurityException;
import com.puridiompe.mpa.dataaccess.ReclamoDao;

@Service
public class GestionarReclamoBusinessImpl implements GestionarReclamoBusiness {

	@Autowired
	private ReclamoDao reclamoDao;
	
	@Autowired
	private GestionarHistorialReclamoBusiness gestionarHistorialReclamo;
	
	@Override
	public ReclamoDto setReclamo(ReclamoDto request) throws SecurityException {		
		
		Integer idReclamo =  reclamoDao.saveReclamo(request);
		
		ResumenImagenDto resumen = new ResumenImagenDto();
		
		gestionarHistorialReclamo.setHistorialReclamo(request, idReclamo);
		
		return reclamoDao.getById(idReclamo);
		
	}
	
	@Override
	public ReclamoDto setReclamoComentario(ReclamoDto request) throws SecurityException{
		
		gestionarHistorialReclamo.setHistorialComentario(request);
		
		return reclamoDao.saveReclamoComentario(request);
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
	public List<ReclamoDto> getAllReclamos(){
		return reclamoDao.getAllReclamos();
	}
	
	@Override
	public List<ReclamoDto> getReclamosByImei(String imei) {
		
//		String currentImei = SecurityContextHelper.getCurrentImei();
		
		List<ReclamoDto> reclamosDto = reclamoDao.getReclamosByImei(imei); 
		
		return reclamosDto;
	}
	
	@Override
	public ReclamoDto getImagesByNumRec(String numRec) {
		
		ReclamoDto reclamoTmp = reclamoDao.getImagesByNumRec(numRec);
		return reclamoTmp;
	}
	
	@Override
	public Integer getCountReclamoByImei() throws SecurityException{
		
		String currentImei = SecurityContextHelper.getCurrentImei();
		return reclamoDao.countReclamosByImei(currentImei);
	}

}
