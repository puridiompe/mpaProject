package com.puridiompe.mpa.business.general;

import java.util.List;

import com.puridiompe.mpa.business.general.dto.ReclamoDto;
import com.puridiompe.mpa.business.general.dto.ReclamosDto;
import com.puridiompe.mpa.common.security.exception.SecurityException;;

public interface GestionarReclamoBusiness {

	public ReclamoDto setReclamo(ReclamoDto request) throws SecurityException;
	
	public boolean setReclamoComentario(ReclamoDto request);
	
	public List<ReclamoDto> getReclamosFrecuentes();
	
	public Integer getLastDniByImei(String imei);

	public ReclamosDto getAll();
	
	public ReclamosDto getReclamosByImei(String imei);
	
	public ReclamoDto getImagesByNumRec(String numRec);	
}
