package com.puridiompe.mpa.papeletas.repository.persistence;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.puridiompe.mpa.papeletas.domain.persistence.MuniPapeleta;
import com.puridiompe.mpa.papeletas.repository.persistence.MuniPapeletaRepository;
import com.puridiompe.mpa.repository.config.PapeletasRepositoryConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PapeletasRepositoryConfiguration.class })
public class MuniPapeletaRepositoryTest {

	@Autowired
	private MuniPapeletaRepository muniPapeletaRepository;

	@Test
	public void testFindByPlaca() {
		/*
		String muniPapeletaRepositoryEntries = muniPapeletaRepository
				.findByPlaca("UH1602").getNumeroPapeleta();

		assertEquals(muniPapeletaRepositoryEntries, "set     ");
		*/
		
		List<MuniPapeleta> papeletas = muniPapeletaRepository.findByPlaca("UH1602");
		
		assertEquals(papeletas.get(0).getNumeroPapeleta(), "set");
	}

}
