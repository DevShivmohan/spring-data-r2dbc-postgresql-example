package com.shiv.spring.r2dbc.postgresql.service;

import com.shiv.spring.r2dbc.postgresql.model.Weather;
import com.shiv.spring.r2dbc.postgresql.repository.WeatherRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@AllArgsConstructor
public class WeatherService {
    private final WeatherRepository weatherRepository;

    public Flux<Weather> findAll(){
        return weatherRepository.findAll();
    }
}
