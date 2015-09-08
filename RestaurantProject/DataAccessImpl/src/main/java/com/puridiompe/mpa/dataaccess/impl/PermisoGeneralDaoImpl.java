package com.puridiompe.mpa.dataaccess.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.puridiompe.mpa.business.general.dto.FlotaDto;
import com.puridiompe.mpa.business.general.dto.PermisoGeneralDto;
import com.puridiompe.mpa.business.general.dto.PermisoOperacionEscolarDto;
import com.puridiompe.mpa.business.general.dto.PermisoOperacionEspecialDto;
import com.puridiompe.mpa.business.general.dto.PermisoOperacionTurismoDto;
import com.puridiompe.mpa.business.general.dto.PermisosDto;
import com.puridiompe.mpa.business.general.dto.PropietarioDto;
import com.puridiompe.mpa.dataaccess.PermisoGeneralDao;
import com.puridiompe.mpa.sistran.domain.persistence.Flota;
import com.puridiompe.mpa.sistran.domain.persistence.PermisoOperacionEscolar;
import com.puridiompe.mpa.sistran.domain.persistence.PermisoOperacionEspecial;
import com.puridiompe.mpa.sistran.domain.persistence.PermisoOperacionTurismo;
import com.puridiompe.mpa.sistran.domain.persistence.PropietarioVehiculo;
import com.puridiompe.mpa.sistran.repository.persistence.FlotaRepository;
import com.puridiompe.mpa.sistran.repository.persistence.PermisoOperacionEscolarRepository;
import com.puridiompe.mpa.sistran.repository.persistence.PermisoOperacionEspecialRepository;
import com.puridiompe.mpa.sistran.repository.persistence.PermisoOperacionTurismoRepository;

@Component
public class PermisoGeneralDaoImpl implements PermisoGeneralDao {

	@Autowired
	private PermisoOperacionEspecialRepository permisoEspecialRepository;
	
	@Autowired
	private PermisoOperacionEscolarRepository permisoEscolarRepository;
	
	@Autowired
	private PermisoOperacionTurismoRepository permisoTurismoRepository;
	
	@Autowired
	private FlotaRepository flotaRepository;
	
	@Transactional(value = "sistranTransactionManager", readOnly = true)
	@Override
	public PermisoGeneralDto getPermisoGeneralByPlaca(String placa) {
		
		FlotaDto flotaObject = new FlotaDto();
		
		PermisosDto permisosObject = new PermisosDto();
		PermisoGeneralDto permisoGeneralObject = new PermisoGeneralDto();
		
		PermisoOperacionEspecialDto permisoEspecialObject = new PermisoOperacionEspecialDto();
		PermisoOperacionEscolarDto permisoEscolarObject = new PermisoOperacionEscolarDto();
		PermisoOperacionTurismoDto permisoTurismoObject = new PermisoOperacionTurismoDto();
		
		//consulta a la DB flota
		Flota flota = flotaRepository.findByVehiculo(placa);
		
		if(flota != null){
			BeanUtils.copyProperties(flota, flotaObject);
			List<PermisoOperacionEspecial> permisoEspecial = permisoEspecialRepository.findByFlota(flota.getId());
			if(permisoEspecial != null){
				permisosObject = new PermisosDto();
				BeanUtils.copyProperties(permisoEspecial.get(0), permisoEspecialObject);
					
				permisosObject.setVehiculo(placa);
				permisosObject.setFechaEmision(permisoEspecial.get(0).getFechaEmision());
				permisosObject.setFechaVencimiento(permisoEspecial.get(0).getFechaVencimiento());
				permisosObject.setObservacion(permisoEspecial.get(0).getObservacion());
				permisosObject.setFechaEmision(permisoEspecial.get(0).getFechaEmision());
				permisosObject.setNumeroExpediente(permisoEspecial.get(0).getNumeroExpediente());
				permisosObject.setFechaExpediente(permisoEspecial.get(0).getFechaExpiracion());
				permisosObject.setTipoPermiso("SETARE"); // traer de la base de datos
				
				permisoGeneralObject.getListPermiso().add(permisosObject);
				permisoGeneralObject.setVehiculo(placa);
			}
		}
		
		
		PermisoOperacionEscolar permisoEscolar = permisoEscolarRepository.findByVehiculo(placa);
		PermisoOperacionTurismo permisoTurismo = permisoTurismoRepository.findByVehiculo(placa);
		
		if(permisoEscolar != null){
			permisosObject = new PermisosDto();
			BeanUtils.copyProperties(permisoEscolar, permisoEscolarObject);
			
			permisosObject.setVehiculo(placa);
			permisosObject.setFechaEmision(permisoEscolar.getFechaEmision());
			permisosObject.setFechaVencimiento(permisoEscolar.getFechaVencimiento());
			permisosObject.setObservacion(permisoEscolar.getObservacion());
			permisosObject.setFechaEmision(permisoEscolar.getFechaEmision());
			permisosObject.setNumeroExpediente(permisoEscolar.getNumeroExpediente());
			permisosObject.setFechaExpediente(permisoEscolar.getFechaExpiracion());
			permisosObject.setTipoPermiso("Permiso para transporte Escolar"); // traer de la base de datos
			
			permisoGeneralObject.getListPermiso().add(permisosObject);
			permisoGeneralObject.setVehiculo(placa);
		}
		
		if(permisoTurismo != null){
			permisosObject = new PermisosDto();
			BeanUtils.copyProperties(permisoTurismo, permisoTurismoObject);
			
			permisosObject.setVehiculo(placa);
			permisosObject.setFechaEmision(permisoTurismo.getFechaEmision());
			permisosObject.setFechaVencimiento(permisoTurismo.getFechaVencimiento());
			permisosObject.setObservacion(permisoTurismo.getObservacion());
			permisosObject.setFechaEmision(permisoTurismo.getFechaEmision());
			permisosObject.setNumeroExpediente(permisoTurismo.getNumeroExpediente());
			permisosObject.setFechaExpediente(permisoTurismo.getFechaExpiracion());
			permisosObject.setTipoPermiso("Permiso para transporte Turismo"); // traer de la base de datos
			
			permisoGeneralObject.getListPermiso().add(permisosObject);
			permisoGeneralObject.setVehiculo(placa);
		}
		
		if(permisoGeneralObject != null)
			return permisoGeneralObject;
		else
			return null;
		
	}

}
