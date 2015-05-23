/**
 * 
 */
package com.puridiompe.mpa.dataaccess.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Puridiom-PE
 *
 */
@Configuration
@ComponentScan(value = { "com.puridiompe.mpa.dataaccess.impl" })
public class DataAccessConfiguration {

}
