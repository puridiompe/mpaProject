package com.puridiompe.mpa.rest.controller.general.message;

import com.puridiompe.mpa.business.general.dto.NoticiaDto;
import com.puridiompe.mpa.common.rest.message.RequestBody;

/**
 * 
 * @author José
 *
 */

public class GetNoticiaRequest extends RequestBody{
	
	private NoticiaDto noticia;
	
	public NoticiaDto getNoticia(){
		return noticia;
	}
	
	public void setNoticia(NoticiaDto noticia){
		this.noticia = noticia;
	}

}
