package com.puridiompe.mpa.movil.repository.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.puridiompe.mpa.movil.domain.persistence.Device;

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
	
	@Query("from Device i where i.usuarioId = ?1")
	public List<Device> findByUserId(Integer usuario_id);
	
	

}