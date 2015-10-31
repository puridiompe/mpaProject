package com.puridiompe.mpa.movil.repository.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.puridiompe.mpa.movil.domain.persistence.VehiculoHistorial;


public interface VehiculoHistorialRepository extends JpaRepository<VehiculoHistorial, Integer>{

	@Query("select count (distinct vehiculo) from  VehiculoHistorial p  where p.imei = ?1 ")
	public Integer findNumeroVehiculosByImei(String imei);
}
