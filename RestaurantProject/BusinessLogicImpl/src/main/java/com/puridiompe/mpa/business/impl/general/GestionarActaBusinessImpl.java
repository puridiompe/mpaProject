package com.puridiompe.mpa.business.impl.general;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.puridiompe.mpa.business.general.GestionarActaBusiness;
import com.puridiompe.mpa.business.general.dto.ActaDto;
import com.puridiompe.mpa.dataaccess.ActaDao;

@Service
public class GestionarActaBusinessImpl implements GestionarActaBusiness{

	@Autowired
	private ActaDao acta;

	@Override
	public ActaDto setActa(ActaDto actaRequest) {
		
		return acta.setActa(actaRequest);
	}
	
	@Override
	public List<ActaDto> getActa(String username){
		
		return acta.getActaByUsername(username);
	}
	
	@Override
	public Integer getTotalActas(String username){
		
		return acta.getTotalActas(username);
	}
	
	@Override
	public List<ActaDto> getInfraccionesFrecuentes(){
		
		return acta.getInfraccionesFrecuentes();
	}

	@Override
	public ActaDto getImages(Integer idActa) {
		return acta.getImagesByIdActa(idActa);
	}

}
