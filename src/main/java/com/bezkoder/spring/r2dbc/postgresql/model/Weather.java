package com.bezkoder.spring.r2dbc.postgresql.model;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Table(name = "weather")
public class Weather {
    @Id
    @Column
    private String uuid;

    @Column
    private Integer sensorId;

    @Column
    private Float windDirection;

    @Column
    private Float windSpeed;

    @Column
    private Float temperature;

    @Column
    private Float humidity;

    @Column
    private Float pressure;

    @Column
    private Float battery;

    @Column
    private LocalDateTime dateTime;

    @Column
    private LocalDateTime creationAt;


    void prePersist(){

    }
}
