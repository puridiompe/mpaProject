package com.puridiompe.mpa.business.general;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.puridiompe.mpa.business.general.dto.ActaDto;
import com.puridiompe.mpa.business.general.dto.UsuarioActaDto;

public interface GestionarActaBusiness {

	public ActaDto setActa(ActaDto acta);
	
	public List<ActaDto> getActa(Pageable paging,String username);
	
	public Integer getTotalActas(String username);
	
	public List<ActaDto> getInfraccionesFrecuentes();

	public ActaDto getImages(Integer idActa);

	public UsuarioActaDto getNumeroActa();
	
}
