package com.puridiompe.mpa.rest.controller.general;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.puridiompe.mpa.business.exception.BusinessException;
import com.puridiompe.mpa.business.general.GestionarNoticiaBusiness;
import com.puridiompe.mpa.business.general.dto.NoticiaDto;
import com.puridiompe.mpa.common.rest.message.ResponseMessage;
import com.puridiompe.mpa.rest.controller.BaseController;
import com.puridiompe.mpa.rest.controller.general.message.GetNoticiasResponse;
import com.puridiompe.mpa.rest.controller.general.validation.GetNoticiaValidator;


/**
 * @author José
 *
 */

@RestController
@RequestMapping("/transportes/noticia")
public class RegistroNoticiaController extends BaseController{
	
	@Autowired
	private GestionarNoticiaBusiness gestionarNoticiaBusiness;
	
	@Autowired
	private GetNoticiaValidator getNoticiaValidator;
	
	@InitBinder
	protected void InitBinder(WebDataBinder binder){
		binder.setValidator(getNoticiaValidator);
	}
	
	@RequestMapping(value = "/getAll", method = RequestMethod.POST, headers = "Accept=application/json", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseMessage<GetNoticiasResponse> getNoticias()			
			throws BusinessException {		
		
		List<NoticiaDto> noticiasObject = gestionarNoticiaBusiness.getAllByEstado();
		
		ResponseMessage<GetNoticiasResponse> response = new ResponseMessage<GetNoticiasResponse>();
		
		GetNoticiasResponse noticiasResponse = new GetNoticiasResponse();
		
		noticiasResponse.setNoticias(noticiasObject);
		
		response.setBody(noticiasResponse);
		
		return response;		
	}
	
	@RequestMapping(value = "/getLatest", method = RequestMethod.POST, headers = "Accept=application/json", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseMessage<GetNoticiasResponse> getLatestNews()			
			throws BusinessException {		
		
		List<NoticiaDto> noticiasObject = gestionarNoticiaBusiness.getAllByEstado();
		
		ResponseMessage<GetNoticiasResponse> response = new ResponseMessage<GetNoticiasResponse>();
		
		GetNoticiasResponse noticiasResponse = new GetNoticiasResponse();
		
		noticiasResponse.setNoticias(noticiasObject);
		
		response.setBody(noticiasResponse);
		
		return response;		
	}
}
