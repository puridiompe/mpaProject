package com.puridiompe.mpa.dataaccess;

import java.util.List;

import com.puridiompe.mpa.business.general.dto.NoticiaDto;

public interface NoticiaDao {

	public List<NoticiaDto> findByEstado();
	public List<NoticiaDto> getLatestNews();
	
}
