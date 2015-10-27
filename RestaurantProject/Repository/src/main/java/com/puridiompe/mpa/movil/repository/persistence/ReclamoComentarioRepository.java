package com.puridiompe.mpa.movil.repository.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.puridiompe.mpa.movil.domain.persistence.ReclamoComentario;

public interface ReclamoComentarioRepository  extends JpaRepository<ReclamoComentario, Integer>{
	
	@Query("from  ReclamoComentario rc where rc.idReclamo= ?1")
	public List<ReclamoComentario> findByiDReclamo (Integer idReclamo);

}
