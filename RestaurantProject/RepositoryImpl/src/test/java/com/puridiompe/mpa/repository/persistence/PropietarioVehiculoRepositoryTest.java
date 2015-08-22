package com.puridiompe.mpa.repository.persistence;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.puridiompe.mpa.repository.config.SistranRepositoryConfiguration;
import com.puridiompe.mpa.sistran.repository.persistence.PropietarioVehiculoRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { SistranRepositoryConfiguration.class })
public class PropietarioVehiculoRepositoryTest {

	@Autowired
	private PropietarioVehiculoRepository propietarioVehiculoRepository;

	@Test
	public void testFindByVehiculo() {

		String propietarioVehiculoRepositoryEntries = propietarioVehiculoRepository.findByVehiculo("FH5534").getVehiculo();

		assertEquals(propietarioVehiculoRepositoryEntries, "FH5534");

	}

}
