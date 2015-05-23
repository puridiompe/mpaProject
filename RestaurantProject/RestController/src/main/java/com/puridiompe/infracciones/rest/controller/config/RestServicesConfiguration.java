/**
 * 
 */
package com.puridiompe.infracciones.rest.controller.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Configuration class to define package to scan with Spring framework
 * 
 * @author Puridiom-PE
 *
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.puridiompe.infracciones.rest.controller")
public class RestServicesConfiguration {

}
