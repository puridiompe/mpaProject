package com.puridiompe.mpa.dataaccess;

import java.util.List;

import com.puridiompe.mpa.business.general.dto.ReclamoDto;
import com.puridiompe.mpa.common.security.exception.SecurityException;

public interface ReclamoDao {

	public Integer saveReclamo (ReclamoDto request) throws SecurityException;
	
	public List<ReclamoDto> getReclamosFrecuentes();
	
	public Integer getLastDniByImei(String imei);

	public List<ReclamoDto> getAll();
	
	public ReclamoDto getById(Integer idReclamo);
}
