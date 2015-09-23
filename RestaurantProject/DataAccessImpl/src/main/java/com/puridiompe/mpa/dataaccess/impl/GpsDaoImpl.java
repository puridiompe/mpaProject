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
import com.puridiompe.mpa.sistran.domain.persistence.Gps;
import com.puridiompe.mpa.sistran.domain.persistence.GpsInspector;
import com.puridiompe.mpa.sistran.domain.persistence.Usuario;
import com.puridiompe.mpa.sistran.repository.persistence.GpsInspectorRepository;
import com.puridiompe.mpa.sistran.repository.persistence.GpsRepository;
import com.puridiompe.mpa.sistran.repository.persistence.UsuarioRepository;
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

	@Transactional(value = "sistranTransactionManager")
	@Override
	public GpsDto addGps(GpsDto gps) {

		Gps gpsToSave = new Gps();

		if (gps != null) {

			BeanUtils.copyProperties(gps, gpsToSave);

			gpsToSave.setDate(new Date());
			gps.setDate(new Datetime(gpsToSave.getDate()));

			gpsRepository.save(gpsToSave);
			
			gps.setOfflineTime(null);
			
			return gps;
			
		} else {
			
			return null;
		}

	}
	
	@Transactional(value = "sistranTransactionManager")
	@Override
	public GpsDto addBatchGps(List<GpsDto> gps) {				

		if (gps != null) {	
			
			Object gpsInspector = gpsInspectorRepository.findLastByImei(gps.get(0).getImei());
			
            Date lastOnlineDatetime  = new Date();
            
            if(gpsInspector != null){
            	
                lastOnlineDatetime = gpsInspectorRepository.findLastByImei(gps.get(0).getImei()).getDate();
            }
			
			GpsDto lastSavedGps = new GpsDto();
			
			if(lastOnlineDatetime == null){
				
				return null;
				
			}else{				
						
				for(int i = 0; i < gps.size(); i++){
					
					Gps gpsToSave = new Gps();
				
					GpsDto listTmp = gps.get(i);
				
					BeanUtils.copyProperties(listTmp, gpsToSave);
					
	//				long tmpLong = lastOnlineDatetime.getTime() + (long)listTmp.getMinOffline();
					
					Date tmpToInsert = new Date();
					
					tmpToInsert.setTime(lastOnlineDatetime.getTime() + listTmp.getOfflineTime());
					
					gpsToSave.setDate(tmpToInsert);
					
					gpsRepository.save(gpsToSave);
					
					if(i == gps.size()-1){						
						
						BeanUtils.copyProperties(gpsToSave, lastSavedGps);
						lastSavedGps.setOfflineTime(null);
						lastSavedGps.setIdGps(null);
						lastSavedGps.setDate(new Datetime(tmpToInsert));
						
					}
					
				}	
			}

			return lastSavedGps;
			
		} else {
			
			return null;
		}

	}

	@Transactional(value = "sistranTransactionManager", readOnly = true)
	@Override
	public GpsDto getLastGpsByImei(String imei) {

		GpsDto gpsObject = new GpsDto();

		List<Gps> gps = gpsRepository.findLastByImei(imei);

		if (gps != null) {

			Usuario usuario = new Usuario();

			UsuarioDto usuarioObject = new UsuarioDto();

			usuario = usuarioRepository.findByIdUsuario(gps.get(0).getUsuarioId());

			BeanUtils.copyProperties(usuario, usuarioObject);

			BeanUtils.copyProperties(gps.get(0), gpsObject);

		} else {
			return null;
		}

		return gpsObject;
	}

	@Transactional(value = "sistranTransactionManager", readOnly = true)
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

				usuario = usuarioRepository.findByIdUsuario(gps.get(i).getUsuarioId());

				BeanUtils.copyProperties(usuario, usuarioObject);

				gpsObject.add(gpsDtoTmp);
			}

		} else {
			return null;
		}

		return gpsObject;
	}

	@Transactional(value = "sistranTransanctionManager", readOnly = true)
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

	@Transactional(value = "sistranTransanctionManager", readOnly = true)
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