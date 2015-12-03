package com.puridiompe.mpa.business.general;

import java.util.List;

import com.puridiompe.mpa.business.general.dto.ActaDto;
import com.puridiompe.mpa.business.general.dto.UsuarioActaDto;

public interface GestionarActaBusiness {

	public ActaDto setActa(ActaDto acta);
	
	public List<ActaDto> getActa(String username);
	
	public Integer getTotalActas(String username);
	
	public List<ActaDto> getInfraccionesFrecuentes();
	
	public UsuarioActaDto getNumeroActa();
	
}
