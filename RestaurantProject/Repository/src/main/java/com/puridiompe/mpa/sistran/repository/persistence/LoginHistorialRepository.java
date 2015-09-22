package com.puridiompe.mpa.sistran.repository.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.puridiompe.mpa.sistran.domain.persistence.LoginHistorial;


public interface LoginHistorialRepository extends JpaRepository<LoginHistorial, Integer> {
	
	@Query("from  LoginHistorial p  where p.idUsuario = ?1 ")
	public List<LoginHistorial> findByIdUsuario(Integer idUsuario);
	
}
