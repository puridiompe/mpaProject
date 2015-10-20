package com.puridiompe.mpa.dataaccess;

import java.util.List;

import com.puridiompe.mpa.business.general.dto.ReclamoDto;

public interface ReclamoDao {

	public void saveReclamo (Integer dni, String descripcion, String vehiculo, List<String> imagenesBase64);
	
	public List<ReclamoDto> getReclamosFrecuentes();
}
