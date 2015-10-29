package com.puridiompe.mpa.dataaccess;

import java.util.List;

import com.puridiompe.mpa.business.general.dto.ReclamosDto;

public interface ReclamosDao {

	public ReclamosDto getReclamosByImei(String imei);
}
