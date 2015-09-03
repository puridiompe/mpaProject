package com.puridiompe.mpa.business.impl.general;

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
public class GestionarInfraccionbusinessImpl implements GestionarInfraccionBusiness{

	@Autowired
	private InfraccionDao infraccionDao;
	
	@Override
	public InfraccionDto getInfraccion(Integer id) {		
		return infraccionDao.getInfraccionById(id);
	}

}
