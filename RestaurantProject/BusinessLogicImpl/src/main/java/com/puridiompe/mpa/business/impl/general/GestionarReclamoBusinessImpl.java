package com.puridiompe.mpa.business.impl.general;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.puridiompe.mpa.business.general.GestionarReclamoBusiness;
import com.puridiompe.mpa.business.general.dto.HistorialReclamoDto;
import com.puridiompe.mpa.business.general.dto.ReclamoDto;
import com.puridiompe.mpa.business.general.dto.ReclamosDto;
import com.puridiompe.mpa.business.general.dto.ResumenImagenDto;
import com.puridiompe.mpa.common.security.SecurityContextHelper;
import com.puridiompe.mpa.common.security.SystemRole;
import com.puridiompe.mpa.common.security.exception.SecurityException;
import com.puridiompe.mpa.common.type.HistorialReclamoAccion;
import com.puridiompe.mpa.common.util.DateUtil;
import com.puridiompe.mpa.dataaccess.HistorialReclamoDao;
import com.puridiompe.mpa.dataaccess.ReclamoDao;

@Service
public class GestionarReclamoBusinessImpl implements GestionarReclamoBusiness {

	@Autowired
	private ReclamoDao reclamoDao;
	
	@Autowired
	private HistorialReclamoDao historialReclamoDao;
	
	@Override
	public ReclamoDto setReclamo(ReclamoDto request) throws SecurityException {		
		
		Integer idReclamo =  reclamoDao.saveReclamo(request);
		
		ResumenImagenDto resumen = new ResumenImagenDto();
		
		HistorialReclamoDto historial = new HistorialReclamoDto();
		
		historial.setIdReclamo(idReclamo);
		historial.setImei(SecurityContextHelper.getCurrentImei());
		historial.setFecha(DateUtil.getCurrentDate());

		if(request.getEstado() == "P"){
			historial.setTipoUsuario(SystemRole.SUPERVISOR.toString());
			historial.setUsuario(SecurityContextHelper.getCurrentUsername());
			historial.setAccion(HistorialReclamoAccion.CAMBIO_ESTADO.toString());
			historial.setDescripcion("Se ha cambiado de estado a PROCESO");
		}
		if(request.getEstado() == "A"){	
			historial.setTipoUsuario(SystemRole.SUPERVISOR.toString());
			historial.setUsuario(SecurityContextHelper.getCurrentUsername());
			historial.setAccion(HistorialReclamoAccion.CAMBIO_ESTADO.toString());
			historial.setDescripcion("Se ha cambiado de estado a ARCHIVADO");
		}
		if(request.getEstado() == "R"){
			historial.setTipoUsuario(SystemRole.CIUDADANO.toString());
			historial.setUsuario(Integer.toString(request.getDni()));
			historial.setAccion(HistorialReclamoAccion.CREACION.toString());
			historial.setDescripcion("Se ha creado un nuevo reclamo con  ID " + idReclamo);
		}
	
		historialReclamoDao.setHistorialReclamo(historial);
		
		return reclamoDao.getById(idReclamo);
		
	}
	
	@Override
	public ReclamoDto setReclamoComentario(ReclamoDto request){
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
	public ReclamosDto getAll(){
		return reclamoDao.getAll();
	}
	
	@Override
	public ReclamosDto getReclamosByImei(String imei) {
		
//		String currentImei = SecurityContextHelper.getCurrentImei();
		
		ReclamosDto reclamosDto = reclamoDao.getReclamosByImei(imei); 
		
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
