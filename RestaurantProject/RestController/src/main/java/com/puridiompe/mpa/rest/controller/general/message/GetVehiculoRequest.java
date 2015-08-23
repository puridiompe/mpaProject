/**
 * 
 */
package com.puridiompe.mpa.rest.controller.general.message;

import com.puridiompe.mpa.business.general.dto.VehiculoDto;
import com.puridiompe.mpa.rest.controller.message.RequestBody;

/**
 * @author Johnny
 *
 */
public class GetVehiculoRequest extends RequestBody {

	private VehiculoDto vehiculo;

	/**
	 * @return the vehiculo
	 */
	public VehiculoDto getVehiculo() {
		return vehiculo;
	}

	/**
	 * @param vehiculo the vehiculo to set
	 */
	public void setVehiculo(VehiculoDto vehiculo) {
		this.vehiculo = vehiculo;
	}
}
