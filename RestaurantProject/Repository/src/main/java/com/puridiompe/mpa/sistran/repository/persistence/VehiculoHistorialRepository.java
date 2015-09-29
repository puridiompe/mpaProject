package com.puridiompe.mpa.sistran.repository.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.puridiompe.mpa.sistran.domain.persistence.VehiculoHistorial;


public interface VehiculoHistorialRepository extends JpaRepository<VehiculoHistorial, Integer>{

//	@Query("from  VehiculoHistorial p  where p.username = ?1 ")
//	public List<VehiculoHistorial> findByUsername(Integer username);
}
