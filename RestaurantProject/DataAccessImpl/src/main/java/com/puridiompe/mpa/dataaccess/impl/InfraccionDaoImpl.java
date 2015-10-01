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
import com.puridiompe.mpa.movil.domain.persistence.Infraccion;
import com.puridiompe.mpa.movil.repository.persistence.InfraccionRepository;

/**
 * @author Lucho
 *
 */

@Component
public class InfraccionDaoImpl implements InfraccionDao{
	
	@Autowired
	private InfraccionRepository infraccionRepository;

	@Transactional(value = "movilTransactionManager", readOnly = true)
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

	@Transactional(value = "movilTransactionManager", readOnly = true)
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
	
	@Transactional(value = "movilTransactionManager", readOnly = true)
	@Override
	public List<InfraccionDto> findAll() {
		
		List<InfraccionDto> infraccionesObject = new ArrayList<InfraccionDto>();
		
		List<Infraccion> infracciones = infraccionRepository.findAll();
		
		if(infracciones != null){		
			
			for(int i = 0; i < infracciones.size(); i++ ){
				
				InfraccionDto infraccionDtoTmp = new InfraccionDto();
				
				BeanUtils.copyProperties(infracciones.get(i), infraccionDtoTmp);
				
				infraccionesObject.add(infraccionDtoTmp);				
			}			
			
		}else{
			return null;
		}		
		
		return infraccionesObject;
	}
	

}