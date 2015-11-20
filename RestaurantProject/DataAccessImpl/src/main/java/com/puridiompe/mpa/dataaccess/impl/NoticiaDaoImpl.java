package com.puridiompe.mpa.dataaccess.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.puridiompe.mpa.business.general.dto.NoticiaDto;
import com.puridiompe.mpa.common.type.Datetime;
import com.puridiompe.mpa.common.util.DateUtil;
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
				Noticia noticiatmp = noticias.get(i);
				BeanUtils.copyProperties(noticiatmp, noticiaDtoTmp);
				
				noticiaDtoTmp.setFecPub(new Datetime(noticiatmp.getFecPub()));
				noticiasObject.add(noticiaDtoTmp);				
			}			
		else return null;	
		
		return noticiasObject;
	}
	
	@Transactional(value = "movilTransactionManager", readOnly = true)
	@Override
	public List<NoticiaDto> getLatestNews() {
		
		List<NoticiaDto> noticiasObject = new ArrayList<NoticiaDto>();
		List<Noticia> noticias = noticiaRepository.findByEstado();
		
		if(noticias != null){
			
			int latestNews = 0;
			
			if(noticias.size() >= 3){
				latestNews = 3;
			}else{
				latestNews = noticias.size();
			}
			
			for(int i = 0; i < latestNews; i++ ){
				NoticiaDto noticiaDtoTmp = new NoticiaDto();
				Noticia noticiatmp = noticias.get(i);
				BeanUtils.copyProperties(noticiatmp, noticiaDtoTmp);
				
				noticiaDtoTmp.setFecPub(new Datetime(noticiatmp.getFecPub()));
				noticiasObject.add(noticiaDtoTmp);				
			}	
		}else{
			return null; 
		}
		return noticiasObject;
	}

	@Override
	public void saveNoticia(NoticiaDto nuevaNoticia) {
		Noticia toSave = new Noticia();
		Date fechaActual = DateUtil.getCurrentDate();
		
		toSave.setTitulo(nuevaNoticia.getTitulo());
		toSave.setContenido(nuevaNoticia.getContenido());
		toSave.setAutor(nuevaNoticia.getAutor());
		toSave.setFecCre(fechaActual);
		toSave.setFecMod(fechaActual);
		toSave.setFecPub(fechaActual);
		toSave.setEstado("1");
		
		if (nuevaNoticia.getIdNoticia() != null) toSave.setIdNoticia(nuevaNoticia.getIdNoticia());
		if (nuevaNoticia.getFuente() != null) toSave.setFuente(nuevaNoticia.getFuente());
		if (nuevaNoticia.getLink() != null) toSave.setLink(nuevaNoticia.getLink());
		
		noticiaRepository.save(toSave);
	}

	@Override
	public Integer getTotalNoticias() {
		
		return noticiaRepository.findTotalNoticias();
	}
}

