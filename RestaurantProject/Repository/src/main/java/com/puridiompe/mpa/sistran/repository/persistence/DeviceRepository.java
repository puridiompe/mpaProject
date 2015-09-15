package com.puridiompe.mpa.sistran.repository.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.puridiompe.mpa.sistran.domain.persistence.Device;

/**
 * 
 * @author Lucho
 *
 */

public interface DeviceRepository extends JpaRepository<Device, String>{
	  
	/**
	 * find InfraccionRepository by codigo
	 * @param codigo
	 * @return
	 */
	@Query("from Infraccion i where i.codigo = ?1")
	public Device findByCodigo(String codigo);	

}