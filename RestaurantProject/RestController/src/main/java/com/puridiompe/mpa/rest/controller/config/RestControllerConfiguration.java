/**
 * 
 */
package com.puridiompe.mpa.rest.controller.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class to define package to scan with Spring framework
 * 
 * @author Puridiom-PE
 *
 */
@Configuration
@ComponentScan(basePackages = "com.puridiompe.mpa.rest.controller")
public class RestControllerConfiguration {

}
