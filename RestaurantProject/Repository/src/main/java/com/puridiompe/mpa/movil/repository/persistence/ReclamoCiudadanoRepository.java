package com.puridiompe.mpa.movil.repository.persistence;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.puridiompe.mpa.movil.domain.persistence.ReclamoCiudadano;

public interface ReclamoCiudadanoRepository {

    public List<ReclamoCiudadano> findByEstado(String estado, Pageable pageable, String query);
    
    public Integer findTotalReclamos(String query);
    
}
