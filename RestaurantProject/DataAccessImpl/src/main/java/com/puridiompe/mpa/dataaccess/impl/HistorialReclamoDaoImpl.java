package com.puridiompe.mpa.dataaccess.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.puridiompe.mpa.business.general.dto.HistorialReclamoDto;
import com.puridiompe.mpa.dataaccess.HistorialReclamoDao;
import com.puridiompe.mpa.movil.domain.persistence.HistorialReclamo;
import com.puridiompe.mpa.movil.repository.persistence.HistorialReclamoRepository;

@Component
public class HistorialReclamoDaoImpl implements HistorialReclamoDao {

	@Autowired
	HistorialReclamoRepository historialReclamoRepository;
	
	@Transactional(value = "movilTransactionManager")
	@Override
	public void setHistorialReclamo(HistorialReclamoDto historialObject) {
		
		HistorialReclamo historialReclamo = new HistorialReclamo();
		if(historialObject != null){
			BeanUtils.copyProperties(historialObject, historialReclamo);
			historialReclamoRepository.save(historialReclamo);
		}

	}

}
