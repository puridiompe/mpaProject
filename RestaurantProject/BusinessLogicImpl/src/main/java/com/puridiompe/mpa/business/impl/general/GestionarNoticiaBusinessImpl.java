package com.puridiompe.mpa.business.impl.general;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
		
		List<NoticiaDto> noticiaObject = noticiaDao.findByEstado();
		
		for(int i = 0; i < noticiaObject.size(); i ++){
			
			DateFormat fechaHora = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String fecha = fechaHora.format (noticiaObject.get(i).getFecPub());
			String [] fechaAndHora = fecha.split(" ");
			noticiaObject.get(i).setFecha(fechaAndHora[0]);
			noticiaObject.get(i).setHora (fechaAndHora[1]);
		}
		
		return noticiaObject;
	}
	
	@Override
	public List<NoticiaDto> getLatestNews(){
		return noticiaDao.getLatestNews();
	}

	@Override
	public void saveNoticia(NoticiaDto nuevaNoticia) {
		
		noticiaDao.saveNoticia(nuevaNoticia);
	}

}
