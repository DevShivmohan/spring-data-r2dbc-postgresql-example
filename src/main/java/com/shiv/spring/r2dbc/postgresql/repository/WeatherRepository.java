package com.shiv.spring.r2dbc.postgresql.repository;

import com.shiv.spring.r2dbc.postgresql.model.Weather;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherRepository extends R2dbcRepository<Weather,String> {
}
