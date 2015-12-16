package com.puridiompe.mpa.dataaccess;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.puridiompe.mpa.business.general.dto.ActaDto;
import com.puridiompe.mpa.business.general.dto.FilterDto;
import com.puridiompe.mpa.business.general.dto.UsuarioActaDto;

public interface ActaDao {

	public ActaDto setActa(ActaDto acta);
	
	public List<ActaDto> getActaByUsername(Pageable paging, String username);
	
	public List<ActaDto> findAllActas(Pageable paging,List<FilterDto> filter);
	
	public Integer getTotalActas(String username);
	
	public Integer getAllTotalActas(List<FilterDto> filter);
	
	public List<ActaDto> getInfraccionesFrecuentes();

	public ActaDto getImagesByIdActa (Integer idActa);

	public UsuarioActaDto getNumeroActa();

}
