package com.puridiompe.mpa.movil.repository.persistence.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

//import com.puridiompe.mpa.movil.domain.persistence.Acta;
import com.puridiompe.mpa.movil.domain.persistence.ActaInspector;
import com.puridiompe.mpa.movil.repository.persistence.ActaInspectorRepository;

@Repository
public class ActaInspectorRepositoryImpl implements ActaInspectorRepository {
	
	@PersistenceContext(unitName="movilEntityManagerFactory")
	private EntityManager entityManager;
	
	//@Query("select count (*) from Acta")
	@Override
	public Integer findAllTotalActas(String query){
		
		StringBuilder sb = new StringBuilder();
		sb.append("select count (*) from Acta a,Usuario u where u.username = a.username");
		if(!query.isEmpty()){
    		sb.append(" and ");
    		sb.append(query);
    	}
		Integer totalActas = new Integer(entityManager.createQuery(sb.toString()).getSingleResult().toString());
		return totalActas;
	}
	
	//@Query("from Acta a order by a.idActa DESC")
	@Override
	public List<ActaInspector> findAllActas(Pageable pageable,String query){
		
    	StringBuilder sb = new StringBuilder();
    	sb.append("select new com.puridiompe.mpa.movil.domain.persistence.ActaInspector(a.idActa, a.numAct, a.username, a.vehiculo, a.descripcion, a.fecCre, u.nombres, u.apellidoPaterno, u.apellidoMaterno) from Acta a,Usuario u where a.username = u.username ");
    	if(!query.isEmpty()){
    		sb.append(" and ");
    		sb.append(query);    		
    	}
    	sb.append(" order by a.idActa DESC ");
    	List<ActaInspector> actas  = entityManager.createQuery(sb.toString(), ActaInspector.class).setFirstResult(pageable.getPageNumber()*pageable.getPageSize()).setMaxResults(pageable.getPageSize()).getResultList();
    	
    	return actas;
	}
	
	/* AQUI */ 
//	//@Query("select count (*) from Acta")
//	public Integer findAllTotalActas(String query){
//		
//		StringBuilder sb = new StringBuilder();
//		sb.append("select count (*) from Acta a,Usuario u where u.username = a.username");
//		if(!query.isEmpty()){
//    		sb.append(" and ");
//    		sb.append(query);
//    	}
//		Integer totalActas = new Integer(entityManager.createQuery(sb.toString()).getSingleResult().toString());
//		return totalActas;
//	}
//	
//	//@Query("from Acta a order by a.idActa DESC")
//	public List<Acta> findAllActas(Pageable pageable,String query){
//    	StringBuilder sb = new StringBuilder();
//    	sb.append("select a from Acta a,Usuario u where u.username = a.username");
//    	if(!query.isEmpty()){
//    		sb.append(" and ");
//    		sb.append(query);    		
//    	}
//    	sb.append(" order by a.idActa DESC ");
//    	List<Acta> actas  = entityManager.createQuery(sb.toString(), Acta.class).setFirstResult(pageable.getPageNumber()*pageable.getPageSize()).setMaxResults(pageable.getPageSize()).getResultList();
//    	
//    	return actas;
//	}

	/*AQUI */
//	
//	public Integer findAllTotalActas(String query){
//		
//		StringBuilder sb = new StringBuilder();
//		sb.append("select count (*) from Acta a");
//		if(!query.isEmpty()){
//    		sb.append(" where ");
//    		sb.append(query);
//    	}
//		Integer totalActas = new Integer(entityManager.createQuery(sb.toString()).getSingleResult().toString());
//		return totalActas;
//	}
//	
//	//@Query("from Acta a order by a.idActa DESC")
//	public List<Acta> findAllActas(Pageable pageable,String query){
//    	StringBuilder sb = new StringBuilder();
//    	sb.append("from Acta a");
//    	if(!query.isEmpty()){
//    		sb.append(" where ");
//    		sb.append(query);    		
//    	}
//    	sb.append(" order by a.idActa DESC ");
//    	List<Acta> actas  = entityManager.createQuery(sb.toString(), Acta.class).setFirstResult(pageable.getPageNumber()*pageable.getPageSize()).setMaxResults(pageable.getPageSize()).getResultList();
//    	
//    	return actas;
//	}


}
