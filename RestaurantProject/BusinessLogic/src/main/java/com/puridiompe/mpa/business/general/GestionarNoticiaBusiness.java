package com.puridiompe.mpa.business.general;

import java.util.List;

import com.puridiompe.mpa.business.general.dto.NoticiaDto;
import com.puridiompe.mpa.common.annotation.SafeMethod;

/**
 * 
 * @author José
 *
 */

public interface GestionarNoticiaBusiness {
	
	//@SafeMethod
	public List<NoticiaDto> getAllByEstado();
	public List<NoticiaDto> getLatestNews();
	public void saveNoticia(NoticiaDto nuevaNoticia);
}
