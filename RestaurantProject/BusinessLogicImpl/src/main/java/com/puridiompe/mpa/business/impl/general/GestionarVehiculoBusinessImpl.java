/**
 * 
 */
package com.puridiompe.mpa.business.impl.general;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.puridiompe.mpa.business.general.GestionarVehiculoBusiness;
import com.puridiompe.mpa.business.general.dto.VehiculoDto;
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
	public VehiculoDto getVehiculo(String placa) {
		return vehiculoDao.getVehiculoByPlaca(placa);
	}

}
