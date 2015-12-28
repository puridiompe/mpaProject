package com.puridiompe.mpa.movil.repository.persistence;

import java.util.List;

import org.springframework.data.domain.Pageable;
import com.puridiompe.mpa.movil.domain.persistence.ActaInspector;

public interface ActaInspectorRepository {

	public Integer findAllTotalActas(String query);
	
	public List<ActaInspector> findAllActas(Pageable pageable,String query);
	
}
