package com.puridiompe.mpa.sistran.repository.persistence;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.puridiompe.mpa.repository.config.SistranRepositoryConfiguration;
import com.puridiompe.mpa.sistran.repository.persistence.PermisoOperacionUrbanoRepository;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SistranRepositoryConfiguration.class})
public class PermisoOperacionUrbanoRepositoryTest {

	@Autowired
	private PermisoOperacionUrbanoRepository permisoOperacionUrbanoRepository;
	
	@Test
    public void testFindByVehiculo() {
		
		String permisoOperacionUrbanoRepositoryEntries = permisoOperacionUrbanoRepository.findByNumero(10729).getUsuario();
        
        assertEquals(permisoOperacionUrbanoRepositoryEntries, "gpalomino");
        
    }

}
