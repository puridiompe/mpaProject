package com.puridiompe.mpa.business.impl.general;

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

}
