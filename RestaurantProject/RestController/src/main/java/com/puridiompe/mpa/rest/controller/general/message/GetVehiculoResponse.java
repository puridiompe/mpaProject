/**
 * 
 */
package com.puridiompe.mpa.rest.controller.general.message;

import com.puridiompe.mpa.business.general.dto.VehiculoDto;
import com.puridiompe.mpa.common.rest.message.ResponseBody;

/**
 * @author Johnny
 *
 */
public class GetVehiculoResponse extends ResponseBody {

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
