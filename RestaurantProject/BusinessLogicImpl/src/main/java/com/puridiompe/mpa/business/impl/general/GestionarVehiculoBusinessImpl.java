/**
 * 
 */
package com.puridiompe.mpa.business.impl.general;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.puridiompe.mpa.business.exception.BusinessException;
import com.puridiompe.mpa.business.exception.VehiculoNotFoundException;
import com.puridiompe.mpa.business.general.GestionarVehiculoBusiness;
import com.puridiompe.mpa.business.general.dto.VehiculoDto;
import com.puridiompe.mpa.common.security.SecurityContextHelper;
import com.puridiompe.mpa.common.security.exception.SecurityException;
import com.puridiompe.mpa.dataaccess.VehiculoDao;

/**
 * @author Johnny
 *
 */

@Service
public class GestionarVehiculoBusinessImpl implements GestionarVehiculoBusiness {

	@Autowired
	private VehiculoDao vehiculoDao;

	@Override
	public VehiculoDto getVehiculo(String placa) throws BusinessException, SecurityException {

		String currentImei = SecurityContextHelper.getCurrentImei();
		String currentUsername = SecurityContextHelper.getCurrentUsername();

		VehiculoDto vehiculoDto = vehiculoDao.getVehiculoByPlaca(placa);

		if (vehiculoDto == null) {
			throw new VehiculoNotFoundException(
					"Vehículo no fue encontrado");
		}

		vehiculoDao.setVehicleConsulted(currentUsername, placa, currentImei);

		return vehiculoDto;
	}
}
