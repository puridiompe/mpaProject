package com.puridiompe.mpa.business.general;

import java.util.List;

import com.puridiompe.mpa.business.general.dto.PapeletaDto;

public interface GestionarPapeletaBusiness {
	
	public List<PapeletaDto> getPapeletas(String placa);

}
