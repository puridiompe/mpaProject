/**
 * 
 */
package com.puridiompe.mpa.rest.services.config;

import java.util.List;
import java.util.Locale;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.mvc.WebContentInterceptor;

import com.puridiompe.mpa.rest.controller.config.RestControllerConfiguration;

/**
 * @author Puridiom-PE
 *
 */
@Configuration
@Import({ RestCommonConfiguration.class, RestControllerConfiguration.class })
@EnableWebMvc
public class RestServicesConfiguration extends WebMvcConfigurerAdapter {

	private static final String RESOURCES_LOCATION = "/resources/";
	private static final String RESOURCES_HANDLER = RESOURCES_LOCATION + "**";

	@Override
	public void configureContentNegotiation(
			ContentNegotiationConfigurer configurer) {
		configurer.defaultContentType(MediaType.APPLICATION_JSON);
	}

	@Override
	public void configureDefaultServletHandling(
			DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	@Bean
	public WebContentInterceptor webContentInterceptor() {
		WebContentInterceptor interceptor = new WebContentInterceptor();
		interceptor.setCacheSeconds(0);
		interceptor.setUseExpiresHeader(true);
		interceptor.setUseCacheControlHeader(true);
		interceptor.setUseCacheControlNoStore(true);

		return interceptor;
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(webContentInterceptor());
		registry.addInterceptor(localeChangeInterceptor());
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler(RESOURCES_HANDLER)
				.addResourceLocations(RESOURCES_LOCATION)
				.setCachePeriod(31556926);
	}

	@Override
	public void configureMessageConverters(
			List<HttpMessageConverter<?>> converters) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(
				RestCommonConfiguration.class);
		
		converters.add((MappingJackson2HttpMessageConverter) context
				.getBean("messageConverter"));
	}

	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
		LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
		localeChangeInterceptor.setParamName("lang");
		return localeChangeInterceptor;
	}

	@Bean(name = "localeResolver")
	public LocaleResolver getLocaleResolver() {
		CookieLocaleResolver cookieLocaleResolver = new CookieLocaleResolver();
		cookieLocaleResolver.setDefaultLocale(new Locale("es"));

		return cookieLocaleResolver;
	}

}
