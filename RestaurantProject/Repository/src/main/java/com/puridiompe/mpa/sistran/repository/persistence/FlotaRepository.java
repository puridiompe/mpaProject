package com.puridiompe.mpa.sistran.repository.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.puridiompe.mpa.sistran.domain.persistence.Flota;

public interface FlotaRepository extends JpaRepository<Flota, String>{

	@Query("from Flota p where p.vehiculo = ?1 and p.estado = 1")
	public Flota findByVehiculo (String vehiculo);
}
