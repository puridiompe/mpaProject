package com.puridiompe.mpa.dataaccess;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.puridiompe.mpa.business.general.dto.NoticiaDto;

public interface NoticiaDao {

	public List<NoticiaDto> findByEstado(Pageable paging);
//	public List<NoticiaDto> getLatestNews();
	public void saveNoticia(NoticiaDto nuevaNoticia);
	public Integer getTotalNoticias();
}
