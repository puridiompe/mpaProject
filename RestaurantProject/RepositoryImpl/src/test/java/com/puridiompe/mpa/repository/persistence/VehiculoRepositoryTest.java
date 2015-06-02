package com.puridiompe.mpa.repository.persistence;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.puridiompe.mpa.repository.config.RepositoryConfiguration;
import com.puridiompe.mpa.repository.persistence.config.PersistenceConfiguration;
import com.puridiompe.mpa.sistran.repository.persistence.VehiculoRepository;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RepositoryConfiguration.class, PersistenceConfiguration.class})
public class VehiculoRepositoryTest {

	@Autowired
	private VehiculoRepository vehiculoRepository;
	
	@Test
    public void testFindByPlaca() {
		
		String vehiculoRepositoryEntries = vehiculoRepository.findByPlaca("V5I118").getPlacaAntigua();
        
        assertEquals(vehiculoRepositoryEntries, "EH7901");
        
    }

}
