package com.puridiompe.mpa.sistran.repository.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.puridiompe.mpa.sistran.domain.persistence.Gps;

/**
 * 
 * @author Lucho
 *
 */

public interface GpsRepository extends JpaRepository<Gps, Integer>{
	  
	/**
	 * find GpsRepository by imei
	 * @param imei	 
	 * @return
	 */
	@Query("from gps g where g.imei = ?1")
	public Gps findByImei(String imei);	

}