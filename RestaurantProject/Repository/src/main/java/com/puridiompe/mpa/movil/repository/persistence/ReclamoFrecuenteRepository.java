package com.puridiompe.mpa.movil.repository.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.puridiompe.mpa.movil.domain.persistence.Noticia;
import com.puridiompe.mpa.movil.domain.persistence.Reclamo;
import com.puridiompe.mpa.movil.domain.persistence.ReclamoFrecuente;

public interface ReclamoFrecuenteRepository extends JpaRepository<ReclamoFrecuente, Integer>{

	@Query("from ReclamoFrecuente")
	public List<ReclamoFrecuente> findAll();
}
