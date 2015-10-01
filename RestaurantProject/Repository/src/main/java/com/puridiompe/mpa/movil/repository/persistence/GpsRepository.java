package com.puridiompe.mpa.movil.repository.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.puridiompe.mpa.movil.domain.persistence.Gps;

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
	@Query("from Gps g where g.imei = ?1")
	public List<Gps> findByImei(String imei);
	
	@Query("from Gps g where g.imei = ?1 order by txn_id desc")
//	@Query("from Gps g where g.imei = ?1 limit 1")
	public List<Gps> findLastByImei(String imei);

}