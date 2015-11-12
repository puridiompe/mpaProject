package com.puridiompe.mpa.movil.repository.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.puridiompe.mpa.movil.domain.persistence.HistorialReclamo;

public interface HistorialReclamoRepository extends JpaRepository <HistorialReclamo,Integer> {
	
}
