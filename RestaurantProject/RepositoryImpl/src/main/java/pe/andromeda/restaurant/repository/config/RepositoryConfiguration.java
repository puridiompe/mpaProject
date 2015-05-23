/**
 * 
 */
package pe.andromeda.restaurant.repository.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author Puridiom-PE
 *
 */
@Configuration
@EnableJpaRepositories("pe.andromeda.restaurant.repository")
@ComponentScan(value = { "pe.andromeda.restaurant.repository.persistence.impl" })
public class RepositoryConfiguration {

}
