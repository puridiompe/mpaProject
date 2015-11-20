package com.puridiompe.mpa.rest.controller.general;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.puridiompe.mpa.business.exception.BusinessException;
import com.puridiompe.mpa.business.general.GestionarNoticiaBusiness;
import com.puridiompe.mpa.business.general.dto.NoticiaDto;
import com.puridiompe.mpa.business.general.dto.ReclamoDto;
import com.puridiompe.mpa.common.rest.message.RequestMessage;
import com.puridiompe.mpa.common.rest.message.ResponseMessage;
import com.puridiompe.mpa.rest.controller.BaseController;
import com.puridiompe.mpa.rest.controller.general.message.GetNoticiasResponse;
import com.puridiompe.mpa.rest.controller.general.message.GetPaginacionRequest;
import com.puridiompe.mpa.rest.controller.general.message.GetNoticiaRequest;
import com.puridiompe.mpa.rest.controller.general.message.GetReclamoResponse;
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
	public @ResponseBody ResponseMessage<GetNoticiasResponse> getNoticias(@RequestBody RequestMessage<GetPaginacionRequest> request)			
			throws BusinessException {
		
		Pageable paging = new PageRequest(request.getBody().getPageCount(), request.getBody().getPageSize(), Sort.Direction.DESC, "fecCre");
		
		List<NoticiaDto> noticiasObject = gestionarNoticiaBusiness.getAllByEstado(paging);
		
		ResponseMessage<GetNoticiasResponse> response = new ResponseMessage<GetNoticiasResponse>();
		
		GetNoticiasResponse noticiasResponse = new GetNoticiasResponse();
		
		noticiasResponse.setNoticias(noticiasObject);
		
		response.setBody(noticiasResponse);
		
		return response;		
	}
	
//	@RequestMapping(value = "/getLatest", method = RequestMethod.POST, headers = "Accept=application/json", produces = MediaType.APPLICATION_JSON_VALUE)
//	public @ResponseBody ResponseMessage<GetNoticiasResponse> getLatestNews()			
//			throws BusinessException {		
//		
//		List<NoticiaDto> noticiasObject = gestionarNoticiaBusiness.getLatestNews();
//		
//		ResponseMessage<GetNoticiasResponse> response = new ResponseMessage<GetNoticiasResponse>();
//		
//		GetNoticiasResponse noticiasResponse = new GetNoticiasResponse();
//		
//		noticiasResponse.setNoticias(noticiasObject);
//		
//		response.setBody(noticiasResponse);
//		
//		return response;		
//	}
	
	@RequestMapping(value = "/saveNoticia", method = RequestMethod.PUT, headers = "Accept=application/json", produces = MediaType.APPLICATION_JSON_VALUE)
	public void saveNoticia(@RequestBody RequestMessage<GetNoticiaRequest> request)			
			throws BusinessException {		
		
		NoticiaDto toSave = request.getBody().getNoticia();
		
		gestionarNoticiaBusiness.saveNoticia(toSave);
		
		/*
		
		List<NoticiaDto> noticiasObject = gestionarNoticiaBusiness.getAllByEstado();
		
		ResponseMessage<GetNoticiasResponse> response = new ResponseMessage<GetNoticiasResponse>();
		
		GetNoticiasResponse noticiasResponse = new GetNoticiasResponse();
		
		noticiasResponse.setNoticias(noticiasObject);
		
		response.setBody(noticiasResponse);
		
		return response;		*/
	}
	
	@RequestMapping(value = "/getTotalNoticia", method = RequestMethod.POST, headers = "Accept=application/json", produces = MediaType.APPLICATION_JSON_VALUE)	
	public @ResponseBody ResponseMessage<GetNoticiasResponse> getTotalNoticias() throws BusinessException {		
		
		ResponseMessage<GetNoticiasResponse> response = new ResponseMessage<GetNoticiasResponse>();
		
		GetNoticiasResponse numeroNoticiasResponse = new GetNoticiasResponse();
		
		Integer numeroNoticias = gestionarNoticiaBusiness.getCountNoticias();
		
		numeroNoticiasResponse.setNumeroNoticias(numeroNoticias);
		
		response.setBody(numeroNoticiasResponse);
		
		return response;
		
	}
}
