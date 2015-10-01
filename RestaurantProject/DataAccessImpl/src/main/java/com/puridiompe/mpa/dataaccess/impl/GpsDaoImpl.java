/**
 * 
 */
package com.puridiompe.mpa.dataaccess.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.puridiompe.mpa.business.general.dto.GpsDto;
import com.puridiompe.mpa.business.general.dto.GpsInspectorDto;
import com.puridiompe.mpa.business.general.dto.UsuarioDto;
import com.puridiompe.mpa.common.security.SystemRole;
import com.puridiompe.mpa.common.security.SystemRole;
import com.puridiompe.mpa.common.type.Datetime;
import com.puridiompe.mpa.dataaccess.GpsDao;
import com.puridiompe.mpa.movil.domain.persistence.Gps;
import com.puridiompe.mpa.movil.domain.persistence.GpsInspector;
import com.puridiompe.mpa.movil.domain.persistence.Usuario;
import com.puridiompe.mpa.movil.repository.persistence.GpsInspectorRepository;
import com.puridiompe.mpa.movil.repository.persistence.GpsRepository;
import com.puridiompe.mpa.movil.repository.persistence.UsuarioRepository;
/**
 * @author Lucho
 *
 */

@Component
public class GpsDaoImpl implements GpsDao {

	@Autowired
	private GpsRepository gpsRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private GpsInspectorRepository gpsInspectorRepository;

	@Transactional(value = "movilTransactionManager")
	@Override
	public GpsDto addGps(GpsDto gps, Long timetoSave) {

		Gps gpsToSave = new Gps();			

		BeanUtils.copyProperties(gps, gpsToSave);
		
		Date dateToSave = new Date();
		dateToSave.setTime(timetoSave);
		
		gpsToSave.setDate(dateToSave);
		gps.setDate(new Datetime(gpsToSave.getDate()));

		gpsRepository.save(gpsToSave);
			
		gps.setOfflineTime(null);
			
		return gps;
	}
	
	@Transactional(value = "movilTransactionManager", readOnly = true)
	@Override
	public GpsInspectorDto getLastByUsername(String username) {
		
		GpsInspectorDto gpsInspectorObject = new GpsInspectorDto();
		GpsInspector gpsInspector = gpsInspectorRepository.findLastByUsername(username);
		
		if(gpsInspector != null){
			BeanUtils.copyProperties(gpsInspector, gpsInspectorObject);
			gpsInspectorObject.setDate(new Datetime(gpsInspector.getDate()));
		} else {
			return null;
		}
		
		return gpsInspectorObject;
	}
	
