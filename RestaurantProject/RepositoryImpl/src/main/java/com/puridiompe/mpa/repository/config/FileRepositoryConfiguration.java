/**
 * 
 */
package com.puridiompe.mpa.repository.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author Johnny
 *
 */
@Configuration
@PropertySource({ "file:${app.persistence.config}/fileStore.properties" })
@ComponentScan(value = { "com.puridiompe.mpa.movil.repository.file.impl" })
public class FileRepositoryConfiguration {

}
