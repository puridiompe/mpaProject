/**
 * 
 */
package com.puridiompe.mpa.common.context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author
 * 
 */
@Component
public class ApplicationContextProvider implements ApplicationContextAware {
	private static ApplicationContext applicationContext;

	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	@Override
	public void setApplicationContext(ApplicationContext context) {
		applicationContext = context;
	}
}
