package com.puridiompe.mpa.sistran.repository.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.puridiompe.mpa.sistran.domain.persistence.GpsInspector;

public interface GpsInspectorRepository extends JpaRepository<GpsInspector, Integer>{

	@Query("from GpsInspector g where g.rol = ?1")
	public List<GpsInspector> findByRol(String rol);
}
