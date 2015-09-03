package com.puridiompe.mpa.sistran.repository.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.puridiompe.mpa.sistran.domain.persistence.Infraccion;

/**
 * 
 * @author Lucho
 *
 */

public interface InfraccionRepository extends JpaRepository<Infraccion, String>{
	  
	/**
	 * find InfraccionRepository by Id
	 * @param id
	 * @return
	 */
	@Query("from Infraccion i where i.idInfraccion = ?1")
	public Infraccion findById(Integer id);
	
	/**
	 * find InfraccionRepository by Descripcion
	 * @param descripcion
	 * @return
	 */
	@Query("from Infraccion i where i.descripcion = ?1")
	public Infraccion findByDescripcion(String descripcion);
	

}
