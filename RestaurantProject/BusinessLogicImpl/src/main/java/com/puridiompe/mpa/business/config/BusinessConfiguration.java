/**
 * 
 */
package com.puridiompe.mpa.business.config;

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
@ComponentScan(value = { "com.puridiompe.mpa.business.impl",
		"com.puridiompe.mpa.business.aspect" })
public class BusinessConfiguration {

}
