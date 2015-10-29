package com.puridiompe.mpa.business.general;

import com.puridiompe.mpa.business.general.dto.ReclamosDto;
import com.puridiompe.mpa.common.security.exception.SecurityException;

public interface GestionarReclamosBusiness {

	public ReclamosDto getReclamos(String imei) ;
}
