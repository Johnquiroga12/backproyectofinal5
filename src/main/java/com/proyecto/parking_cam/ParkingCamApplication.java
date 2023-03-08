package com.proyecto.parking_cam;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition
public class ParkingCamApplication {

    public static void main(String[] args) {
        SpringApplication.run(ParkingCamApplication.class, args);
    }

}
