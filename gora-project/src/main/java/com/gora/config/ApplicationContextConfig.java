package com.gora.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("com.gora.*")
@EnableTransactionManagement
// Load to Environment
@PropertySource("classpath:spring/hibernateCfg.properties")
@EnableJpaRepositories("com.gora.dao")
public class ApplicationContextConfig {

	// The Environment class serves as the property holder
	// and stores all the properties loaded by the @PropertySource

	@Autowired
	Environment env;

	@Autowired
	@Bean(name = "dataSource")
	public DataSource getDataSource() {

		DriverManagerDataSource dataSource = new DriverManagerDataSource();

		dataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
		dataSource.setUrl(env.getProperty("jdbc.url"));
		dataSource.setUsername(env.getProperty("jdbc.user"));
		dataSource.setPassword(env.getProperty("jdbc.pass"));

		System.out.println("## getDataSource: " + dataSource);

		return dataSource;
	}

	public Properties hibernateProperties() {

		Properties properties = new Properties();

		// See: hibernateCfg.properties
		properties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
		properties.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
		//properties.put("hibernate.hbm2ddl.auto",
		//env.getProperty("hibernate.hbm2ddl.auto"));

		return properties;

	}

	
//	@Bean(name = "sessionFactory")
//	public SessionFactory getSessionFactory(DataSource dataSource) throws IOException {
//
//		LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
//
//		factoryBean.setPackagesToScan(new String[] { "com.gora.domain" });
//		factoryBean.setDataSource(dataSource);
//		factoryBean.setHibernateProperties(hibernateProperties());
//		factoryBean.afterPropertiesSet();
//
//		System.out.println("## factoryBean: " + factoryBean);
//		System.out.println("## dataSource: " + dataSource);
//
//		SessionFactory sessionFactory = factoryBean.getObject();
//
//		System.out.println("## getSessionFactory: " + sessionFactory);
//		return sessionFactory;
//	}
	
	@Bean(name="entityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityFactoryManager() {
		LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
		
		entityManagerFactory.setDataSource(getDataSource());
		entityManagerFactory.setPackagesToScan(new String[] {"com.gora.domain"});
		
		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
			
		entityManagerFactory.setJpaVendorAdapter(vendorAdapter);
		entityManagerFactory.setJpaProperties(hibernateProperties());
		
		return entityManagerFactory;
	}

	
//	@Bean(name = "transactionManager")
//	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
//
//		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
//
//		return transactionManager;
//	}
	
	@Bean(name="transactionManager")
	public JpaTransactionManager getTransactionManager(EntityManagerFactory entityManagerFactory) {
		
		return new JpaTransactionManager(entityManagerFactory);
	}
}
