package com.puridiompe.mpa.repository.persistence;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.puridiompe.mpa.papeletas.repository.persistence.MuniPapeletaRepository;
import com.puridiompe.mpa.repository.config.RepositoryConfiguration;
import com.puridiompe.mpa.repository.persistence.config.PersistenceConfiguration;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RepositoryConfiguration.class, PersistenceConfiguration.class})
public class MuniPapeletaRepositoryTest {

	@Autowired
	private MuniPapeletaRepository muniPapeletaRepository;
	
	@Test
    public void testFindByPlaca() {
		
		String muniPapeletaRepositoryEntries = muniPapeletaRepository.findByPlaca("UH1602").getNumeroPapeleta();
        
        assertEquals(muniPapeletaRepositoryEntries, "set     ");
        
    }

}
