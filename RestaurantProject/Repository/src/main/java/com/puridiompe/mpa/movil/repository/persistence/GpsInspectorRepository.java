package com.puridiompe.mpa.movil.repository.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.puridiompe.mpa.common.type.Datetime;
import com.puridiompe.mpa.movil.domain.persistence.GpsInspector;

public interface GpsInspectorRepository extends JpaRepository<GpsInspector, Integer>{

	@Query("from GpsInspector g where g.rol = ?1")
	public List<GpsInspector> findByRol(String rol);
	
	//@Query("from GpsInspector g where g.imei = ?1")
	//public GpsInspector findLastByImei(String imei);
	
	@Query("from GpsInspector g where g.username = ?1")
	public GpsInspector findLastByUsername(String username);
}
