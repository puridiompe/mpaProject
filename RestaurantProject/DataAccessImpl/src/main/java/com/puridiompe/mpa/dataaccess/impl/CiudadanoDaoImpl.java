package com.puridiompe.mpa.dataaccess.impl;

import java.util.Date;
import java.util.List;

import org.aspectj.weaver.patterns.IfPointcut.IfFalsePointcut;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.puridiompe.mpa.business.general.dto.CiudadanoDto;
import com.puridiompe.mpa.dataaccess.CiudadanoDao;
import com.puridiompe.mpa.movil.domain.persistence.Ciudadano;
import com.puridiompe.mpa.movil.repository.persistence.CiudadanoRepository;

@Component
public class CiudadanoDaoImpl implements CiudadanoDao {

	@Autowired
	private CiudadanoRepository ciudadanoRepository;
	
	@Transactional(value = "movilTransactionManager", readOnly = true)
	@Override
	public CiudadanoDto getCiudadano(Integer dni){
		
		CiudadanoDto objectCiudadano = new CiudadanoDto();
		
//		Ciudadano ciudadano = ciudadanoRepository.findByImei(imei).get(0);
		Ciudadano ciudadano = ciudadanoRepository.findByDni(dni);
		
		
		
		if(ciudadano != null){
			BeanUtils.copyProperties(ciudadano, objectCiudadano);
			
		}else{
			return null;
		}
		
		return objectCiudadano;
	}
	
	@Transactional(value = "movilTransactionManager")
	@Override
	public void setCiudadano(Integer dni, String apellidoPaterno, String apellidoMaterno, String nombres,String email) {
		
		Ciudadano ciudadano = new Ciudadano();
//		List<Ciudadano> lista = ciudadanoRepository.findByImei(imei);
//		Ciudadano dniExists = ciudadanoRepository.findByDni(dni);	
//		Ciudadano imeiExists = null;
		
//		if(lista.isEmpty() || lista.size() == 0){
//			imeiExists = null;			
//		}else{
//			imeiExists = lista.get(0);
//		}
		Date fechaActual = new Date();
		ciudadano.setDni(dni);
		ciudadano.setApellidoPaterno(apellidoPaterno);
		ciudadano.setApellidoMaterno(apellidoMaterno);
		ciudadano.setNombres(nombres);
		ciudadano.setEmail(email);			
		ciudadano.setFechaCreacion(fechaActual);
		ciudadano.setFechaModificacion(fechaActual);			
//		if(isLast){
//			ciudadano.setImei(imei);				
//		}else{
//			ciudadano.setImei("");
//		}
		ciudadanoRepository.save(ciudadano);
		
//		
//		if(dniExists == null){
//			Date fechaActual = new Date();
//			ciudadano.setDni(dni);
//			ciudadano.setApellidoPaterno(apellidoPaterno);
//			ciudadano.setApellidoMaterno(apellidoMaterno);
//			ciudadano.setNombres(nombres);
//			ciudadano.setEmail(email);			
//			ciudadano.setFechaCreacion(fechaActual);
//			ciudadano.setFechaModificacion(fechaActual);			
//			if(isLast){
//				ciudadano.setImei(imei);				
//			}else{
//				ciudadano.setImei("");
//			}
//			ciudadanoRepository.save(ciudadano);
//		}else{
//			ciudadanoRepository.save(ciudadano);
			
//			Date fechaActual = new Date();
//			Date fechaOffline = new Date(fechaActual.getTime() + offlineTime);
//			
//			if(fechaOffline.getTime() > fechaActual.getTime()){
//				if(isLast){
//					ciudadanoRepository.updateByDni(dni, apellidoPaterno, apellidoMaterno, nombres,
//							email, fechaOffline, imei);	
//				}else{
//					imei = "";
//					ciudadanoRepository.updateByDni(dni, apellidoPaterno, apellidoMaterno, nombres,
//							email, fechaOffline, imei);
//				}
//			}else{
//				if(isLast){
//					ciudadanoRepository.updateByDni(dni, apellidoPaterno, apellidoMaterno, nombres,
//							email, fechaActual, imei);	
//				}else{
//					imei = "";
//					ciudadanoRepository.updateByDni(dni, apellidoPaterno, apellidoMaterno, nombres,
//							email, fechaActual, imei);
//				}
//				
//			}
//		}
	}

}
