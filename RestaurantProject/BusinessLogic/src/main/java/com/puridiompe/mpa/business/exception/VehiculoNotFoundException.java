/**
 * 
 */
package com.puridiompe.mpa.business.exception;

/**
 * @author Johnny
 *
 */
@SuppressWarnings("serial")
public class VehiculoNotFoundException extends BusinessException {

	public VehiculoNotFoundException(String message) {
		super("", message);
	}

}
