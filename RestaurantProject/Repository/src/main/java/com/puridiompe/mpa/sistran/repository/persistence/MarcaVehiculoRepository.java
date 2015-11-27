package com.puridiompe.mpa.sistran.repository.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.puridiompe.mpa.sistran.domain.persistence.MarcaVehiculo;

public interface MarcaVehiculoRepository extends JpaRepository <MarcaVehiculo, Integer>{

	@Query("from MarcaVehiculo p where p.id = ?1")
	public MarcaVehiculo findById(Integer id);
}
