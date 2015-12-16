package com.puridiompe.mpa.movil.repository.persistence.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.puridiompe.mpa.movil.domain.persistence.Acta;
import com.puridiompe.mpa.movil.repository.persistence.ActaInspectorRepository;

@Repository
public class ActaInspectorRepositoryImpl implements ActaInspectorRepository {
	
	@PersistenceContext(unitName="movilEntityManagerFactory")
	private EntityManager entityManager;
	
	//@Query("select count (*) from Acta")
	public Integer findAllTotalActas(String query){
		
		StringBuilder sb = new StringBuilder();
		sb.append("select count (*) from Acta a");
		if(!query.isEmpty()){
    		sb.append(" where ");
    		sb.append(query);
    	}
		Integer totalActas = new Integer(entityManager.createQuery(sb.toString()).getSingleResult().toString());
		return totalActas;
	}
	
	//@Query("from Acta a order by a.idActa DESC")
	public List<Acta> findAllActas(Pageable pageable,String query){
    	StringBuilder sb = new StringBuilder();
    	sb.append("from Acta a");
    	if(!query.isEmpty()){
    		sb.append(" where ");
    		sb.append(query);    		
    	}
    	sb.append(" order by a.idActa DESC ");
    	List<Acta> actas  = entityManager.createQuery(sb.toString(), Acta.class).setFirstResult(pageable.getPageNumber()*pageable.getPageSize()).setMaxResults(pageable.getPageSize()).getResultList();
    	
    	return actas;
	}
	
	


}
