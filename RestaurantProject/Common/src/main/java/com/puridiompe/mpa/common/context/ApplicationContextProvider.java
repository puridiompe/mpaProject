/**
 * 
 */
package com.puridiompe.mpa.common.context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author
 * 
 */
public class ApplicationContextProvider implements ApplicationContextAware {
	private static ApplicationContext applicationContext;

	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	public void setApplicationContext(ApplicationContext context) {
		applicationContext = context;
	}
}