	@Transactional(value = "movilTransactionManager")
	@Override
	public GpsDto addBatchGps(String username, List<GpsDto> gps, Long lastTime, Integer caseNumber) {		
		
		Integer arraySize = gps.size();
		
		
		if(caseNumber == 1){
			
			for(int i = 0; i < arraySize; i++){
				
				Gps gpsToSave = new Gps();				
				GpsDto listTmp = gps.get(i);				
				BeanUtils.copyProperties(listTmp, gpsToSave);					
				Date tmpToInsert = new Date();
					
				tmpToInsert.setTime(lastTime + listTmp.getOfflineTime());					
				gpsToSave.setDate(tmpToInsert);
					
				gpsRepository.save(gpsToSave);
					
				if(i == arraySize-1){
						
					GpsDto lastSavedGps = new GpsDto();
						
					BeanUtils.copyProperties(gpsToSave, lastSavedGps);
					lastSavedGps.setOfflineTime(null);
					lastSavedGps.setIdGps(null);
					lastSavedGps.setDate(new Datetime(tmpToInsert));
						
					return lastSavedGps;
						
				}
			}
		}if(caseNumber == 2){
			
			for(int i = 0; i < arraySize-1; i++){
				
				Gps gpsToSave = new Gps();				
				GpsDto listTmp = gps.get(i);				
				BeanUtils.copyProperties(listTmp, gpsToSave);					
				Date tmpToInsert = new Date();
					
				tmpToInsert.setTime(lastTime + listTmp.getOfflineTime());					
				gpsToSave.setDate(tmpToInsert);
					
				gpsRepository.save(gpsToSave);					
			}
			return null;			
		}
		
		
		
		
		
		
		
//		if(caseNumber == 1){
//			
//			for(int i = 0; i < arraySize; i++){
//				
//				Gps gpsToSave = new Gps();				
//				GpsDto listTmp = gps.get(i);				
//				BeanUtils.copyProperties(listTmp, gpsToSave);					
//				Date tmpToInsert = new Date();
//					
//				tmpToInsert.setTime(lastDate.getTime() + listTmp.getOfflineTime());					
//				gpsToSave.setDate(tmpToInsert);
//					
//				gpsRepository.save(gpsToSave);
//					
//				if(i == arraySize-1){
//						
//					GpsDto lastSavedGps = new GpsDto();
//						
//					BeanUtils.copyProperties(gpsToSave, lastSavedGps);
//					lastSavedGps.setOfflineTime(null);
//					lastSavedGps.setIdGps(null);
//					lastSavedGps.setDate(new Datetime(tmpToInsert));
//						
//					return lastSavedGps;
//						
//				}
//			}
//		}if(caseNumber == 2){
//			
//			for(int i = 0; i < arraySize-1; i++){
//				
//				Gps gpsToSave = new Gps();				
//				GpsDto listTmp = gps.get(i);				
//				BeanUtils.copyProperties(listTmp, gpsToSave);					
//				Date tmpToInsert = new Date();
//					
//				tmpToInsert.setTime(lastDate.getTime() + listTmp.getOfflineTime());					
//				gpsToSave.setDate(tmpToInsert);
//					
//				gpsRepository.save(gpsToSave);
//					
//			}
//			Gps lastGpsToSave = new Gps();
//			GpsDto lastSavedGps = new GpsDto();
//			Date tmpToInsert = new Date();
//				
//			lastSavedGps = gps.get(arraySize-1);
//			BeanUtils.copyProperties(lastSavedGps, lastGpsToSave);
//			tmpToInsert.setTime(lastDate.getTime() + (arraySize * gps.get(0).getOfflineTime()));
//			lastGpsToSave.setDate(tmpToInsert);
//			
//			gpsRepository.save(lastGpsToSave);					
//			
//			lastSavedGps.setOfflineTime(null);
//			lastSavedGps.setIdGps(null);
//			lastSavedGps.setDate(new Datetime(tmpToInsert));
//				
//			return lastSavedGps;
//			
//		}if(caseNumber == 3){
//			
//			Long minusTime = gps.get(0).getOfflineTime();
//			Long initTime = new Date().getTime();
//			
//			for(int i = 0; i < arraySize; i++){
//					
//				Gps gpsToSave = new Gps();				
//				GpsDto listTmp = gps.get(i);				
//				BeanUtils.copyProperties(listTmp, gpsToSave);					
//				Date tmpToInsert = new Date();
//					
//				tmpToInsert.setTime(initTime + listTmp.getOfflineTime() - minusTime);					
//				gpsToSave.setDate(tmpToInsert);
//					
//				gpsRepository.save(gpsToSave);
//					
//				if(i == arraySize-1){
//						
//					GpsDto lastSavedGps = new GpsDto();
//						
//					BeanUtils.copyProperties(gpsToSave, lastSavedGps);
//					lastSavedGps.setOfflineTime(null);
//					lastSavedGps.setIdGps(null);
//					lastSavedGps.setDate(new Datetime(tmpToInsert));
//						
//					return lastSavedGps;
//						
//				}
//			}
//		}if(caseNumber == 4){
//			Long minusTime = gps.get(0).getOfflineTime();
//			Long initTime = new Date().getTime();
//				
//			for(int i = 0; i < arraySize-1; i++){
//					
//				Gps gpsToSave = new Gps();				
//				GpsDto listTmp = gps.get(i);				
//				BeanUtils.copyProperties(listTmp, gpsToSave);					
//				Date tmpToInsert = new Date();
//					
//				tmpToInsert.setTime(initTime + listTmp.getOfflineTime() - minusTime);					
//				gpsToSave.setDate(tmpToInsert);
//					
//				gpsRepository.save(gpsToSave);
//					
//			}
//			Gps lastGpsToSave = new Gps();
//			GpsDto lastSavedGps = new GpsDto();
//			Date tmpToInsert = new Date();
//				
//			lastSavedGps = gps.get(arraySize-1);
//			BeanUtils.copyProperties(lastSavedGps, lastGpsToSave);
//			tmpToInsert.setTime(initTime + (arraySize * gps.get(0).getOfflineTime()) - minusTime);
//			lastGpsToSave.setDate(tmpToInsert);
//			
//			gpsRepository.save(lastGpsToSave);					
//			
//			lastSavedGps.setOfflineTime(null);
//			lastSavedGps.setIdGps(null);
//			lastSavedGps.setDate(new Datetime(tmpToInsert));
//				
//		}
		
		return null;
	}

