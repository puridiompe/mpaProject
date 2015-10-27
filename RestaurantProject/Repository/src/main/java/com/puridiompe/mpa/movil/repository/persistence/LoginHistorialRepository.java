package com.puridiompe.mpa.movil.repository.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.puridiompe.mpa.movil.domain.persistence.LoginHistorial;


public interface LoginHistorialRepository extends JpaRepository<LoginHistorial, Integer> {
	
	@Query("from  LoginHistorial p  where p.username = ?1 ")
	public List<LoginHistorial> findByIdUsuario(String username);
	
	@Query("from  LoginHistorial p  where   p.username = ?1 AND p.imei = ?2 ORDER BY p.fechaHora DESC")
	public List<LoginHistorial> findByIdImei(String username ,String imei);
	
}
