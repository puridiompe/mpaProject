package com.puridiompe.mpa.repository.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.puridiompe.mpa.domain.persistence.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Integer>{

}
