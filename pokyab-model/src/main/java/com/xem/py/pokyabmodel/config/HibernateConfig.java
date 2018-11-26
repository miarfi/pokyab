package com.xem.py.pokyabmodel.config;

/**
 *
 * @author arria
 */

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages={"com.xem.py.pokyabmodel.dto","com.xem.py.pokyabmodel.view"})
@EnableTransactionManagement
public class HibernateConfig {

	/*
        H2
	private static final String DATABASE_URL = "jdbc:h2:tcp://localhost/~/pokyab";
	private static final String DATABASE_DRIVER = "org.h2.Driver";
	private static final String DATABASE_DIALECT = "org.hibernate.dialect.H2Dialect";
	private static final String DATABASE_USERNAME = "sa";
	private static final String DATABASE_PASSWORD = "";
        */
    	/*
        Mysql
        private static final String DATABASE_URL = "jdbc:mariadb://localhost:3306/mysql";
	private static final String DATABASE_DRIVER = "org.mariadb.jdbc.Driver";
	private static final String DATABASE_DIALECT = "org.hibernate.dialect.MariaDB53Dialect";
	private static final String DATABASE_USERNAME = "root";
	private static final String DATABASE_PASSWORD = "mariadb";*/
    
        //Mariadb
//        SET GLOBAL time_zone = '+00:00';
//        SET SESSION time_zone = '+00:00';
//        SELECT @@global.time_zone, @@session.time_zone
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/test";
//	private static final String DATABASE_DRIVER = "com.mysql.jdbc.Driver";	
        private static final String DATABASE_DRIVER = "com.mysql.cj.jdbc.Driver";	        
        private static final String DATABASE_DIALECT = "org.hibernate.dialect.MySQL57InnoDBDialect";
	private static final String DATABASE_USERNAME = "root";
	private static final String DATABASE_PASSWORD = "mariadb";
        

	@Bean("dataSource")
	public DataSource getDataSource(){
		BasicDataSource dataSource = new BasicDataSource();
		
		dataSource.setDriverClassName(DATABASE_DRIVER);
		dataSource.setUrl(DATABASE_URL);
		dataSource.setUsername(DATABASE_USERNAME);		
		dataSource.setPassword(DATABASE_PASSWORD);
		
		return dataSource;
	}

	@Bean
	public SessionFactory getSessionFactory(DataSource dataSource){
		
		LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource);
		builder.addProperties(getHibernateProperties());
		builder.scanPackages("com.xem.py.pokyabmodel.dto","com.xem.py.pokyabmodel.view");
		return builder.buildSessionFactory();
	}

	//All the hibernate properties will be returned
	private Properties getHibernateProperties() {
		
		Properties properties = new Properties();
		
		properties.put("hibernate.dialect", DATABASE_DIALECT);
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.format_sql", "true");		
		properties.put("hibernate.hbm2ddl.auto", "update");//create|update
		return properties;
	}

	@Bean
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory){
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		return transactionManager;
	}
	
	
}
