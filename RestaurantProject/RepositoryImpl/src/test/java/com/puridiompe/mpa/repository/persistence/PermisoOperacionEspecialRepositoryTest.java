package com.puridiompe.mpa.repository.persistence;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.puridiompe.mpa.repository.config.RepositoryConfiguration;
import com.puridiompe.mpa.repository.persistence.config.PersistenceConfiguration;
import com.puridiompe.mpa.sistran.repository.persistence.PermisoOperacionEspecialRepository;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RepositoryConfiguration.class, PersistenceConfiguration.class})
public class PermisoOperacionEspecialRepositoryTest {

	@Autowired
	private PermisoOperacionEspecialRepository permisoOperacionEspecialRepository;
	
	@Test
    public void testFindByVehiculo() {
		
		String permisoOperacionEspecialRepositoryEntries = permisoOperacionEspecialRepository.findByVehiculo("AK7652").getObservacion();
        
        assertEquals(permisoOperacionEspecialRepositoryEntries, "MIGRADO DESDE ARCHIVO ANTIGUO DE SETARE (NO POSEE NI FECHA DE EMISIÓN NI FECHA DE VENCIMIENTO)");
        
    }

}
