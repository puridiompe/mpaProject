package com.puridiompe.mpa.business.general;

import java.util.List;

import com.puridiompe.mpa.business.general.dto.ReclamoDto;
import com.puridiompe.mpa.common.security.exception.SecurityException;;

public interface GestionarReclamoBusiness {

	public ReclamoDto setReclamo(ReclamoDto request) throws SecurityException;
	
	public ReclamoDto setReclamoComentario(ReclamoDto request) throws SecurityException;
	
	public List<ReclamoDto> getAllReclamos();
	
	public List<ReclamoDto> getReclamosFrecuentes();
	
	public Integer getLastDniByImei(String imei);

	public ReclamoDto getImagesByNumRec(String numRec);
	
	public Integer getCountReclamoByImei() throws SecurityException;
	
	public List<ReclamoDto> getReclamosByImei(String imei);
}
