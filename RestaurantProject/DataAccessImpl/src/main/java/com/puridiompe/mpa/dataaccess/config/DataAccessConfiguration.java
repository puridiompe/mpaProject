/**
 * 
 */
package com.puridiompe.mpa.dataaccess.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

import com.puridiompe.mpa.common.config.CommonFeaturesConfiguration;

/**
 * @author Puridiom-PE
 *
 */
@Configuration
@Import(CommonFeaturesConfiguration.class)
@EnableAspectJAutoProxy
@ComponentScan(value = { "com.puridiompe.mpa.dataaccess.impl" })
public class DataAccessConfiguration {

}
