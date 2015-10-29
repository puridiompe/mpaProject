package com.puridiompe.mpa.movil.repository.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.puridiompe.mpa.movil.domain.persistence.Reclamo;

public interface ReclamoRepository extends JpaRepository<Reclamo, Integer>{

	@Query("from  Reclamo r where r.dni = ?1")
	public Reclamo findByDni (Integer dni);
	
	@Query("from  Reclamo r where r.imei = ?1 ORDER BY fecCre DESC")
	public List<Reclamo> findByImei (String imei);
	
	@Query("from  Reclamo r where r.imei = ?1 ORDER BY dni DESC")
	public List<Reclamo> findByImeiDni (String imei);
	
	@Query("from  Reclamo r ORDER BY idReclamo ASC")//ORDER BY fecCre DESC")
	public List<Reclamo> findAll ();
	
	@Query("from  Reclamo r where r.idReclamo = ?1") 
	public Reclamo findById (Integer idReclamo);
	
	@Query("from  Reclamo r where r.numRec = ?1")
	public Reclamo getImagesByNumRec (String numRec);	
	
	@Query("from  Reclamo r where r.estado != ?1 ORDER BY idReclamo ASC")
	public List<Reclamo> findAllAvailable (String estado);	

	@Query("from  Reclamo r where r.imei = ?1 AND r.estado != ?2 ORDER BY idReclamo DESC")
	public List<Reclamo> findAvailableByImei (String imei, String estado);
}
