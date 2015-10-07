package com.puridiompe.mpa.business.general;

import java.util.List;

import com.puridiompe.mpa.business.general.dto.ReclamoDto;;

public interface GestionarReclamoBusiness {

	public void setReclamo(Integer dni, String descripcion, String vehiculo);
	
	public List<ReclamoDto> getReclamosFrecuentes();
}
