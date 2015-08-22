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
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * @author Puridiom-PE
 *
 */
@Configuration
@PropertySource({ "classpath:persistence.properties" })
@EnableJpaRepositories(basePackages = "com.puridiompe.mpa.sistran.repository.persistence", entityManagerFactoryRef = "sistranEntityManagerFactory", transactionManagerRef = "sistranTransactionManager")
// @EnableJpaRepositories(basePackages =
// {"com.puridiompe.mpa.sistran.repository.persistence",
// "com.puridiompe.mpa.papeletas.repository.persistence"})
// @EnableJpaRepositories("com.puridiompe.mpa.repository")
// @ComponentScan(value = { "com.puridiompe.mpa.repository.persistence.impl" })
// @ComponentScan(value = { "com.puridiompe.mpa.repository.persistence.impl" })
public class SistranRepositoryConfiguration {

	@Autowired
	private Environment env;

	@Bean
	public LocalContainerEntityManagerFactoryBean sistranEntityManagerFactory() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(sistranDataSource());
		em.setPackagesToScan(new String[] { "com.puridiompe.mpa.sistran.domain.persistence" });

		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setShowSql(true);
		vendorAdapter.setGenerateDdl(false);
		// vendorAdapter.setDatabasePlatform("org.hibernate.dialect.MySQLInnoDBDialect");
		vendorAdapter
				.setDatabasePlatform("org.hibernate.dialect.PostgreSQLDialect");

		em.setJpaVendorAdapter(vendorAdapter);
		em.setJpaProperties(additionalProperties());

		return em;
	}

	@Bean
	public DataSource sistranDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		// dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setDriverClassName("org.postgresql.Driver");
		// dataSource.setUrl("jdbc:mysql://localhost:3306/testdb");
		// dataSource.setUrl("jdbc:postgresql://localhost:5432/BDTransportes");
		dataSource.setUrl(env.getProperty("sistran.jdbc.url"));
		dataSource.setUsername(env.getProperty("sistran.jdbc.user"));
		dataSource.setPassword(env.getProperty("sistran.jdbc.password"));
		return dataSource;
	}

	@Bean
	public PlatformTransactionManager sistranTransactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager
				.setEntityManagerFactory(sistranEntityManagerFactory()
						.getObject());

		return transactionManager;
	}

	// @Bean
	// public PersistenceExceptionTranslationPostProcessor
	// exceptionTranslation() {
	// return new PersistenceExceptionTranslationPostProcessor();
	// }

	Properties additionalProperties() {
		Properties properties = new Properties();
		// properties.setProperty("hibernate.hbm2ddl.auto", "create-drop");
		// properties.setProperty("hibernate.dialect",
		// "org.hibernate.dialect.MySQL5Dialect");
		return properties;
	}
}
