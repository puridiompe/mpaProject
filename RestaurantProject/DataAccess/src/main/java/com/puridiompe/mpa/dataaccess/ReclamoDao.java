package com.puridiompe.mpa.dataaccess;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.puridiompe.mpa.business.general.dto.FilterDto;
import com.puridiompe.mpa.business.general.dto.ReclamoDto;
import com.puridiompe.mpa.common.security.exception.SecurityException;

public interface ReclamoDao {

	public Integer saveReclamo (ReclamoDto request) throws SecurityException;
	
	public ReclamoDto saveReclamoComentario(ReclamoDto request);
	
	public List<ReclamoDto> getAllReclamos(Pageable paging, List<FilterDto> filter);
	
	public List<ReclamoDto> getReclamosByImei(String imei); 
	
	public List<ReclamoDto> getReclamosFrecuentes();
	
	public Integer getLastDniByImei(String imei);

	public ReclamoDto getById(Integer idReclamo);
	
	public ReclamoDto getImagesByNumRec(String numRec);	
	
	public Integer countReclamosByImei(String imei);
	
	public Integer getTotalReclamos(List<FilterDto> filter);
}
