package com.puridiompe.mpa.dataaccess.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.puridiompe.mpa.business.general.dto.ReclamoDto;
import com.puridiompe.mpa.dataaccess.ReclamoDao;
import com.puridiompe.mpa.movil.domain.persistence.Reclamo;
import com.puridiompe.mpa.movil.domain.persistence.ReclamoFrecuente;
import com.puridiompe.mpa.movil.repository.persistence.ReclamoFrecuenteRepository;
import com.puridiompe.mpa.movil.repository.persistence.ReclamoRepository;

@Component
public class ReclamoDaoImpl implements ReclamoDao {

	@Autowired
	private ReclamoRepository reclamoRepository;
	
	@Autowired
	private ReclamoFrecuenteRepository reclamofrecuenteRepository;
	
	@Transactional(value = "movilTransactionManager")
	@Override
	public void setReclamo(Integer dni, String descripcion, String vehiculo) {
		
		Reclamo reclamo =  new Reclamo();
		reclamo.setDni(dni);
		reclamo.setDescripcion(descripcion);
		reclamo.setVehiculo(vehiculo);
		reclamo.setFechaCreacion(new Date());
		
		reclamoRepository.save(reclamo);
	}
	
	@Transactional(value = "movilTransactionManager", readOnly = true)
	@Override
	public List<ReclamoDto> getReclamosFrecuentes() {
		List<ReclamoDto> reclamosFrecuentesObject = new ArrayList<ReclamoDto>();
		List<ReclamoFrecuente> reclamosFrecuentes = reclamofrecuenteRepository.findAll();
		
		if (reclamosFrecuentes != null)
			for (int i=0 ; i<reclamosFrecuentes.size() ; i++){
				ReclamoDto reclamoDtoTmp = new ReclamoDto();
				BeanUtils.copyProperties(reclamosFrecuentes.get(i), reclamoDtoTmp);
				reclamosFrecuentesObject.add(reclamoDtoTmp);	
			}
		else return null;
		
		return reclamosFrecuentesObject;
	}
}
