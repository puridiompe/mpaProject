/**
 * 
 */
package com.puridiompe.mpa.dataaccess.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.puridiompe.mpa.business.general.dto.PropietarioDto;
import com.puridiompe.mpa.business.general.dto.VehiculoDto;
import com.puridiompe.mpa.dataaccess.VehiculoDao;
import com.puridiompe.mpa.sistran.domain.persistence.PropietarioVehiculo;
import com.puridiompe.mpa.sistran.domain.persistence.Vehiculo;
import com.puridiompe.mpa.sistran.domain.persistence.VehiculoHistorial;
import com.puridiompe.mpa.sistran.repository.persistence.PropietarioVehiculoRepository;
import com.puridiompe.mpa.sistran.repository.persistence.VehiculoHistorialRepository;
import com.puridiompe.mpa.sistran.repository.persistence.VehiculoRepository;

/**
 * @author Johnny
 *
 */
@Component
public class VehiculoDaoImpl implements VehiculoDao {

	@Autowired
	private VehiculoRepository vehiculoRepository;
	
	@Autowired
	private VehiculoHistorialRepository vehiculoHistorialRepository;

	@Autowired
	private PropietarioVehiculoRepository propietarioVehiculoRepository;

	@Transactional(value = "sistranTransactionManager", readOnly = true)
	@Override
	public VehiculoDto getVehiculoByPlaca(String placa) {

		VehiculoDto vehiculoObject = new VehiculoDto();

		Vehiculo vehiculo = vehiculoRepository.findByPlaca(placa);

		if (vehiculo != null) {

			BeanUtils.copyProperties(vehiculo, vehiculoObject);

			List<PropietarioVehiculo> propietarios = propietarioVehiculoRepository
					.findByVehiculo(vehiculo.getIdPlaca());

			if (propietarios != null) {
				for (PropietarioVehiculo propietario : propietarios) {
					PropietarioDto propietarioObject = new PropietarioDto();

					BeanUtils.copyProperties(propietario, propietarioObject);

					vehiculoObject.getPropietarios().add(propietarioObject);
				}
			}
		} else {
			return null;
		}

		return vehiculoObject;
	}
	
	@Transactional(value = "sistranTransactionManager")
	@Override
	public Boolean setVehicleConsulted(String username, String placa, String imei) {
		
		Vehiculo vehiculo = vehiculoRepository.findByPlaca(placa);
		
		if(vehiculo != null){
			
			VehiculoHistorial vehiculoHistorial = new VehiculoHistorial();
			vehiculoHistorial.setVehiculo(vehiculo.getIdPlaca());
			vehiculoHistorial.setUsuario(username);
			vehiculoHistorial.setImei(imei);
			vehiculoHistorial.setFechaHora(new Date());
			vehiculoHistorialRepository.save(vehiculoHistorial);
			return true;
			
		}else{
			
			return false;
		}
	}

}
