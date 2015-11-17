package com.puridiompe.mpa.movil.repository.persistence;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.puridiompe.mpa.movil.domain.persistence.Reclamo;
import com.puridiompe.mpa.movil.domain.persistence.ReclamoCiudadano;

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
	
	@Query("from  Reclamo r where r.estado != ?1 ORDER BY r.idReclamo DESC")
	public List<Reclamo> findAllAvailable (String estado);	

	@Query("from  Reclamo r where r.imei = ?1 AND r.estado != ?2 ORDER BY idReclamo DESC")
	public List<Reclamo> findAvailableByImei (String imei, String estado);
	
	@Query("select count (*) from Reclamo r where r.imei = ?1")
	public int countReclamosByImei(String imei);
	
	@Query("select new com.puridiompe.mpa.movil.domain.persistence.ReclamoCiudadano(r.idReclamo, r.dni, r.descripcion, r.vehiculo, r.imei, r.numRec, r.fecCre, r.estado, c.apellidoPaterno, c.apellidoMaterno, c.nombres, c.email, c.estado) from  Reclamo r, Ciudadano c where r.dni = c.dni and r.estado != ?1 order by r.idReclamo desc ")
    public List<ReclamoCiudadano> findByEstado(String estado, Pageable pageable);

    @Query("select new com.puridiompe.mpa.movil.domain.persistence.ReclamoCiudadano(r.idReclamo, r.dni, r.descripcion, r.vehiculo, r.imei, r.numRec, r.fecCre, r.estado, c.apellidoPaterno, c.apellidoMaterno, c.nombres, c.email, c.estado) from  Reclamo r, Ciudadano c where r.dni = c.dni and r.imei = ?1 and r.estado != ?2 order by r.idReclamo desc ")
    public List<ReclamoCiudadano> findByImei(String imei, String estado, Pageable pageable);

}
