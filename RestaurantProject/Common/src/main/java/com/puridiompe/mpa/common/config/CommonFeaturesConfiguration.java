/**
 * 
 */
package com.puridiompe.mpa.common.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Johnny
 *
 */
@Configuration
@ComponentScan(value = { "com.puridiompe.mpa.common.context",
		"com.puridiompe.mpa.common.logging", "com.puridiompe.mpa.common.aspect" })
public class CommonFeaturesConfiguration {

}
