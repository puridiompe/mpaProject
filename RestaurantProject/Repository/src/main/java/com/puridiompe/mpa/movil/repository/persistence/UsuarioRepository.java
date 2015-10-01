package com.puridiompe.mpa.movil.repository.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.puridiompe.mpa.movil.domain.persistence.Usuario;


public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

	/**
	 * find Usuario by idUsuario
	 * 
	 * @param idUsuario
	 * @return
	 */
	
	@Query("from Usuario p where p.username= ?1")
	public Usuario findByUsername(String username);
	
	@Query("from Usuario p where p.idUsuario= ?1")
	public Usuario findByIdUsuario(Integer idUsuario);
	
	@Query("from Usuario p where p.username= ?1 and p.password= ?2")
	public Usuario validateUsuario(String username,String Password);
	
	

}