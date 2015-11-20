package com.puridiompe.mpa.business.impl.general;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.puridiompe.mpa.business.general.GestionarNoticiaBusiness;
import com.puridiompe.mpa.business.general.dto.NoticiaDto;
import com.puridiompe.mpa.common.type.Datetime;
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
	public List<NoticiaDto> getAllByEstado(Pageable paging) {
		
		List<NoticiaDto> noticiaObject = noticiaDao.findByEstado(paging);
		
		for(int i = 0; i < noticiaObject.size(); i ++){
			
			DateFormat fechaHora = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String fecha = fechaHora.format (noticiaObject.get(i).getFecPub());
			String [] fechaAndHora = fecha.split(" ");
			noticiaObject.get(i).setFecha(fechaAndHora[0]);
			noticiaObject.get(i).setHora (fechaAndHora[1]);
		}
		
		return noticiaObject;
	}
	
//	@Override
//	public List<NoticiaDto> getLatestNews(){
//		return noticiaDao.getLatestNews();
//	}

	@Override
	public void saveNoticia(NoticiaDto nuevaNoticia) {
		
//		String fecha = nuevaNoticia.getFecha() + nuevaNoticia.getHora();
//		
//		SimpleDateFormat formatter = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
//		try {
//			Date date = formatter.parse(fecha);
//			Datetime dateTime = new Datetime(date);
//			nuevaNoticia.setFecPub(dateTime);
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
		
		noticiaDao.saveNoticia(nuevaNoticia);
	}

	@Override
	public Integer getCountNoticias() {
		
		return noticiaDao.getTotalNoticias();
	}

}
