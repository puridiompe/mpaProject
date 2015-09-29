package com.puridiompe.mpa.papeletas.repository.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.puridiompe.mpa.papeletas.domain.persistence.MuniPapeleta;

public interface MuniPapeletaRepository extends JpaRepository<MuniPapeleta, Integer>{
	
	/**
	 * find MuniPapeleta by placa
	 * 
	 * @param placa
	 * @return
	 */
	@Query("from MuniPapeleta p where p.placa = ?1")
	public MuniPapeleta findByPlaca(String placa);
	
	/**
	 * find MuniPapeleta by licencia
	 * 
	 * @param licencia
	 * @return
	 */
	@Query("from MuniPapeleta p where p.licencia = ?1")
	public MuniPapeleta findByLicencia(String licencia);
	
	

}
