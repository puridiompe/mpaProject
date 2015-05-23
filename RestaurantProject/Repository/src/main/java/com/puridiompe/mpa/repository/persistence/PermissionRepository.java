package com.puridiompe.mpa.repository.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.puridiompe.mpa.domain.persistence.Permission;

public interface PermissionRepository extends JpaRepository<Permission, Integer>{

}
