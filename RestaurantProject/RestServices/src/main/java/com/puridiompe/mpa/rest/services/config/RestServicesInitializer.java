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

import com.puridiompe.infracciones.rest.controller.config.RestServicesConfiguration;
import com.puridiompe.mpa.business.config.BusinessConfiguration;
import com.puridiompe.mpa.dataaccess.config.DataAccessConfiguration;
import com.puridiompe.mpa.repository.config.PapeletasRepositoryConfiguration;
import com.puridiompe.mpa.repository.config.SistranRepositoryConfiguration;

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
				SistranRepositoryConfiguration.class,
				PapeletasRepositoryConfiguration.class);
		ctx.setServletContext(context);

		ServletRegistration.Dynamic servlet = context.addServlet("dispatcher",
				new DispatcherServlet(ctx));

		servlet.setLoadOnStartup(1);
		servlet.addMapping("/");

	}

}
