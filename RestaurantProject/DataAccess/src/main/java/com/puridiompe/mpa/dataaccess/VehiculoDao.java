/**
 * 
 */
package com.puridiompe.mpa.dataaccess;

import com.puridiompe.mpa.business.general.dto.VehiculoDto;

/**
 * @author Johnny
 *
 */
public interface VehiculoDao {

	public VehiculoDto getVehiculoByPlaca(String placa);
	
	public void setVehicleConsulted(String username, String placa, String imei);
}
