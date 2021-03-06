package com.puridiompe.mpa.movil.repository.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.puridiompe.mpa.movil.domain.persistence.RolUsuario;


public interface RolUsuarioRepository  extends JpaRepository<RolUsuario, Integer> {

	@Query("from  RolUsuario p where p.idUsuario = ?1")
	public List<RolUsuario> findByIdUsuario(Integer idUsuario);
	
}
