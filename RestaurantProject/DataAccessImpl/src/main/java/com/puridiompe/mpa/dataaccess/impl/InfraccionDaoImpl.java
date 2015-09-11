/**
 * 
 */
package com.puridiompe.mpa.dataaccess.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.puridiompe.mpa.business.general.dto.InfraccionDto;
import com.puridiompe.mpa.dataaccess.InfraccionDao;
import com.puridiompe.mpa.sistran.domain.persistence.Infraccion;
import com.puridiompe.mpa.sistran.repository.persistence.InfraccionRepository;

/**
 * @author Lucho
 *
 */

@Component
public class InfraccionDaoImpl implements InfraccionDao{
	
	@Autowired
	private InfraccionRepository infraccionRepository;

	@Transactional(value = "sistranTransactionManager", readOnly = true)
	@Override
	public InfraccionDto getInfraccionByCodigo(String codigo) {
		
		InfraccionDto infraccionObject = new InfraccionDto();
		
		Infraccion infraccion = infraccionRepository.findByCodigo(codigo);
		
		if(infraccion != null){
			
			BeanUtils.copyProperties(infraccion, infraccionObject);
			
			
		}else{
			return null;
		}
		
		return infraccionObject;
	}

	@Transactional(value = "sistranTransanctionManager", readOnly = true)
	@Override
	public InfraccionDto getInfraccionByDescripcion(String descripcion) {
		
		InfraccionDto infraccionObject = new InfraccionDto();
		
		Infraccion infraccion = infraccionRepository.findByDescripcion(descripcion);
		
		if(infraccion != null){
			
			BeanUtils.copyProperties(infraccion, infraccionObject);
			
		}else{
			return null;
		}		
		
		return infraccionObject;
	}
	
	@Transactional(value = "sistranTransanctionManager", readOnly = true)
	@Override
	public List<InfraccionDto> findAll() {
		
		List<InfraccionDto> infraccionObject = new ArrayList<InfraccionDto>();
		
		List<Infraccion> infracciones = infraccionRepository.findAll();
		
		if(infracciones != null){
			
			BeanUtils.copyProperties(infracciones, infraccionObject);
			
		}else{
			return null;
		}		
		
		return infraccionObject;
	}
	

}