package org.freeplace.cloudide.configuration.persistence;

import java.util.Properties;

import javax.sql.DataSource;

import org.freeplace.cloudide.applicationinfo.ApplicationData;
import org.freeplace.cloudide.applicationinfo.Path;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by Ruslan on 02.12.2015.
 */
@Configuration
@EnableTransactionManagement
@ComponentScan({ ApplicationData.PACKAGE_CONFIGURATION })
@PropertySource(value = { Path.CLASSPATH + ":application.properties" })
public class PersistenceConfig {

    public static final String PROPERTY_JDBC_DRIVER = "jdbc.driverClassName";
    public static final String PROPERTY_JDBC_URL = "jdbc.url";
    public static final String PROPERTY_JDBC_USERNAME = "jdbc.username";
    public static final String PROPERTY_JDBC_PASSWORD = "jdbc.password";
    public static final String PROPERTY_HIBERNATE_DIALECT = "hibernate.dialect";
    public static final String PROPERTY_HIBERNATE_SHOW_SQL = "hibernate.show_sql";
    public static final String PROPERTY_HIBERNATE_FORMAT_SQL = "hibernate.format_sql";
    public static final String PROPERTY_HIBERNATE_HBM2DDL = "hibernate.hbm2ddl.auto";

    @Autowired
    private Environment environment;

    @Bean
    @Autowired
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan(new String[] { ApplicationData.PACKAGE_MODEL });
        sessionFactory.setHibernateProperties(getProperties());
        return sessionFactory;
    }

    private Properties getProperties() {
        Properties properties = new Properties();
        properties.put(PROPERTY_HIBERNATE_DIALECT, environment.getRequiredProperty(PROPERTY_HIBERNATE_DIALECT));
        properties.put(PROPERTY_HIBERNATE_SHOW_SQL, environment.getRequiredProperty(PROPERTY_HIBERNATE_SHOW_SQL));
        properties.put(PROPERTY_HIBERNATE_FORMAT_SQL, environment.getRequiredProperty(PROPERTY_HIBERNATE_FORMAT_SQL));
        properties.put(PROPERTY_HIBERNATE_HBM2DDL, environment.getRequiredProperty(PROPERTY_HIBERNATE_HBM2DDL));
        return properties;
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getRequiredProperty(PROPERTY_JDBC_DRIVER));
        dataSource.setUrl(environment.getRequiredProperty(PROPERTY_JDBC_URL));
        dataSource.setUsername(environment.getRequiredProperty(PROPERTY_JDBC_USERNAME));
        dataSource.setPassword(environment.getRequiredProperty(PROPERTY_JDBC_PASSWORD));
        return dataSource;
    }

    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory s) {
        HibernateTransactionManager txManager = new HibernateTransactionManager();
        txManager.setSessionFactory(s);
        return txManager;
    }
}
