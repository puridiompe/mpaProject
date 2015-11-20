package com.puridiompe.mpa.business.general;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.puridiompe.mpa.business.general.dto.NoticiaDto;

/**
 * 
 * @author José
 *
 */

public interface GestionarNoticiaBusiness {
	
	//@SafeMethod
	public List<NoticiaDto> getAllByEstado(Pageable paging);
//	public List<NoticiaDto> getLatestNews();
	public void saveNoticia(NoticiaDto nuevaNoticia);
	public Integer getCountNoticias();

}
