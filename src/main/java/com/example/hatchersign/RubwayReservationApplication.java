package com.example.hatchersign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

@SpringBootApplication
@Component
@EnableScheduling
public class RubwayReservationApplication {

    public static void main(String[] args) {
        SpringApplication.run(RubwayReservationApplication.class, args);
    }

}
