package com.puridiompe.mpa.movil.repository.persistence;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.puridiompe.mpa.movil.domain.persistence.Ciudadano;

public interface CiudadanoRepository extends JpaRepository<Ciudadano, Integer>{

	@Query("from  Ciudadano p where p.dni = ?1")
	public Ciudadano findByDni (Integer dni);
	
	@Query("from  Ciudadano p")
	public List<Ciudadano> findAllByDni ();
	
//	@Query("from Ciudadano p where p.imei = ?1")
//	public List<Ciudadano> findByImei (String imei);
	
//	@Modifying
//	@Query("update Ciudadano p set p.dni = ?1, p.apellidoPaterno = ?2, p.apellidoMaterno = ?3, p.nombres = ?4, p.email = ?5, p.fechaModificacion = ?6 where p.imei = ?7")
//	@Transactional
//	public void updateCiudadano(Integer dni, String apePat, String apeMat, String nombres, String email, Date fecMod, String imei);
//	
//	@Modifying
//	@Query("update Ciudadano p set p.apellidoPaterno = ?2, p.apellidoMaterno = ?3, p.nombres = ?4, p.email = ?5, p.fechaModificacion = ?6, p.imei = ?7 where p.dni = ?1")
//	@Transactional
//	public void updateByDni(Integer dni, String apePat, String apeMat, String nombres, String email, Date fecMod, String imei);
}
