package com.ssm.model;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
@ImportResource("classpath:/spring-config.xml")
public class DbConfig {

    @Value("${driver}")
    private String driver;

    @Value("${url}")
    private String url;

    @Value("${username}")
    private String username;

    @Value("${password}")
    private String password;

    @Bean
    public DataSource myJdbc(){

        return new DriverManagerDataSource(url,username,password);
    }

    @Bean
    public Connection dbConnection() throws ClassNotFoundException, SQLException {
        Class.forName(driver);
        return DriverManager.getConnection(url,username,password);
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        DriverManagerDataSource dataSource=new DriverManagerDataSource(url,username,password);
        dataSource.setDriverClassName(driver);
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public JdbcTemplate dbcpTemplate() {
        BasicDataSource dataSource=new BasicDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public JdbcTemplate c3p0Template() throws PropertyVetoException {
        ComboPooledDataSource dataSource=new ComboPooledDataSource();
        dataSource.setDriverClass(driver);
        dataSource.setJdbcUrl(url);
        dataSource.setUser(username);
        dataSource.setPassword(password);
        return new JdbcTemplate(dataSource);
    }

}
