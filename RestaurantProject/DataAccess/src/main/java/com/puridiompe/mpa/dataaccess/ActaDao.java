package com.puridiompe.mpa.dataaccess;

import java.util.List;

import com.puridiompe.mpa.business.general.dto.ActaDto;
import com.puridiompe.mpa.business.general.dto.UsuarioActaDto;

public interface ActaDao {

	public ActaDto setActa(ActaDto acta);
	
	public List<ActaDto> getActaByUsername(String username);
	
	public Integer getTotalActas(String username);
	
	public List<ActaDto> getInfraccionesFrecuentes();

	public ActaDto getImagesByIdActa (Integer idActa);

	public UsuarioActaDto getNumeroActa();

}
