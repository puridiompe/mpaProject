package com.puridiompe.mpa.business.general;

import com.puridiompe.mpa.business.general.dto.ReclamoDto;

import com.puridiompe.mpa.common.security.exception.SecurityException;

public interface GestionarHistorialReclamoBusiness {

	public void setHistorialReclamo(ReclamoDto reclamo, Integer idReclamo) throws SecurityException;
	
	public void setHistorialComentario(ReclamoDto dddd) throws SecurityException;

}
