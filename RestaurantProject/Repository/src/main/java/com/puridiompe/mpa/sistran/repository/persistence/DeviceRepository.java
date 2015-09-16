package com.puridiompe.mpa.sistran.repository.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.puridiompe.mpa.sistran.domain.persistence.Device;

/**
 * 
 * @author Lucho
 *
 */

public interface DeviceRepository extends JpaRepository<Device, Integer>{
	  
	/**
	 * find InfraccionRepository by imei
	 * @param imei
	 * @return
	 */
	@Query("from Device i where i.imei = ?1")
	public Device findByImei(String imei);	

}