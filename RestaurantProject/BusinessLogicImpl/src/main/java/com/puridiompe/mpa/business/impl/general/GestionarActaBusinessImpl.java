package com.puridiompe.mpa.business.impl.general;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.puridiompe.mpa.business.general.GestionarActaBusiness;
import com.puridiompe.mpa.business.general.dto.ActaDto;
import com.puridiompe.mpa.business.general.dto.UsuarioActaDto;
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
	public List<ActaDto> getActa(Pageable paging, String username){
		
		return acta.getActaByUsername(paging, username);
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
	public UsuarioActaDto getNumeroActa(){
		
		return acta.getNumeroActa();
	};

	@Override
	public ActaDto getImages(Integer idActa) {
		return acta.getImagesByIdActa(idActa);
	}

}
