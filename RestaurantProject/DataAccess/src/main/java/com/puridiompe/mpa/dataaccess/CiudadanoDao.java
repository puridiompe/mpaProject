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
	
	public CiudadanoDto getCiudadano(String imei);
	public void setCiudadano(Integer dni, String apellidoPaterno, String apellidoMaterno, String nombres,String email, String imei);
}
