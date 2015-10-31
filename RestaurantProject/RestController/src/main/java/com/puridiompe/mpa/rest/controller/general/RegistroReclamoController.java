package com.puridiompe.mpa.rest.controller.general;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.puridiompe.mpa.business.exception.BusinessException;
import com.puridiompe.mpa.business.general.GestionarReclamoBusiness;
import com.puridiompe.mpa.business.general.dto.ReclamoComentarioDto;
import com.puridiompe.mpa.business.general.dto.ReclamoDto;
import com.puridiompe.mpa.business.general.dto.ReclamosDto;
import com.puridiompe.mpa.common.rest.message.RequestMessage;
import com.puridiompe.mpa.common.rest.message.ResponseMessage;
import com.puridiompe.mpa.common.security.SecurityContextHelper;
import com.puridiompe.mpa.common.security.exception.SecurityException;
import com.puridiompe.mpa.common.type.ReclamoState;
import com.puridiompe.mpa.rest.controller.BaseController;
import com.puridiompe.mpa.rest.controller.general.message.GetReclamoRequest;
import com.puridiompe.mpa.rest.controller.general.message.GetReclamoResponse;
import com.puridiompe.mpa.rest.controller.general.message.GetReclamosResponse;

@RestController
@RequestMapping("/transportes/reclamo")
public class RegistroReclamoController extends BaseController{

	@Autowired
	private GestionarReclamoBusiness gestionarReclamo;

