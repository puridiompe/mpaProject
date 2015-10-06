package com.puridiompe.mpa.movil.repository.persistence;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.puridiompe.mpa.movil.domain.persistence.Ciudadano;

public interface CiudadanoRepository extends JpaRepository<Ciudadano, Integer>{

	@Query("from  Ciudadano p where p.dni = ?1")
	public Ciudadano findByDni (Integer dni);
	
	@Query("from Ciudadano p where p.imei = ?1")
	public Ciudadano findByImei (String imei);
	
	@Modifying
	@Query("update Ciudadano p set p.apellidoPaterno = ?1, p.apellidoMaterno = ?2, p.nombres = ?3, p.email = ?4, p.fechaModificacion = ?5 where p.dni = ?6")
	void updateCiudadano(String apePat, String apeMat, String nombres, String email, Date fecMod, Integer dni);
}
