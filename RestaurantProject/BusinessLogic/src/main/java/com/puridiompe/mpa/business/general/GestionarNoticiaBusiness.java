package com.puridiompe.mpa.business.general;

import java.util.List;

import com.puridiompe.mpa.business.general.dto.NoticiaDto;

/**
 * 
 * @author José
 *
 */

public interface GestionarNoticiaBusiness {
	public List<NoticiaDto> getAllByEstado();	
}
