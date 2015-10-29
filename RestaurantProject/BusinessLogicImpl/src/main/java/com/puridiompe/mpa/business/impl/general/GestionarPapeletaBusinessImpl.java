package com.puridiompe.mpa.business.impl.general;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.puridiompe.mpa.business.general.GestionarPapeletaBusiness;
import com.puridiompe.mpa.business.general.dto.PapeletaDto;
import com.puridiompe.mpa.dataaccess.PapeletaDao;

@Service
public class GestionarPapeletaBusinessImpl implements GestionarPapeletaBusiness{
	
	@Autowired
	private PapeletaDao papeletaDao;

	
	@Override
	public List<PapeletaDto> getPapeletas(String placa){
		return papeletaDao.getPapeletasByPlaca(placa);
	}

}
