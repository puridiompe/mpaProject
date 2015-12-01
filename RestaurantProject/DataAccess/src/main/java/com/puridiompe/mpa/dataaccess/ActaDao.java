package com.puridiompe.mpa.dataaccess;

import java.util.List;

import com.puridiompe.mpa.business.general.dto.ActaDto;

public interface ActaDao {

	public ActaDto setActa(ActaDto acta);
	
	public List<ActaDto> getActaByUsername(String username);
	
	public Integer getTotalActas(String username);
}
