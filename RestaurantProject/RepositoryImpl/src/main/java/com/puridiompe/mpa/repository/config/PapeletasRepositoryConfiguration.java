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
 * @author Puridiom-PE
 *
 */
@Configuration
// @EnableJpaRepositories("com.puridiompe.mpa.sistran.repository.persistence")
@PropertySource({ "file:${app.persistence.config}/persistence.properties" })
@EnableJpaRepositories(basePackages = "com.puridiompe.mpa.papeletas.repository.persistence", entityManagerFactoryRef = "papeletasEntityManagerFactory", transactionManagerRef = "papeletasTransactionManager")
// @EnableJpaRepositories(basePackages =
// {"com.puridiompe.mpa.sistran.repository.persistence",
// "com.puridiompe.mpa.papeletas.repository.persistence"})
// @EnableJpaRepositories("com.puridiompe.mpa.repository")
// @ComponentScan(value = { "com.puridiompe.mpa.repository.persistence.impl" })
// @ComponentScan(value = { "com.puridiompe.mpa.repository.persistence.impl" })
public class PapeletasRepositoryConfiguration {

	@Autowired
	private Environment env;

	@Bean
	public LocalContainerEntityManagerFactoryBean papeletasEntityManagerFactory() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(papeletasDataSource());
		em.setPackagesToScan(new String[] { "com.puridiompe.mpa.papeletas.domain.persistence" });

		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setShowSql(true);
		vendorAdapter.setGenerateDdl(false);
		vendorAdapter.setDatabase(Database.POSTGRESQL);
		// vendorAdapter.setDatabasePlatform("org.hibernate.dialect.MySQLInnoDBDialect");
		vendorAdapter
				.setDatabasePlatform("org.hibernate.dialect.PostgreSQLDialect");

		em.setJpaVendorAdapter(vendorAdapter);
		em.setJpaProperties(additionalProperties());

		return em;
	}

	@Bean
	public DataSource papeletasDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		// dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setDriverClassName("org.postgresql.Driver");
		dataSource.setUrl(env.getProperty("papeletas.jdbc.url"));
		dataSource.setUsername(env.getProperty("papeletas.jdbc.user"));
		dataSource.setPassword(env.getProperty("papeletas.jdbc.password"));
		return dataSource;
		
//		HikariConfig config = new HikariConfig();
//
//		config.setDataSourceClassName("org.postgresql.ds.PGSimpleDataSource");
//		// config.setDriverClassName("com.mysql.jdbc.Driver");
//
//		// config.setJdbcUrl("jdbc:mysql://localhost:3306/andro");
//		// config.setUsername("androuser");
//		// config.setPassword("androuserp");
//
//		config.setConnectionTestQuery("SELECT 1");
//
//		// config.setPoolName("springHikariCP");
//		config.setMaximumPoolSize(50);
//		config.setMaxLifetime(30000);
//		config.setIdleTimeout(30000);
//		// config.setMinimumIdle(20);
//
//		config.addDataSourceProperty("url", env.getProperty("papeletas.jdbc.url"));
//		config.addDataSourceProperty("user", env.getProperty("papeletas.jdbc.user"));
//		config.addDataSourceProperty("password",
//				env.getProperty("papeletas.jdbc.password"));
//
//		// <prop key="useUnicode">true</prop>
//		// <prop key="characterEncoding">utf-8</prop>
//
//		config.addDataSourceProperty("cachePrepStmts",
//				env.getProperty("jdbc.pool.cachePrepStmts"));
//		config.addDataSourceProperty("prepStmtCacheSize",
//				env.getProperty("jdbc.pool.prepStmtCacheSize"));
//		config.addDataSourceProperty("prepStmtCacheSqlLimit",
//				env.getProperty("jdbc.pool.prepStmtCacheSqlLimit"));
//		config.addDataSourceProperty("useServerPrepStmts",
//				env.getProperty("jdbc.pool.useServerPrepStmts"));
//
//		HikariDataSource dataSource = new HikariDataSource(config);
//
//		return dataSource;
	}

	@Bean
	public PlatformTransactionManager papeletasTransactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager
				.setEntityManagerFactory(papeletasEntityManagerFactory()
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
