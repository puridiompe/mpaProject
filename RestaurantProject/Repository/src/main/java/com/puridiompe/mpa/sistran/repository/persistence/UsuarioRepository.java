package com.puridiompe.mpa.sistran.repository.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.puridiompe.mpa.sistran.domain.persistence.Usuario;


public interface UsuarioRepository extends JpaRepository<Usuario, String>{

	/**
	 * find Usuario by idUsuario
	 * 
	 * @param idUsuario
	 * @return
	 */
	@Query("from Usuario p where p.idUsuario= ?1")
	public Usuario findByIdUsuario(String idUsuario);
	
	@Query("from Usuario p where p.idUsuario= ?1 and p.password= ?2")
	public Usuario validateUsuario(String idUsuario,String Password);

}
