package com.puridiompe.mpa.dataaccess.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.puridiompe.mpa.dataaccess.PapeletaDao;
import com.puridiompe.mpa.business.general.dto.PapeletaDto;
import com.puridiompe.mpa.papeletas.domain.persistence.MuniPapeleta;
import com.puridiompe.mpa.papeletas.repository.persistence.MuniPapeletaRepository;

@Component
public class PapeletaDaoImpl implements PapeletaDao{

	@Autowired
	private MuniPapeletaRepository papeletaRepository;
	
	@Transactional(value = "papeletasTransactionManager", readOnly = true)
	@Override
	public List<PapeletaDto> getPapeletasByPlaca(String placa) {
		List<PapeletaDto> papeletasObject = new ArrayList<PapeletaDto>();
		List<MuniPapeleta> papeletas = papeletaRepository.findByPlaca(placa);
		
		if (papeletas != null)
			for (int i=0 ; i<papeletas.size() ; i++){
				PapeletaDto papeletaDtoTmp = new PapeletaDto();
				BeanUtils.copyProperties(papeletas.get(i), papeletaDtoTmp);
				papeletasObject.add(papeletaDtoTmp);	
			}
		else return null;
		
		return papeletasObject;
	}
	
	
}