	@RequestMapping(value = "/setReclamo", method = RequestMethod.PUT, headers = "Accept=application/json", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseMessage<GetReclamoResponse>  addReclamo(@RequestBody RequestMessage<GetReclamoRequest> request)
			throws BusinessException, SecurityException {		
			
		ResponseMessage<GetReclamoResponse> response = new ResponseMessage<GetReclamoResponse>();
		
		ReclamoDto toSave = request.getBody().getReclamo();
		toSave.setEstado(ReclamoState.RECIBIDO.toString());
		
		//If a citizen manages to send Comentarios, then null them
		toSave.setReclamoComentarios(new ArrayList<ReclamoComentarioDto>());		

		ReclamoDto reclamo = gestionarReclamo.setReclamo(toSave);
		
		GetReclamoResponse reclamoResponse = new GetReclamoResponse();
		reclamoResponse.setReclamo(reclamo);
		response.setBody(reclamoResponse);
		
		return response;

	}


	@RequestMapping(value = "/updateComentario", method = RequestMethod.PUT, headers = "Accept=application/json", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseMessage<GetReclamoResponse> updateComentario(@RequestBody RequestMessage<GetReclamoRequest> request)
			throws BusinessException, SecurityException {		
		
		ReclamoDto toSave = request.getBody().getReclamo();	
		
		 
		ReclamoDto reclamo = gestionarReclamo.setReclamoComentario(toSave);
		
		ResponseMessage<GetReclamoResponse> response = new ResponseMessage<GetReclamoResponse>();
		GetReclamoResponse body = new GetReclamoResponse(); 
		body.setReclamo(reclamo);
		response.setBody(body);
		
		
		return response;

	}
		
	@RequestMapping(value = "/setReclamoSupervisor", method = RequestMethod.PUT, headers = "Accept=application/json", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseMessage<GetReclamoResponse>  addReclamoSupervisor(@RequestBody RequestMessage<GetReclamoRequest> request)
			throws BusinessException, SecurityException {		
			
		ResponseMessage<GetReclamoResponse> response = new ResponseMessage<GetReclamoResponse>();
		
		ReclamoDto toSave = request.getBody().getReclamo();			

		ReclamoDto reclamo = gestionarReclamo.setReclamo(toSave);
		
		GetReclamoResponse reclamoResponse = new GetReclamoResponse();
		reclamoResponse.setReclamo(reclamo);
		response.setBody(reclamoResponse);
		
		return response;

	}
	
	@RequestMapping(value = "/enProceso", method = RequestMethod.PUT, headers = "Accept=application/json", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseMessage<GetReclamoResponse>  enProceso(@RequestBody RequestMessage<GetReclamoRequest> request)
			throws BusinessException, SecurityException {
				
		ResponseMessage<GetReclamoResponse> response = new ResponseMessage<GetReclamoResponse>();
		
		ReclamoDto toUpdate = request.getBody().getReclamo();
		toUpdate.setEstado(ReclamoState.ENPROCESO.toString());

		ReclamoDto reclamo = gestionarReclamo.setReclamo(toUpdate);
		
		GetReclamoResponse reclamoResponse = new GetReclamoResponse();
		reclamoResponse.setReclamo(reclamo);
		response.setBody(reclamoResponse);
		
		return response;
	}
	
	@RequestMapping(value = "/archivado", method = RequestMethod.PUT, headers = "Accept=application/json", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseMessage<GetReclamoResponse>  setToArchivado(@RequestBody RequestMessage<GetReclamoRequest> request)
			throws BusinessException, SecurityException {

		ResponseMessage<GetReclamoResponse> response = new ResponseMessage<GetReclamoResponse>();
		
		ReclamoDto toUpdate = request.getBody().getReclamo();	
		toUpdate.setEstado(ReclamoState.ARCHIVADO.toString());

		ReclamoDto reclamo = gestionarReclamo.setReclamo(toUpdate);
		
		GetReclamoResponse reclamoResponse = new GetReclamoResponse();
		reclamoResponse.setReclamo(reclamo);
		response.setBody(reclamoResponse);
		
		return response;

	}

	@RequestMapping(value = "/getAll", method = RequestMethod.POST, headers = "Accept=application/json", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseMessage<GetReclamoResponse> getReclamosFrecuentes() throws BusinessException {

		List<ReclamoDto> reclamosObject = gestionarReclamo.getReclamosFrecuentes();

		ResponseMessage<GetReclamoResponse> response = new ResponseMessage<GetReclamoResponse>();

		GetReclamoResponse reclamoFrecuenteResponse = new GetReclamoResponse();

		reclamoFrecuenteResponse.setReclamosFrecuentes(reclamosObject);

		response.setBody(reclamoFrecuenteResponse);

		return response;
	}

	@RequestMapping(value = "/getLastDniByImei", method = RequestMethod.POST, headers = "Accept=application/json", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseMessage<GetReclamoResponse> getLastDniByImei(
			@RequestBody RequestMessage<GetReclamoRequest> request) throws BusinessException, SecurityException {

		String currentImei = SecurityContextHelper.getCurrentImei();

		Integer dni = gestionarReclamo.getLastDniByImei(currentImei);// request.getBody().getReclamo().getImei());
		ResponseMessage<GetReclamoResponse> response = new ResponseMessage<GetReclamoResponse>();

		GetReclamoResponse lastDnibyImeiResponse = new GetReclamoResponse();

		ReclamoDto forResponse = new ReclamoDto();
		forResponse.setDni(dni);

		lastDnibyImeiResponse.setReclamo(forResponse);

		response.setBody(lastDnibyImeiResponse);

		return response;
	}
	
	@RequestMapping(value = "/getNumeroReclamos", method = RequestMethod.POST, headers = "Accept=application/json", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseMessage<GetReclamoResponse> getNumeroReclamos() throws SecurityException {

		ResponseMessage<GetReclamoResponse> response = new ResponseMessage<GetReclamoResponse>();

		GetReclamoResponse numeroReclamosResponse = new GetReclamoResponse();
		
		Integer numeroReclamos = gestionarReclamo.getCountReclamoByImei();

		numeroReclamosResponse.setNumeroReclamos(numeroReclamos);

		response.setBody(numeroReclamosResponse);

		return response;
	}

	@RequestMapping(value = "/getAllReclamo", method = RequestMethod.POST, headers = "Accept=application/json", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseMessage<GetReclamosResponse> getAll()
			throws BusinessException {

		ResponseMessage<GetReclamosResponse> response = new ResponseMessage<GetReclamosResponse>();

		GetReclamosResponse reclamoResponse = new GetReclamosResponse();

		ReclamosDto forResponse = gestionarReclamo.getAll();

		reclamoResponse.setReclamos(forResponse);

		response.setBody(reclamoResponse);

		return response;
	}
	
	@RequestMapping(value = "/get", method = RequestMethod.POST, headers = "Accept=application/json", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseMessage<GetReclamosResponse> getAllByImei()
			throws BusinessException, SecurityException{
		

		String currentImei = SecurityContextHelper.getCurrentImei();
//		GetReclamosRequest reclamosRequest = request.getBody();
		ReclamosDto reclamosObject = gestionarReclamo.getReclamosByImei(currentImei);
		
		ResponseMessage<GetReclamosResponse> response = new ResponseMessage<GetReclamosResponse>();
		GetReclamosResponse reclamosResponse = new GetReclamosResponse();
		
		reclamosResponse.setReclamos(reclamosObject);
		response.setBody(reclamosResponse);
		
		return response;
	}
	
	@RequestMapping(value = "/getImages", method = RequestMethod.POST, headers = "Accept=application/json", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseMessage<GetReclamoResponse> getImagesByNumRec(
			@RequestBody RequestMessage<GetReclamoRequest> request) throws BusinessException, SecurityException {

		String numRec = request.getBody().getNumRec();
		
		ReclamoDto reclamoObject = gestionarReclamo.getImagesByNumRec(numRec);
		
		ResponseMessage<GetReclamoResponse> response = new ResponseMessage<GetReclamoResponse>();
		GetReclamoResponse reclamoResponse = new GetReclamoResponse();
		
		reclamoResponse.setReclamo(reclamoObject);
		response.setBody(reclamoResponse);
		return response;
	}	
}
