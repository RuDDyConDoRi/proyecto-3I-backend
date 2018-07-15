package com.ctr.iii.dao.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.*;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan({ "com.ctr.iii" })
@EnableJpaRepositories(basePackages = { "com.ctr.iii.dao" })
@PropertySource({ "classpath:config.properties" })
public class DataConfig {
	@Autowired
	private Environment env;

	@Bean(name = "dataSource")
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(env.getProperty("database.connection.driver"));
		dataSource.setUrl(env.getProperty("database.connection.url"));
		dataSource.setUsername(env.getProperty("database.connection.user"));
		dataSource.setPassword(env.getProperty("database.connection.password"));
		return dataSource;
	}

	@Bean(name = "entityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {
		LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
		factoryBean.setDataSource(dataSource());
		factoryBean.setPackagesToScan(new String[] { "com.ctr.iii" });
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setShowSql(true);
		factoryBean.setJpaVendorAdapter(vendorAdapter);
		factoryBean.setJpaProperties(additionalProperties());
		return factoryBean;
	}

	@Bean(name = "transactionManager")
	public PlatformTransactionManager transactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactoryBean().getObject());
		return transactionManager;
	}

	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}

	Properties additionalProperties() {
		return new Properties() {
			private static final long serialVersionUID = 1L;

			{
				setProperty("hibernate.dialect", env.getProperty("database.hibernate.dialect"));
				setProperty("hibernate.show_sql", env.getProperty("database.hibernate.show_sql"));
				setProperty("hibernate.format_sql", env.getProperty("database.hibernate.format_sql"));
				setProperty("hibernate.use_sql_comments", env.getProperty("database.hibernate.use_sql_comments"));
			}
		};
	}
}
