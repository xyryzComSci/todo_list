package com.example.todoapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class SpringHibernateJpaApplication {


    public static void main(String[] args) {
        SpringApplication.run(SpringHibernateJpaApplication.class, args);
    }

}