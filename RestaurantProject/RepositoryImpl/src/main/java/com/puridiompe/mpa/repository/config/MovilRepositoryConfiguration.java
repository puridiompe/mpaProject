/**
 * 
 */
package com.puridiompe.mpa.repository.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * @author Johnny
 *
 */
@Configuration
@PropertySource({ "file:${app.persistence.config}/persistence.properties" })
@EnableJpaRepositories(basePackages = "com.puridiompe.mpa.movil.repository.persistence", entityManagerFactoryRef = "movilEntityManagerFactory", transactionManagerRef = "movilTransactionManager")
public class MovilRepositoryConfiguration {

	@Autowired
	private Environment env;

	@Bean
	public LocalContainerEntityManagerFactoryBean movilEntityManagerFactory() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(movilDataSource());
		em.setPackagesToScan(new String[] { "com.puridiompe.mpa.movil.domain.persistence" });

		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setShowSql(true);
		vendorAdapter.setGenerateDdl(false);// true
		vendorAdapter.setDatabase(Database.POSTGRESQL);
		// vendorAdapter.setDatabasePlatform("org.hibernate.dialect.MySQLInnoDBDialect");
		vendorAdapter
				.setDatabasePlatform("org.hibernate.dialect.PostgreSQLDialect");

		em.setJpaVendorAdapter(vendorAdapter);
		em.setJpaProperties(additionalProperties());

		return em;
	}

//	@Bean(destroyMethod = "close")
	@Bean
	public DataSource movilDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		// dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setDriverClassName("org.postgresql.Driver");
		dataSource.setUrl(env.getProperty("movil.jdbc.url"));
		dataSource.setUsername(env.getProperty("movil.jdbc.user"));
		dataSource.setPassword(env.getProperty("movil.jdbc.password"));
		return dataSource;
		
	}

	@Bean
	public PlatformTransactionManager movilTransactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager
				.setEntityManagerFactory(movilEntityManagerFactory()
						.getObject());

		return transactionManager;
	}

	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}

	Properties additionalProperties() {
		Properties properties = new Properties();
		// properties.setProperty("hibernate.hbm2ddl.auto", "create-drop");
		// properties.setProperty("hibernate.dialect",
		// "org.hibernate.dialect.MySQL5Dialect");
		return properties;
	}
}
