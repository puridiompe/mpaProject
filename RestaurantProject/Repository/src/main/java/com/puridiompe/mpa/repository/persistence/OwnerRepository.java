package com.puridiompe.mpa.repository.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.puridiompe.mpa.domain.persistence.Owner;

public interface OwnerRepository extends JpaRepository<Owner, Integer>{

}
