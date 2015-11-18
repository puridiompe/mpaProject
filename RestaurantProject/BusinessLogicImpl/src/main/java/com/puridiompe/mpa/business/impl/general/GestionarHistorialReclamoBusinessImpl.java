package com.puridiompe.mpa.business.impl.general;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.puridiompe.mpa.business.general.GestionarHistorialReclamoBusiness;
import com.puridiompe.mpa.business.general.dto.HistorialReclamoDto;
import com.puridiompe.mpa.business.general.dto.ReclamoDto;
import com.puridiompe.mpa.common.security.SecurityContextHelper;
import com.puridiompe.mpa.common.security.SystemRole;
import com.puridiompe.mpa.common.security.exception.SecurityException;
import com.puridiompe.mpa.common.type.HistorialReclamoAccion;
import com.puridiompe.mpa.common.util.DateUtil;
import com.puridiompe.mpa.dataaccess.HistorialReclamoDao;

@Service
public class GestionarHistorialReclamoBusinessImpl implements GestionarHistorialReclamoBusiness{


	@Autowired 
	private HistorialReclamoDao historialReclamoDao;
	
	@Override
	public void setHistorialReclamo(ReclamoDto reclamo, Integer idReclamo) throws SecurityException  {
		
		HistorialReclamoDto historial = new HistorialReclamoDto();
		
		historial.setIdReclamo(idReclamo);
		historial.setImei(SecurityContextHelper.getCurrentImei());
		historial.setFecha(DateUtil.getCurrentDate());

		if(reclamo.getEstadoReclamo() == "P"){
			historial.setTipoUsuario(SystemRole.SUPERVISOR.toString());
			historial.setUsuario(SecurityContextHelper.getCurrentUsername());
			historial.setAccion(HistorialReclamoAccion.CAMBIO_ESTADO.toString());
			historial.setDescripcion("Se ha cambiado de estado a PROCESO");
		}
		if(reclamo.getEstadoReclamo() == "A"){	
			historial.setTipoUsuario(SystemRole.SUPERVISOR.toString());
			historial.setUsuario(SecurityContextHelper.getCurrentUsername());
			historial.setAccion(HistorialReclamoAccion.CAMBIO_ESTADO.toString());
			historial.setDescripcion("Se ha cambiado de estado a ARCHIVADO");
		}
		if(reclamo.getEstadoReclamo() == "R"){
			historial.setTipoUsuario(SystemRole.CIUDADANO.toString());
			historial.setUsuario(Integer.toString(reclamo.getDni()));
			historial.setAccion(HistorialReclamoAccion.CREACION.toString());
			historial.setDescripcion("Se ha creado un nuevo reclamo con  ID " + idReclamo);
		}
	
		historialReclamoDao.setHistorialReclamo(historial);
	}

	@Override
	public void setHistorialComentario(ReclamoDto reclamo) throws SecurityException {
		
		if(reclamo.getIdReclamo() != null){
			
			HistorialReclamoDto historial = new HistorialReclamoDto();
			historial.setIdReclamo(reclamo.getIdReclamo());
			historial.setUsuario(SecurityContextHelper.getCurrentUsername());
			historial.setTipoUsuario(SystemRole.SUPERVISOR.toString());
			historial.setAccion(HistorialReclamoAccion.COMENTARIO.toString());
			historial.setDescripcion("Se ha agregago un nuevo comentario al reclamo ID "+reclamo.getIdReclamo());
			historial.setImei(SecurityContextHelper.getCurrentImei());
			historial.setFecha(DateUtil.getCurrentDate());
			historialReclamoDao.setHistorialReclamo(historial);
		}
	}
}
