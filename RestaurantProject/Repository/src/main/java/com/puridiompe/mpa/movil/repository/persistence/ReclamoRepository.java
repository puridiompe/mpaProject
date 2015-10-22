package com.puridiompe.mpa.movil.repository.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.puridiompe.mpa.movil.domain.persistence.Reclamo;

public interface ReclamoRepository extends JpaRepository<Reclamo, Integer>{

	@Query("from  Reclamo r where r.dni = ?1")
	public Reclamo findByDni (Integer dni);
	
	@Query("from  Reclamo r where r.imei = ?1 ORDER BY fechaCreacion DESC")
	public List<Reclamo> findByImei (String imei);
}
