package com.puridiompe.mpa.sistran.repository.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.puridiompe.mpa.sistran.domain.persistence.PropietarioVehiculo;

public interface PropietarioVehiculoRepository extends JpaRepository<PropietarioVehiculo, Integer>{
	
	/**
	 * find PropietarioVehiculoRepository by vehiculo
	 * 
	 * @param vehiculo
	 * @return
	 */
	@Query("from PropietarioVehiculo p where p.vehiculo = ?1")
	public List<PropietarioVehiculo> findByVehiculo(String vehiculo);
	
}
