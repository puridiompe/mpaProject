package com.puridiompe.mpa.dataaccess;

import com.puridiompe.mpa.business.general.dto.InfraccionDto;

/**
 * 
 * @author Lucho
 *
 */

public interface InfraccionDao {
	
	public InfraccionDto getInfraccionById(Integer id);
	
	public InfraccionDto getInfraccionByDescripcion(String descripcion);

}
