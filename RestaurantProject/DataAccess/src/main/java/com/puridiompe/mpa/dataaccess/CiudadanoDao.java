/**
 * 
 */
package com.puridiompe.mpa.dataaccess;

/**
 * @author puridiompe
 *
 */
public interface CiudadanoDao {
	
	public void setCiudadano(Integer dni, String apellidoPaterno, String apellidoMaterno, String nombres,String email);
}
