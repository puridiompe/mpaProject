package com.puridiompe.mpa.papeletas.repository.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.puridiompe.mpa.papeletas.domain.persistence.MuniConductor;

public interface MuniConductorRepository extends JpaRepository<MuniConductor, Integer>{
	
	/**
	 * find MuniConductor by placa
	 * 
	 * @param placa
	 * @return
	 */
	@Query("from MuniConductor p where p.placa = ?1 and p.numeroPapeleta = ?2")
	public MuniConductor findByPlaca(String placa, String numeroPapeleta);
	
	/**
	 * find MuniConductor by codigoInfraccion
	 * 
	 * @param codigoInfraccion
	 * @return
	 */
	@Query("from MuniConductor p where p.codigoInfraccion = ?1")
	public MuniConductor findByCodigoInfraccion(String codigoInfraccion);
	

}
