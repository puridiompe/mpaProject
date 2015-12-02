package com.puridiompe.mpa.movil.repository.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.puridiompe.mpa.movil.domain.persistence.InfraccionFrecuente;

public interface InfraccionFrecuenteRepository extends JpaRepository<InfraccionFrecuente, Integer> {

	@Query("from InfraccionFrecuente")
	public List<InfraccionFrecuente> findAll();
	
}
