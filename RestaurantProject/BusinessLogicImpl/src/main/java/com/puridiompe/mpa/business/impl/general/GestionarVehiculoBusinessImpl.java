/**
 * 
 */
package com.puridiompe.mpa.business.impl.general;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.puridiompe.mpa.business.exception.BusinessException;
import com.puridiompe.mpa.business.exception.VehiculoNotFoundException;
import com.puridiompe.mpa.business.general.GestionarVehiculoBusiness;
import com.puridiompe.mpa.business.general.dto.VehiculoDto;
import com.puridiompe.mpa.dataaccess.VehiculoDao;
import com.puridiompe.mpa.rest.security.token.LoginAuthenticationToken;

/**
 * @author Johnny
 *
 */

@Service
public class GestionarVehiculoBusinessImpl implements GestionarVehiculoBusiness {

	@Autowired
	private VehiculoDao vehiculoDao;

	@Override
	public VehiculoDto getVehiculo(String placa) throws BusinessException {

		Authentication authentication = SecurityContextHolder.getContext()
				.getAuthentication();

		String currentImei = ((LoginAuthenticationToken) authentication)
				.getImei();
		String currentUsername = ((LoginAuthenticationToken) authentication)
				.getName();

		VehiculoDto vehiculoDto = vehiculoDao.getVehiculoByPlaca(placa);

		if (vehiculoDto == null) {
			throw new VehiculoNotFoundException(
					"Vehículo no fue encontrado");
		}

		vehiculoDao.setVehicleConsulted(currentUsername, placa, currentImei);

		return vehiculoDto;
	}
}
