package com.puridiompe.mpa.business.general;

import java.util.List;

import com.puridiompe.mpa.business.general.dto.InfraccionDto;

/**
 * 
 * @author Lucho
 *
 */

public interface GestionarInfraccionBusiness {
	
	public InfraccionDto getInfraccionByCodigo(String codigo);
	
	public InfraccionDto getInfraccionbyDescripcion(String descripcion);

	public List<InfraccionDto> getAll();	
	

}