/**
 * 
 */
package com.puridiompe.mpa.rest.services.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import pe.andromeda.restaurant.business.config.BusinessConfiguration;
import pe.andromeda.restaurant.dataaccess.config.DataAccessConfiguration;
import pe.andromeda.restaurant.repository.config.RepositoryConfiguration;
import pe.andromeda.restaurant.repository.persistence.config.PersistenceConfiguration;
import pe.andromeda.restaurant.rest.controller.config.RestServicesConfiguration;

/**
 * Initialize web application context considering custom configuration class
 * 
 * @author Puridiom-PE
 *
 */
public class RestServicesInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext context) throws ServletException {
		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		ctx.register(RestServicesConfiguration.class,
				BusinessConfiguration.class, DataAccessConfiguration.class,
				RepositoryConfiguration.class, PersistenceConfiguration.class);
		ctx.setServletContext(context);

		ServletRegistration.Dynamic servlet = context.addServlet("dispatcher",
				new DispatcherServlet(ctx));

		servlet.setLoadOnStartup(1);
		servlet.addMapping("/");

	}

}
