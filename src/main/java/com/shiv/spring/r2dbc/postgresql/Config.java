//package com.shiv.spring.r2dbc.postgresql;
//
//import io.r2dbc.spi.ConnectionFactory;
//import org.springframework.boot.r2dbc.ConnectionFactoryBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//
//
//@Configuration
//public class Config {
//
//    @Primary
//    @Bean
//    public ConnectionFactory connectionFactory() {
//        return ConnectionFactoryBuilder.withUrl("r2dbc:postgresql://localhost:5432/aws_sgs_db")
//                .username("postgres")
//                .password("Ninja@13")
//                .build();
//    }
//}
