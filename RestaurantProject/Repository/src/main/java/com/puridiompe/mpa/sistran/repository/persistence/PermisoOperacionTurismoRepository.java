package com.puridiompe.mpa.sistran.repository.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.puridiompe.mpa.sistran.domain.persistence.PermisoOperacionTurismo;

public interface PermisoOperacionTurismoRepository extends JpaRepository<PermisoOperacionTurismo, String>{

	/**
	 * find permission by Vehicle
	 * 
	 * @param vehiculo
	 * @return
	 */
	@Query("from PermisoOperacionTurismo p where p.vehiculo = ?1")
	public PermisoOperacionTurismo findByVehiculo(String vehiculo);
}
