package com.puridiompe.mpa.rest.controller.general.message;

import java.util.List;

import com.puridiompe.mpa.business.general.dto.NoticiaDto;
import com.puridiompe.mpa.common.rest.message.ResponseBody;


/**
 * 
 * @author José
 *
 */

public class GetNoticiasResponse extends ResponseBody{
	
	private List<NoticiaDto> noticia;
	
	public List<NoticiaDto> getNoticias(){
		return noticia;
	}
	
	public void setNoticias(List<NoticiaDto> noticia){
		this.noticia = noticia;
	}

}
