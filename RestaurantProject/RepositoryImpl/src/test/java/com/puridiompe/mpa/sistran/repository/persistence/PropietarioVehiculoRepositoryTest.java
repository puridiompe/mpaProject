package com.puridiompe.mpa.sistran.repository.persistence;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.puridiompe.mpa.repository.config.SistranRepositoryConfiguration;
import com.puridiompe.mpa.sistran.domain.persistence.PropietarioVehiculo;
import com.puridiompe.mpa.sistran.repository.persistence.PropietarioVehiculoRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { SistranRepositoryConfiguration.class })
public class PropietarioVehiculoRepositoryTest {

	@Autowired
	private PropietarioVehiculoRepository propietarioVehiculoRepository;

	@Test
	public void testFindByVehiculo() {

		
		List<PropietarioVehiculo> propietarios = propietarioVehiculoRepository.findByVehiculo("FH5534");
		
		if (propietarios != null)
		{
			for (PropietarioVehiculo propietario : propietarios)
			{
			
				assertEquals(propietario.getVehiculo(), "FH5534");
			}
		}
		
	}

}
