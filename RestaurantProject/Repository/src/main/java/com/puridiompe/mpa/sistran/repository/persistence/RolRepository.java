package com.puridiompe.mpa.sistran.repository.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.puridiompe.mpa.sistran.domain.persistence.Rol;


public interface RolRepository extends JpaRepository<Rol, Integer> { 
	
	@Query("from  Rol p where p.idRol = ?1")
	public Rol findByIdRol (Integer idRol);

}
