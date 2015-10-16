package com.puridiompe.mpa.business.impl.general;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.puridiompe.mpa.business.general.GestionarNoticiaBusiness;
import com.puridiompe.mpa.business.general.dto.NoticiaDto;
import com.puridiompe.mpa.dataaccess.NoticiaDao;

/**
 * 
 * @author Lucho
 *
 */

@Service
public class GestionarNoticiaBusinessImpl implements GestionarNoticiaBusiness{

	@Autowired
	private NoticiaDao noticiaDao;
	
	@Override
	public List<NoticiaDto> getAllByEstado() {
		return noticiaDao.findByEstado();
	}
	
	@Override
	public List<NoticiaDto> getLatestNews(){
		return noticiaDao.getLatestNews();
	}

}
