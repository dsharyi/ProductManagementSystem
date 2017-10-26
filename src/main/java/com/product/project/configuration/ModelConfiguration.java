package com.product.project.configuration;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;


@Configuration
@ComponentScan(value = {"com.product.project.dao", "com.product.project.services"})
@PropertySource("classpath:hibernate.properties")
@EnableTransactionManagement
public class ModelConfiguration {

    @Value("${db.url}")
    private String url;
    @Value("${db.username}")
    private String userName;
    @Value("${db.password}")
    private String password;
    @Value("${db.driver}")
    private String driver;
    @Value("${db.dialect}")
    private String dialect;
    @Value("${hibernate.show_sql}")
    private String showSql;
    @Value("${hibernate.format_sql}")
    private String formatSql;
    @Value("${hibernate.hbm2ddl.auto}")
    private String hbm2ddlAuto;
    @Value("${hibernate.enable_lazy_load_no_trans}")
    private String enableLazyLoadOnTrans;
    @Value("${current_session_context_class}")
    private String currentSessionContextClass;
    @Value("${hibernate.connection.charSet}")
    private String charSet;
    @Value("${connection.characterEncoding}")
    private String characterEncoding;

    //Data source for local tomcat server
    @Bean(destroyMethod = "close")
    public BasicDataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl(url);
        dataSource.setUsername(userName);
        dataSource.setPassword(password);
        dataSource.setDriverClassName(driver);
        return dataSource;
    }

    @Bean
    public Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", dialect);
        properties.put("hibernate.show_sql", showSql);
        properties.put("hibernate.format_sql", formatSql);
        properties.put("hibernate.hbm2ddl.auto", hbm2ddlAuto);
        properties.put("hibernate.enable_lazy_load_no_trans", enableLazyLoadOnTrans);
        properties.put("current_session_context_class", currentSessionContextClass);
        properties.put("hibernate.connection.charSet", charSet);
        properties.put("connection.characterEncoding", characterEncoding);
        return properties;
    }

    @Bean
    @Scope(value = "singleton")
    public LocalSessionFactoryBean sessionFactory(DataSource dataSource) {
        LocalSessionFactoryBean bean = new LocalSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setPackagesToScan("com.product.project.entities");
        bean.setHibernateProperties(hibernateProperties());
        return bean;
    }

    @Autowired
    @Bean
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
        return new HibernateTransactionManager(sessionFactory);
    }

}