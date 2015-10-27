package com.puridiompe.mpa.business.general;

import java.util.List;

import com.puridiompe.mpa.business.general.dto.ReclamoDto;
import com.puridiompe.mpa.common.security.exception.SecurityException;;

public interface GestionarReclamoBusiness {

	public void setReclamo(Integer dni, String descripcion, String vehiculo, List<String> imagenesBase64, String estado) throws SecurityException;
	
	public List<ReclamoDto> getReclamosFrecuentes();
	
	public Integer getLastDniByImei(String imei);

	public List<ReclamoDto> getAll();
}
