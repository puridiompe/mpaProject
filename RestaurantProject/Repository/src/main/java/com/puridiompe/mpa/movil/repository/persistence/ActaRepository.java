package com.puridiompe.mpa.movil.repository.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.puridiompe.mpa.movil.domain.persistence.Acta;

public interface ActaRepository extends JpaRepository<Acta, Integer>{

	@Query("from Acta a where a.vehiculo = ?1")
	public List<Acta> findByPlaca(String vehiculo);
	
	@Query("from Acta a where a.idActa = ?1")
	public Acta findByIdActa(Integer idActa);
	
	@Query("from Acta a where a.username = ?1")
	public List<Acta> findByUsername(String username);
}