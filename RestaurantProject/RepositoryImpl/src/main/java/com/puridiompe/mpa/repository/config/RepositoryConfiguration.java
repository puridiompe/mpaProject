/**
 * 
 */
package com.puridiompe.mpa.repository.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author Puridiom-PE
 *
 */
@Configuration
//@EnableJpaRepositories("com.puridiompe.mpa.sistran.repository.persistence")
@EnableJpaRepositories("com.puridiompe.mpa.papeletas.repository.persistence")
//@EnableJpaRepositories(basePackages = {"com.puridiompe.mpa.sistran.repository.persistence", "com.puridiompe.mpa.papeletas.repository.persistence"})


//@EnableJpaRepositories("com.puridiompe.mpa.repository")
//@ComponentScan(value = { "com.puridiompe.mpa.repository.persistence.impl" })
//@ComponentScan(value = { "com.puridiompe.mpa.repository.persistence.impl" })
public class RepositoryConfiguration {

}
