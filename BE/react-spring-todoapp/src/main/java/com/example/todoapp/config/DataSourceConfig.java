package com.example.todoapp.config; // Create this package if it doesn't exist

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource; // Import this

@Configuration // Marks this class as a Spring configuration source
public class DataSourceConfig {

    @Bean // Tells Spring to create and manage a bean of type DataSource
    public DriverManagerDataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver"); // Your MySQL JDBC driver
        dataSource.setUrl("jdbc:mysql://localhost:3306/react-spring-todoapp?useSSL=false&serverTimezone=UTC"); // Your DB URL
        dataSource.setUsername("root"); // Your MySQL username
        dataSource.setPassword("@Patagnan88"); // Your MySQL password (replace with your actual password)
        return dataSource;
    }
}
