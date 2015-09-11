package com.puridiompe.mpa.repository.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.puridiompe.mpa.domain.persistence.Infraction;

public interface InfractionRepository extends JpaRepository<Infraction, Integer>{

}