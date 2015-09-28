/**
 * 
 */
package com.puridiompe.mpa.rest.security.config;

import javax.servlet.Filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpMethod;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.puridiompe.mpa.business.security.GestionarUserDetailsBusiness;
import com.puridiompe.mpa.common.config.RestCommonConfiguration;
import com.puridiompe.mpa.rest.security.expression.CustomWebSecurityExpressionHandler;
import com.puridiompe.mpa.rest.security.filter.HeaderAuthenticationFilter;
import com.puridiompe.mpa.rest.security.filter.LoginAuthenticationFilter;
import com.puridiompe.mpa.rest.security.handler.HeaderAuthenticationHandler;
import com.puridiompe.mpa.rest.security.handler.RestAuthenticationEntryPoint;
import com.puridiompe.mpa.rest.security.handler.RestAuthenticationFailureHandler;
import com.puridiompe.mpa.rest.security.handler.RestAuthenticationSuccessHandler;
import com.puridiompe.mpa.rest.security.handler.RestLogoutSuccessHandler;
import com.puridiompe.mpa.rest.security.provider.CustomAuthenticationProvider;

/**
 * @author Johnny
 *
 */
@Configuration
@Import(RestCommonConfiguration.class)
@PropertySource({"file:${app.security.config}/security.properties"})
@ComponentScan(value = {
		"com.puridiompe.mpa.rest.security.handler",
		"com.puridiompe.mpa.rest.security.expression" })
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {


	@Autowired
	private CustomWebSecurityExpressionHandler securityExpressionHandler;

	@Autowired
	private RestAuthenticationEntryPoint authenticationEntryPoint;

	@Autowired
	private RestAuthenticationFailureHandler authenticationFailureHandler;

	@Autowired
	private RestAuthenticationSuccessHandler authenticationSuccessHandler;

	@Autowired
	private RestLogoutSuccessHandler logoutSuccessHandler;
	
	@Autowired
	private GestionarUserDetailsBusiness userDetailsService;
	
	@Autowired
    private HeaderAuthenticationHandler headerAuthenticationHandler;

	
	@Bean
	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
		return new StandardPasswordEncoder();
	}
	
	@Bean
	public AuthenticationProvider authenticationProvider() {

		AuthenticationProvider authenticationProvider = new CustomAuthenticationProvider();

		return authenticationProvider;
	}
	
	@Autowired
	public void registerGlobalAuthentication(AuthenticationManagerBuilder auth)
			throws Exception {

		auth.authenticationProvider(authenticationProvider());
		

		// .userDetailsService(gestionarUserDetailsBusiness)
		// .passwordEncoder(passwordEncoder());

	}
	

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().expressionHandler(securityExpressionHandler)
				.antMatchers(HttpMethod.POST, "/pedido/**")
				.access("hasAccessPedidos()")
				.antMatchers(HttpMethod.POST, "/cocina/**")
				.access("hasAccessCocina()").anyRequest().authenticated().and()
				.anonymous().disable();

		 http.csrf().disable();

		http.sessionManagement().sessionCreationPolicy(
				SessionCreationPolicy.STATELESS);

		http.exceptionHandling().authenticationEntryPoint(
				authenticationEntryPoint);

//		http.formLogin().loginPage("/signin").usernameParameter("user")
//				.passwordParameter("pass")
//				.successHandler(authenticationSuccessHandler)
//				.failureHandler(authenticationFailureHandler).permitAll();
		
		http.formLogin().loginPage("/signin").permitAll();
//
		http.addFilterBefore(loginFilter(), UsernamePasswordAuthenticationFilter.class);
		
		http.logout().logoutUrl("/signout").invalidateHttpSession(true)
				.logoutSuccessHandler(logoutSuccessHandler).permitAll();
		
		http.addFilterBefore(authenticationFilter(), LogoutFilter.class);
		//http.addFilter(null).

	}
	
	private Filter loginFilter() throws Exception {
		ApplicationContext context = new AnnotationConfigApplicationContext(
				RestCommonConfiguration.class);
		
		MappingJackson2HttpMessageConverter messageConverter = (MappingJackson2HttpMessageConverter) context
				.getBean("messageConverter");
		
		LoginAuthenticationFilter loginFilter = new LoginAuthenticationFilter();
		loginFilter.setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher("/signin", "POST"));
		loginFilter.setAuthenticationManager(this.authenticationManager());
		
//		loginFilter.setUsernameParameter("user");
//		loginFilter.setPasswordParameter("pass");
		loginFilter.setAuthenticationSuccessHandler(authenticationSuccessHandler);
		loginFilter.setAuthenticationFailureHandler(authenticationFailureHandler);
		loginFilter.setMessageConverter(messageConverter);
		
        return loginFilter;
    }
	
	private Filter authenticationFilter() {
        HeaderAuthenticationFilter headerAuthenticationFilter = new HeaderAuthenticationFilter();
        headerAuthenticationFilter.userDetailsService(userDetailsService);
        headerAuthenticationFilter.authenticationHandler(headerAuthenticationHandler);
        return headerAuthenticationFilter;
    }

}
