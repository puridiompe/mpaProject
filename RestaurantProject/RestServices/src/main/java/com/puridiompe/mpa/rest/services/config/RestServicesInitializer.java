/**
 * 
 */
package com.puridiompe.mpa.rest.services.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.DispatcherServlet;

import com.puridiompe.mpa.business.config.BusinessConfiguration;
import com.puridiompe.mpa.dataaccess.config.DataAccessConfiguration;
import com.puridiompe.mpa.repository.config.MovilRepositoryConfiguration;
import com.puridiompe.mpa.repository.config.PapeletasRepositoryConfiguration;
import com.puridiompe.mpa.repository.config.SistranRepositoryConfiguration;
import com.puridiompe.mpa.rest.security.config.SecurityConfiguration;

/**
 * Initialize web application context considering custom configuration class
 * 
 * @author Puridiom-PE
 *
 */
public class RestServicesInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext context) throws ServletException {

		// Create root application context
		AnnotationConfigWebApplicationContext rootCtx = new AnnotationConfigWebApplicationContext();
		
//		SecurityConfiguration.class, 
		rootCtx.register(SecurityConfiguration.class, BusinessConfiguration.class,		
	//	rootCtx.register(BusinessConfiguration.class, // --->> 
				DataAccessConfiguration.class,
				SistranRepositoryConfiguration.class,
//				PapeletasRepositoryConfiguration.class,
				MovilRepositoryConfiguration.class);

		// Manage the lifecycle of the root application context
		context.addListener(new ContextLoaderListener(rootCtx));

		 context.addFilter("securityFilter",		 				// --->> 
		 new DelegatingFilterProxy("springSecurityFilterChain"))  	// --->>
		 .addMappingForUrlPatterns(null, false, "/*");  			// --->>

		// Create the dispatcher servlet's Spring application context
		AnnotationConfigWebApplicationContext dispatcherServlet = new AnnotationConfigWebApplicationContext();
		dispatcherServlet.register(RestServicesConfiguration.class);
		
//		dispatcherServlet.getEnvironment().setActiveProfiles("", "");

		ServletRegistration.Dynamic servlet = context.addServlet("dispatcher",
				new DispatcherServlet(dispatcherServlet));

		servlet.setLoadOnStartup(1);
		servlet.addMapping("/");

	}

}
