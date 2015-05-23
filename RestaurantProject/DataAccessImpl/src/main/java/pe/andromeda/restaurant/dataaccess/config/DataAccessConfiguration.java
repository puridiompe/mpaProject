/**
 * 
 */
package pe.andromeda.restaurant.dataaccess.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Puridiom-PE
 *
 */
@Configuration
@ComponentScan(value = { "pe.andromeda.restaurant.dataaccess.impl" })
public class DataAccessConfiguration {

}
