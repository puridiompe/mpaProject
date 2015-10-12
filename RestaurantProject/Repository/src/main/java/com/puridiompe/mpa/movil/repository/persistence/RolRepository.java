package com.puridiompe.mpa.movil.repository.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.puridiompe.mpa.movil.domain.persistence.Rol;


public interface RolRepository extends JpaRepository<Rol, Integer> { 
	
	@Query("from Rol p where p.idRol = ?1")
	public Rol findByIdRol (Integer idRol);
	
	@Query("from Rol p where p.rol = ?1")
	public Rol findByName (String rol);

}
