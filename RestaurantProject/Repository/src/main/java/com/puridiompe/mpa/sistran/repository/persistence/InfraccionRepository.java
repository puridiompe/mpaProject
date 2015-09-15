package com.puridiompe.mpa.sistran.repository.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.puridiompe.mpa.sistran.domain.persistence.Infraccion;

/**
 * 
 * @author Lucho
 *
 */

public interface InfraccionRepository extends JpaRepository<Infraccion, Integer>{
	  
	/**
	 * find InfraccionRepository by codigo
	 * @param codigo
	 * @return
	 */
	@Query("from Infraccion i where i.codigo = ?1")
	public Infraccion findByCodigo(String codigo);
	
	/**
	 * find InfraccionRepository by Descripcion
	 * @param descripcion
	 * @return
	 */
	@Query("from Infraccion i where i.descripcion = ?1")
	public Infraccion findByDescripcion(String descripcion);

}