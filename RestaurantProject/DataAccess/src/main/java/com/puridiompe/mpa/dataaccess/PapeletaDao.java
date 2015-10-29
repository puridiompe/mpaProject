package com.puridiompe.mpa.dataaccess;

import java.util.List;

import com.puridiompe.mpa.business.general.dto.PapeletaDto;

public interface PapeletaDao {

	public List<PapeletaDto> getPapeletasByPlaca(String placa);
	
}
