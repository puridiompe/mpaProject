package com.puridiompe.mpa.dataaccess.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.puridiompe.mpa.business.general.dto.NoticiaDto;
import com.puridiompe.mpa.dataaccess.NoticiaDao;
import com.puridiompe.mpa.movil.domain.persistence.Noticia;
import com.puridiompe.mpa.movil.repository.persistence.NoticiaRepository;

/**
 * @author José
 *
 */

@Component
public class NoticiaDaoImpl implements NoticiaDao{

	@Autowired
	private NoticiaRepository noticiaRepository;
	
	@Transactional(value = "movilTransactionManager", readOnly = true)
	@Override
	public List<NoticiaDto> findByEstado() {
		
		List<NoticiaDto> noticiasObject = new ArrayList<NoticiaDto>();
		List<Noticia> noticias = noticiaRepository.findByEstado();
		
		if(noticias != null)	
			for(int i = 0; i < noticias.size(); i++ ){
				NoticiaDto noticiaDtoTmp = new NoticiaDto();
				BeanUtils.copyProperties(noticias.get(i), noticiaDtoTmp);
				noticiasObject.add(noticiaDtoTmp);				
			}			
		else return null;	
		
		return noticiasObject;
	}
}
