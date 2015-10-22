/**
 * 
 */
package com.puridiompe.mpa.dataaccess;

import com.puridiompe.mpa.business.general.dto.CiudadanoDto;

/**
 * @author puridiompe
 *
 */
public interface CiudadanoDao {
	
	public CiudadanoDto getCiudadano(Integer dni);
	public void setCiudadano(Integer dni, String apellidoPaterno, String apellidoMaterno, String nombres,String email);
}
