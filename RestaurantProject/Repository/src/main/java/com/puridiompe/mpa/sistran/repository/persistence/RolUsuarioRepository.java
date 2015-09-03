package com.puridiompe.mpa.sistran.repository.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.puridiompe.mpa.sistran.domain.persistence.RolUsuario;


public interface RolUsuarioRepository  extends JpaRepository<RolUsuario, String> {

	@Query("from  RolUsuario p where p.idUsuario = ?1")
	public RolUsuario findByIdUsuario(String idUsuario);
	
}
