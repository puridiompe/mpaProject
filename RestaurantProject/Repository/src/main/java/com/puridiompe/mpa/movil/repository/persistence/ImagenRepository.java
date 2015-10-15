package com.puridiompe.mpa.movil.repository.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.puridiompe.mpa.movil.domain.persistence.Imagen;

public interface ImagenRepository  extends JpaRepository<Imagen, Integer>{
	
	@Query("from imagen i where i.tipo = ?1")
	public List<Imagen> findByTipo(String tipo);

}
