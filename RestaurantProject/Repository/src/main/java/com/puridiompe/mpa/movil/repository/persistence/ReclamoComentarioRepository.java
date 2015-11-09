package com.puridiompe.mpa.movil.repository.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.puridiompe.mpa.movil.domain.persistence.ReclamoComentario;

public interface ReclamoComentarioRepository  extends JpaRepository<ReclamoComentario, Integer>{
	
	@Query("from  ReclamoComentario rc where rc.idReclamo= ?1")
	public List<ReclamoComentario> findByiDReclamo (Integer idReclamo);
	
	@Query("from  ReclamoComentario rc WHERE rc.estado != ?1 ORDER BY idReclamo ASC ")
	public List<ReclamoComentario> findAllByiDReclamo (String estado);
	
	@Query("from  ReclamoComentario rc WHERE rc.estado != ?1 ORDER BY idReclamo ASC ")
	public List<ReclamoComentario> findAllAvailable(String estado);
	
	@Query("select rc from  ReclamoComentario rc, Reclamo r WHERE r.estado != ?2 AND r.imei = ?1 AND rc.idReclamo = r.idReclamo ORDER BY rc.idReclamo DESC ")
	public List<ReclamoComentario> findAllByRecImei (String imei, String estado);
	
	@Query("select rc from  ReclamoComentario rc, Reclamo r WHERE r.estado != ?1  AND rc.idReclamo = r.idReclamo ORDER BY rc.idReclamo DESC ")
	public List<ReclamoComentario> findAllByReclamo (String estado);
}
