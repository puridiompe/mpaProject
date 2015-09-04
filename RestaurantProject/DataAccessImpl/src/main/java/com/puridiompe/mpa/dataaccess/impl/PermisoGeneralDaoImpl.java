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
		
		PermisoGeneralDto permisoGeneralObject = new PermisoGeneralDto();
		
		PermisoOperacionEspecialDto permisoEspecialObject = new PermisoOperacionEspecialDto();
		PermisoOperacionEscolarDto permisoEscolarObject = new PermisoOperacionEscolarDto();
		PermisoOperacionTurismoDto permisoTurismoObject = new PermisoOperacionTurismoDto();
		
		Flota flota = flotaRepository.findByVehiculo(placa);
		if(flota != null){
			BeanUtils.copyProperties(flota, flotaObject);
			List<PermisoOperacionEspecial> permisoEspecial = permisoEspecialRepository.findByFlota(flota.getId());
			if(permisoEspecial != null){
				
				BeanUtils.copyProperties(permisoEspecial.get(0), permisoEspecialObject);
				permisoGeneralObject.setPermisoEspecial(permisoEspecialObject);
				permisoGeneralObject.setVehiculo(placa);
				permisoGeneralObject.getFechaEmision().add(permisoEspecial.get(0).getFechaEmision());
				permisoGeneralObject.getFechaVencimiento().add(permisoEspecial.get(0).getFechaVencimiento());
				permisoGeneralObject.getObservacion().add(permisoEspecial.get(0).getObservacion());
				permisoGeneralObject.getFechaEmision().add(permisoEspecial.get(0).getFechaEmision());
				permisoGeneralObject.getNumeroExpediente().add(permisoEspecial.get(0).getNumeroExpediente());
				permisoGeneralObject.getFechaExpediente().add(permisoEspecial.get(0).getFechaExpiracion());
				permisoGeneralObject.getTipoPermiso().add("SETARE"); // traer de la base de datos
				
			}
		}
		
		
		PermisoOperacionEscolar permisoEscolar = permisoEscolarRepository.findByVehiculo(placa);
		PermisoOperacionTurismo permisoTurismo = permisoTurismoRepository.findByVehiculo(placa);
		
		if(permisoEscolar != null){
			BeanUtils.copyProperties(permisoEscolar, permisoEscolarObject);
			permisoGeneralObject.setPermisoEscolar(permisoEscolarObject);
			permisoGeneralObject.setVehiculo(placa);
			permisoGeneralObject.getFechaEmision().add(permisoEscolar.getFechaEmision());
			permisoGeneralObject.getFechaVencimiento().add(permisoEscolar.getFechaVencimiento());
			permisoGeneralObject.getObservacion().add(permisoEscolar.getObservacion());
			permisoGeneralObject.getFechaEmision().add(permisoEscolar.getFechaEmision());
			permisoGeneralObject.getNumeroExpediente().add(permisoEscolar.getNumeroExpediente());
			permisoGeneralObject.getFechaExpediente().add(permisoEscolar.getFechaExpiracion());
			permisoGeneralObject.getTipoPermiso().add("Permiso para transporte Escolar"); // traer de la base de datos
		}
		
		if(permisoTurismo != null){
			BeanUtils.copyProperties(permisoTurismo, permisoTurismoObject);
			permisoGeneralObject.setPermisoTurismo(permisoTurismoObject);
			permisoGeneralObject.setVehiculo(placa);
			permisoGeneralObject.getFechaEmision().add(permisoTurismo.getFechaEmision());
			permisoGeneralObject.getFechaVencimiento().add(permisoTurismo.getFechaVencimiento());
			permisoGeneralObject.getObservacion().add(permisoTurismo.getObservacion());
			permisoGeneralObject.getFechaEmision().add(permisoTurismo.getFechaEmision());
			permisoGeneralObject.getNumeroExpediente().add(permisoTurismo.getNumeroExpediente());
			permisoGeneralObject.getFechaExpediente().add(permisoTurismo.getFechaExpiracion());
			permisoGeneralObject.getTipoPermiso().add("Permiso para transporte Turismo"); // traer de la base de datos
		}
		
		if(permisoGeneralObject != null)
			return permisoGeneralObject;
		else
			return null;
		
	}

}
