package org.freeplace.cloudide.configuration.persistence;

import java.util.Properties;
import javax.sql.DataSource;
import org.freeplace.cloudide.applicationinfo.ApplicationData;
import org.freeplace.cloudide.applicationinfo.Path;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.ImprovedNamingStrategy;
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
@ComponentScan(ApplicationData.APPLICATION_FULL_NAME)
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
    public static final String PROPERTY_USE_SECOND_LEVEL_CACHE = "hibernate.cache.use_second_level_cache";
    public static final String PROPERTY_USE_QUERY_CACHE = "hibernate.cache.use_query_cache";
    public static final String PROPERTY_CACHE_REGION_FACTORY_CLASS = "hibernate.cache.region.factory_class";
    public static final String PROPERTY_EHCACHE_CONFIGURATION_RESOURCE_NAME = "net.sf.ehcache.configurationResourceName";

    @Autowired
    private Environment environment;

    @Bean
    @Autowired
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan(new String[]{ApplicationData.PACKAGE_MODEL});
        sessionFactory.setHibernateProperties(getProperties());
        sessionFactory.setNamingStrategy(new ImprovedNamingStrategy());
        return sessionFactory;
    }

    private Properties getProperties() {
        Properties properties = new Properties();
        properties.put(PROPERTY_HIBERNATE_DIALECT, environment.getRequiredProperty(PROPERTY_HIBERNATE_DIALECT));
        properties.put(PROPERTY_HIBERNATE_SHOW_SQL, environment.getRequiredProperty(PROPERTY_HIBERNATE_SHOW_SQL));
        properties.put(PROPERTY_HIBERNATE_FORMAT_SQL, environment.getRequiredProperty(PROPERTY_HIBERNATE_FORMAT_SQL));
        properties.put(PROPERTY_HIBERNATE_HBM2DDL, environment.getRequiredProperty(PROPERTY_HIBERNATE_HBM2DDL));
     //   properties.put(PROPERTY_USE_SECOND_LEVEL_CACHE, environment.getRequiredProperty(PROPERTY_USE_SECOND_LEVEL_CACHE));
     //   properties.put(PROPERTY_USE_QUERY_CACHE, environment.getRequiredProperty(PROPERTY_USE_QUERY_CACHE));
      //  properties.put(PROPERTY_CACHE_REGION_FACTORY_CLASS, environment.getRequiredProperty(PROPERTY_CACHE_REGION_FACTORY_CLASS));
      //  properties.put(PROPERTY_EHCACHE_CONFIGURATION_RESOURCE_NAME, environment.getRequiredProperty(PROPERTY_EHCACHE_CONFIGURATION_RESOURCE_NAME));
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