	@Transactional(value = "movilTransactionManager", readOnly = true)
	@Override
	public GpsDto getLastGpsByImei(String imei) {

		GpsDto gpsObject = new GpsDto();

		List<Gps> gps = gpsRepository.findLastByImei(imei);

		if (gps != null) {

			Usuario usuario = new Usuario();

			UsuarioDto usuarioObject = new UsuarioDto();

			//usuario = usuarioRepository.findByIdUsuario(gps.get(0).getUsuarioId());
			usuario = usuarioRepository.findByUsername(gps.get(0).getUsuarioId());

			BeanUtils.copyProperties(usuario, usuarioObject);

			BeanUtils.copyProperties(gps.get(0), gpsObject);

		} else {
			return null;
		}

		return gpsObject;
	}

	@Transactional(value = "movilTransactionManager", readOnly = true)
	@Override
	public List<GpsDto> getGpsByImei(String imei) {

		List<GpsDto> gpsObject = new ArrayList<GpsDto>();

		List<Gps> gps = gpsRepository.findByImei(imei);

		if (gps != null) {

			for (int i = 0; i < gps.size(); i++) {

				GpsDto gpsDtoTmp = new GpsDto();

				Usuario usuario = new Usuario();

				UsuarioDto usuarioObject = new UsuarioDto();

				BeanUtils.copyProperties(gps.get(i), gpsDtoTmp);

				//usuario = usuarioRepository.findByIdUsuario(gps.get(i).getUsuarioId());
				usuario = usuarioRepository.findByUsername(gps.get(i).getUsuarioId());

				BeanUtils.copyProperties(usuario, usuarioObject);

				gpsObject.add(gpsDtoTmp);
			}

		} else {
			return null;
		}

		return gpsObject;
	}

	@Transactional(value = "movilTransactionManager", readOnly = true)
	@Override
	public List<GpsDto> findAll() {

		List<GpsDto> gpsObject = new ArrayList<GpsDto>();

		List<Gps> gps = gpsRepository.findAll();

		if (gps != null) {

			for (int i = 0; i < gps.size(); i++) {

				GpsDto gpsDtoTmp = new GpsDto();

				BeanUtils.copyProperties(gps.get(i), gpsDtoTmp);

				gpsObject.add(gpsDtoTmp);
			}

		} else {
			return null;
		}

		return gpsObject;
	}

	@Transactional(value = "movilTransactionManager", readOnly = true)
	@Override
	public List<GpsInspectorDto> getLastPositions() {

		List<GpsInspectorDto> gpsInspectorObject = new ArrayList<GpsInspectorDto>();
		
		List<GpsInspector> gpsInspector = gpsInspectorRepository.findByRol(SystemRole.INSPECTOR.toString());
		
		if (gpsInspector != null) {

			for (int i = 0; i < gpsInspector.size(); i++) {

				GpsInspectorDto gpsInspectorDtoTmp = new GpsInspectorDto();

				GpsInspector gpsInspectortmp = gpsInspector.get(i);

				BeanUtils.copyProperties(gpsInspectortmp, gpsInspectorDtoTmp);

				gpsInspectorDtoTmp.setDate(new Datetime(gpsInspectortmp.getDate()));

				gpsInspectorObject.add(gpsInspectorDtoTmp);
			}
		} else {
			return null;
		}

		return gpsInspectorObject;
	}

}