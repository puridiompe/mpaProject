package com.puridiompe.mpa.dataaccess;

import java.util.List;

import com.puridiompe.mpa.business.general.dto.ReclamoDto;

public interface ReclamoDao {

	public void setReclamo (Integer dni, String descripcion, String vehiculo);
	
	public List<ReclamoDto> getReclamosFrecuentes();
}
