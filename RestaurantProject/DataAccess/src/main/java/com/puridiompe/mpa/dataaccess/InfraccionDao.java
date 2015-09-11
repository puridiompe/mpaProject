package com.puridiompe.mpa.dataaccess;

import java.util.List;

import com.puridiompe.mpa.business.general.dto.InfraccionDto;

/**
 * 
 * @author Lucho
 *
 */

public interface InfraccionDao {	
	
	public InfraccionDto getInfraccionByCodigo(String codigo);

	public List<InfraccionDto> findAll();
	
	public InfraccionDto getInfraccionByDescripcion(String descripcion);

}