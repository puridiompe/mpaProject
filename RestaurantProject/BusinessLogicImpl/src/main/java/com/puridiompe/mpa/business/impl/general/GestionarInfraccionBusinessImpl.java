package com.puridiompe.mpa.business.impl.general;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.puridiompe.mpa.business.general.GestionarInfraccionBusiness;
import com.puridiompe.mpa.business.general.dto.InfraccionDto;
import com.puridiompe.mpa.dataaccess.InfraccionDao;

/**
 * 
 * @author Lucho
 *
 */

@Service
public class GestionarInfraccionBusinessImpl implements GestionarInfraccionBusiness{

	@Autowired
	private InfraccionDao infraccionDao;
	
	@Override
	public InfraccionDto getInfraccionByCodigo(String codigo) {		
		return infraccionDao.getInfraccionByCodigo(codigo);
	}
	
	@Override
	public InfraccionDto getInfraccionbyDescripcion(String descripcion) {		
		return infraccionDao.getInfraccionByDescripcion(descripcion);
	}

	@Override
	public List<InfraccionDto> getAll() {
		return infraccionDao.findAll();
	}
	

}