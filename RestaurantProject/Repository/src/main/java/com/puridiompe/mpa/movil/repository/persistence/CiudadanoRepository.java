package com.puridiompe.mpa.movil.repository.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.puridiompe.mpa.movil.domain.persistence.Ciudadano;
import com.puridiompe.mpa.movil.domain.persistence.Reclamo;

public interface CiudadanoRepository extends JpaRepository<Ciudadano, Integer>{

	@Query("from  Ciudadano p where p.dni = ?1")
	public Reclamo findByDni (Integer dni);
}
