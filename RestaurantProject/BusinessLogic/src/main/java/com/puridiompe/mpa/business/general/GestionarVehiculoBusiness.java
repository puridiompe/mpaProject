/**
 * 
 */
package com.puridiompe.mpa.business.general;

import com.puridiompe.mpa.business.exception.BusinessException;
import com.puridiompe.mpa.business.general.dto.VehiculoDto;
import com.puridiompe.mpa.common.annotation.SafeMethod;
import com.puridiompe.mpa.common.security.exception.SecurityException;

/**
 * @author Johnny
 *
 */
public interface GestionarVehiculoBusiness {

	//@SafeMethod
	public VehiculoDto getVehiculo(String placa) throws BusinessException, SecurityException;
	
}
