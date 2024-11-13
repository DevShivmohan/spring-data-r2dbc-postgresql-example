package com.bezkoder.spring.r2dbc.postgresql;

import com.bezkoder.spring.r2dbc.postgresql.repository.WeatherRepository;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.web.reactive.config.EnableWebFlux;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

@EnableWebFlux
//@EnableR2dbcRepositories
@SpringBootApplication
@AllArgsConstructor
public class SpringBootR2dbcPostgresqlExampleApplication {
    private final WeatherRepository weatherRepository;

//  @Bean
//  ConnectionFactoryInitializer initializer(ConnectionFactory connectionFactory) {
//
//    ConnectionFactoryInitializer initializer = new ConnectionFactoryInitializer();
//    initializer.setConnectionFactory(connectionFactory);
//    initializer.setDatabasePopulator(new ResourceDatabasePopulator(new ClassPathResource("schema.sql")));
//
//    return initializer;
//  }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootR2dbcPostgresqlExampleApplication.class, args);
    }

    @PostConstruct
    public void read() {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        AtomicLong start = new AtomicLong(0);
        AtomicLong end = new AtomicLong(0);
        weatherRepository
                .findAll()
                .doOnNext(System.out::println)
                .doOnSubscribe(we -> start.set(System.currentTimeMillis()))
                .doOnNext(weather -> System.out.println("count " + atomicInteger.incrementAndGet()))
                .doOnComplete(() -> System.out.println("Read operation completed"))
                .doOnComplete(() -> end.set(System.currentTimeMillis()))
                .doOnComplete(() -> System.out.println("Read time " + (end.get() - start.get()) + " ms"))
                .subscribe();
    }

}
