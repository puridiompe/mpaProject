package com.puridiompe.mpa.repository.persistence;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.puridiompe.mpa.repository.config.RepositoryConfiguration;
import com.puridiompe.mpa.repository.persistence.config.PersistenceConfiguration;
import com.puridiompe.mpa.sistran.repository.persistence.PermisoOperacionUrbanoRepository;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RepositoryConfiguration.class, PersistenceConfiguration.class})
public class PermisoOperacionUrbanoRepositoryTest {

	@Autowired
	private PermisoOperacionUrbanoRepository permisoOperacionUrbanoRepository;
	
	@Test
    public void testFindByVehiculo() {
		
		String permisoOperacionUrbanoRepositoryEntries = permisoOperacionUrbanoRepository.findByNumero(10729).getUsuario();
        
        assertEquals(permisoOperacionUrbanoRepositoryEntries, "gpalomino");
        
    }

}
