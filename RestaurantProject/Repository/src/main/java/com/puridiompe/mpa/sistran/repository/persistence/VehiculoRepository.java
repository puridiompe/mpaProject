package com.puridiompe.mpa.sistran.repository.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.puridiompe.mpa.sistran.domain.persistence.Vehiculo;

public interface VehiculoRepository extends JpaRepository<Vehiculo, String>{
	
	/**
	 * find VehiculoRepository by placa
	 * 
	 * @param placa
	 * @return
	 */
	@Query("from Vehiculo p where p.idPlaca = ?1")
	public Vehiculo findByPlaca(String placa);
	
	/**
	 * find VehiculoRepository by usuario
	 * 
	 * @param usuario
	 * @return
	 */
	@Query("from Vehiculo p where p.usuario = ?1")
	public Vehiculo findByUsuario(String usuario);

}
