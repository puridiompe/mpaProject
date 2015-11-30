package com.puridiompe.mpa.sistran.repository.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.puridiompe.mpa.movil.domain.persistence.VehiculoColorDetalle;
import com.puridiompe.mpa.sistran.domain.persistence.Color;

public interface ColorRepository extends JpaRepository<Color, Integer> {

	@Query("select new com.puridiompe.mpa.movil.domain.persistence.VehiculoColorDetalle(c.denominacion, cv.detalleColor) from Color c, ColorVehiculo cv where vehiculo = ?1 and cv.color = c.id ORDER BY cv.id ")
	public VehiculoColorDetalle findColorByVehiculo (String vehiculo);
}
