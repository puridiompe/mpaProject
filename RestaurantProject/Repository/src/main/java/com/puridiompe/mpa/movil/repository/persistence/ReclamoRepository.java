package com.puridiompe.mpa.movil.repository.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.puridiompe.mpa.movil.domain.persistence.Reclamo;

public interface ReclamoRepository extends JpaRepository<Reclamo, Integer>{

	@Query("from  Reclamo p where p.dni = ?1")
	public Reclamo findByDni (Integer dni);
}
