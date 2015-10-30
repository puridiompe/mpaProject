package com.puridiompe.mpa.dataaccess;

import java.io.IOException;
import java.util.List;

import com.puridiompe.mpa.business.general.dto.ReclamoDto;
import com.puridiompe.mpa.business.general.dto.ReclamosDto;
import com.puridiompe.mpa.common.security.exception.SecurityException;

public interface ReclamoDao {

	public Integer saveReclamo (ReclamoDto request) throws SecurityException;
	
	public ReclamoDto saveReclamoComentario(ReclamoDto request);
	
	public List<ReclamoDto> getReclamosFrecuentes();
	
	public Integer getLastDniByImei(String imei);

	public ReclamosDto getAll();
	
	public ReclamoDto getById(Integer idReclamo);
	
	public ReclamosDto getReclamosByImei(String imei);
	
	public ReclamoDto getImagesByNumRec(String numRec);	
}
