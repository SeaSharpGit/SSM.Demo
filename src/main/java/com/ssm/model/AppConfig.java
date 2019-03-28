package com.ssm.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ImportResource("classpath:/spring-config.xml")
public class AppConfig {

    @Value("$(url)")
    private String url;

    @Value("$(username)")
    private String username;

    @Value("$(password)")
    private String password;

    @Bean
    public DataSource myJdbc(){

        return new DriverManagerDataSource(url,username,password);
    }


}
