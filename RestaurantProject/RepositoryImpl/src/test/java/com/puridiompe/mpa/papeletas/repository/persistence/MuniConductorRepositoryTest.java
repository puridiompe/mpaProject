package com.puridiompe.mpa.papeletas.repository.persistence;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.puridiompe.mpa.papeletas.repository.persistence.MuniConductorRepository;
import com.puridiompe.mpa.repository.config.PapeletasRepositoryConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PapeletasRepositoryConfiguration.class })
public class MuniConductorRepositoryTest {

	@Autowired
	private MuniConductorRepository muniConductorRepository;

	@Test
	public void testFindByPlaca() {

		String muniConductorRepositoryEntries = muniConductorRepository
				.findByPlaca("RH3839", "220334P").getDescripcionInfraccion();

		assertEquals(
				muniConductorRepositoryEntries,
				"CONDUCIR VEHICULOS CON LICENCIA CUYA CATEGORIA NO CORRESPONDA AL VEHI.QUE CONDUZCA        ");

	}

}
