package com.puridiompe.mpa.rest.controller.general;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.puridiompe.mpa.business.exception.BusinessException;
import com.puridiompe.mpa.business.general.GestionarActaBusiness;
import com.puridiompe.mpa.business.general.dto.ActaDto;
import com.puridiompe.mpa.business.general.dto.UsuarioActaDto;
import com.puridiompe.mpa.common.rest.message.RequestMessage;
import com.puridiompe.mpa.common.rest.message.ResponseMessage;
import com.puridiompe.mpa.common.security.SecurityContextHelper;
import com.puridiompe.mpa.common.security.exception.SecurityException;
import com.puridiompe.mpa.common.type.ReclamoState;
import com.puridiompe.mpa.rest.controller.general.message.GetActaByUsernameResponse;
import com.puridiompe.mpa.rest.controller.general.message.GetActaRequest;
import com.puridiompe.mpa.rest.controller.general.message.GetActaResponse;
import com.puridiompe.mpa.rest.controller.general.message.GetPaginacionRequest;

@RestController
@RequestMapping("/transportes/acta")
public class RegistroActaController {

	@Autowired
	private GestionarActaBusiness gestionarActaBusiness;
	
	@RequestMapping(value = "/set", method = RequestMethod.PUT, headers = "Accept=application/json", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseMessage<GetActaResponse>  setActa(@RequestBody RequestMessage<GetActaRequest> request)
			throws BusinessException, SecurityException {		
			
		ResponseMessage<GetActaResponse> response = new ResponseMessage<GetActaResponse>();
		
		ActaDto actaDto = request.getBody().getActa();
		actaDto.setEstado(ReclamoState.RECIBIDO.toString());
		actaDto.setUsername(SecurityContextHelper.getCurrentUsername());

		ActaDto actaObject = gestionarActaBusiness.setActa(actaDto);
		
		GetActaResponse actaResponse = new GetActaResponse();
		actaResponse.setActa(actaObject);
		response.setBody(actaResponse);
		
		return response;
	}
	
	@RequestMapping(value = "/get", method = RequestMethod.POST, headers = "Accept=application/json", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseMessage<GetActaByUsernameResponse>  getActa(@RequestBody RequestMessage<GetPaginacionRequest> request)
			throws BusinessException, SecurityException {		
			
		Pageable paging = new PageRequest(request.getBody().getPageCount(), request.getBody().getPageSize(), Sort.Direction.ASC, "idActa");
		
		ResponseMessage<GetActaByUsernameResponse> responseActa = new ResponseMessage<GetActaByUsernameResponse>();
		
		List<ActaDto> actaDto = gestionarActaBusiness.getActa(paging, SecurityContextHelper.getCurrentUsername());
		
		GetActaByUsernameResponse actaResponse = new GetActaByUsernameResponse();
		actaResponse.setActaUsername(actaDto);
		responseActa.setBody(actaResponse);
		
		return responseActa;
	}
	
	@RequestMapping(value = "/getAll", method = RequestMethod.POST, headers = "Accept=application/json", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseMessage<GetActaByUsernameResponse>  getAllActas(@RequestBody RequestMessage<GetPaginacionRequest> request)
			 {		
			
		Pageable paging = new PageRequest(request.getBody().getPageCount(), request.getBody().getPageSize(), Sort.Direction.ASC, "idActa");
		ResponseMessage<GetActaByUsernameResponse> response = new ResponseMessage<GetActaByUsernameResponse>();
		
		List<ActaDto> actaDto = gestionarActaBusiness.getAllActas(paging,request.getBody().getFilterList());
		
		GetActaByUsernameResponse actaResponse = new GetActaByUsernameResponse();
		actaResponse.setActaUsername(actaDto);
		response.setBody(actaResponse);
		
		actaResponse.setFilterList(request.getBody().getFilterList());
		//responseActa.setFilterList(request.getBody().getFilterList());	
		
		return response;
	}
	
	@RequestMapping(value = "/getTotal", method = RequestMethod.POST, headers = "Accept=application/json", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseMessage<GetActaResponse>  getTotalActas()
			throws BusinessException, SecurityException {
		
		ResponseMessage<GetActaResponse> response = new ResponseMessage<GetActaResponse>();
		
		Integer total = gestionarActaBusiness.getTotalActas(SecurityContextHelper.getCurrentUsername());
		
		GetActaResponse getActaResponse = new GetActaResponse();
		
		getActaResponse.setNumeroActas(total);
		
		response.setBody(getActaResponse);
		
		return response;
	}
	
	@RequestMapping(value = "/getAllTotal", method = RequestMethod.POST, headers = "Accept=application/json", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseMessage<GetActaResponse>  getAllTotalActas(@RequestBody RequestMessage<GetPaginacionRequest> request)
	{
		
		ResponseMessage<GetActaResponse> response = new ResponseMessage<GetActaResponse>();
		
		Integer total = gestionarActaBusiness.getAllTotalActas(request.getBody().getFilterList());
		
		GetActaResponse getActaResponse = new GetActaResponse();
		
		getActaResponse.setNumeroActas(total);
		
		response.setBody(getActaResponse);
		
		return response;
	}
	
	@RequestMapping(value = "/getInfraccionesFrecuentes", method = RequestMethod.POST, headers = "Accept=application/json", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseMessage<GetActaResponse>  getInfraccionesFrecuentes()
			throws BusinessException, SecurityException {
		
		ResponseMessage<GetActaResponse> response = new ResponseMessage<GetActaResponse>();
		
		List<ActaDto> infraccionesFrecuentes = gestionarActaBusiness.getInfraccionesFrecuentes();
		
		GetActaResponse getActaResponse = new GetActaResponse();
		
		getActaResponse.setInfraccionesFrecuentes(infraccionesFrecuentes);;
		
		response.setBody(getActaResponse);
		
		return response;
	}
	

	@RequestMapping(value = "/getImages", method = RequestMethod.POST, headers = "Accept=application/json", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseMessage<GetActaResponse> getImagesByIdActa(
			@RequestBody RequestMessage<GetActaRequest> request) throws BusinessException, SecurityException {

		Integer  idActa = request.getBody().getIdActa();
		
		ActaDto actaObject = gestionarActaBusiness.getImages(idActa);
		
		ResponseMessage<GetActaResponse> response = new ResponseMessage<GetActaResponse>();
		GetActaResponse actaResponse = new GetActaResponse();
		
		actaResponse.setActa(actaObject);
		response.setBody(actaResponse);
		return response;
	}	

	@RequestMapping(value = "/getNumeroActa", method = RequestMethod.POST, headers = "Accept=application/json", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseMessage<GetActaResponse>  getNumeroActa()
			throws BusinessException, SecurityException {
		
		ResponseMessage<GetActaResponse> response = new ResponseMessage<GetActaResponse>();
		
		UsuarioActaDto usuarioActa = gestionarActaBusiness.getNumeroActa();
		usuarioActa.setUsername(SecurityContextHelper.getCurrentUsername());
		
		GetActaResponse getActaResponse = new GetActaResponse();
		
		getActaResponse.setUsuarioActa(usuarioActa);;
		
		response.setBody(getActaResponse);
		
		return response;
	}
	
}
