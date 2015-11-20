package com.puridiompe.mpa.movil.repository.persistence.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.puridiompe.mpa.movil.domain.persistence.ReclamoCiudadano;
import com.puridiompe.mpa.movil.repository.persistence.ReclamoCiudadanoRepository;

@Repository
public class ReclamoCiudadanoRepositoryImpl implements ReclamoCiudadanoRepository {

	@PersistenceContext(unitName="movilEntityManagerFactory")
	private EntityManager entityManager;
	
	@Override
    public List<ReclamoCiudadano> findByEstado(String estado, Pageable pageable){
    	//@Query("select new com.puridiompe.mpa.movil.domain.persistence.ReclamoCiudadano(r.idReclamo, r.dni, r.descripcion, r.vehiculo, r.imei, r.numRec, r.fecCre, r.estado, c.apellidoPaterno, c.apellidoMaterno, c.nombres, c.email, c.estado) from  Reclamo r, Ciudadano c where r.dni = c.dni and r.estado != ?1 order by r.idReclamo desc ")
		
    	 
    	StringBuilder sb = new StringBuilder(); 
    	List<ReclamoCiudadano> reclamoCiudadano = entityManager.createQuery("select new com.puridiompe.mpa.movil.domain.persistence.ReclamoCiudadano(r.idReclamo, r.dni, r.descripcion, r.vehiculo, r.imei, r.numRec, r.fecCre, r.estado, c.apellidoPaterno, c.apellidoMaterno, c.nombres, c.email, c.estado) from  Reclamo r, Ciudadano c where r.dni = c.dni and r.estado != ?1 order by r.idReclamo desc ", ReclamoCiudadano.class).setParameter(1, estado).setFirstResult(pageable.getPageNumber()*pageable.getPageSize()).setMaxResults(pageable.getPageSize()).getResultList();
    	
    	return reclamoCiudadano;
	}
}
