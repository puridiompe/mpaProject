/**
 * 
 */
package com.puridiompe.mpa.business.general;

import com.puridiompe.mpa.business.general.dto.VehiculoDto;

/**
 * @author Johnny
 *
 */
public interface GestionarVehiculoBusiness {

	public VehiculoDto getVehiculo(String placa);
}
