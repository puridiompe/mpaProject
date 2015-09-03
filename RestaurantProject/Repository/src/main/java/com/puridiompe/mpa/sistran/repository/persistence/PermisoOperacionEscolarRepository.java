package com.puridiompe.mpa.sistran.repository.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.puridiompe.mpa.sistran.domain.persistence.PermisoOperacionEscolar;


public interface PermisoOperacionEscolarRepository extends JpaRepository<PermisoOperacionEscolar, String>{

	/**
	 * find permission by Vehicle
	 * 
	 * @param vehiculo
	 * @return
	 */
	@Query("from PermisoOperacionEscolar p where p.vehiculo = ?1")
	public PermisoOperacionEscolar findByVehiculo(String vehiculo);
}
