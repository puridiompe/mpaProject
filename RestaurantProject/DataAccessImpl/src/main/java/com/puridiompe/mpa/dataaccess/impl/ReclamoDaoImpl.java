package com.puridiompe.mpa.dataaccess.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.puridiompe.mpa.dataaccess.ReclamoDao;
import com.puridiompe.mpa.movil.domain.persistence.Reclamo;
import com.puridiompe.mpa.movil.repository.persistence.ReclamoRepository;

@Component
public class ReclamoDaoImpl implements ReclamoDao {

	@Autowired
	private ReclamoRepository reclamoRepository;
	
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

}
