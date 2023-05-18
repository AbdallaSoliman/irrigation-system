package com.banquemisr.irrigationsystem;

import io.swagger.v3.oas.annotations.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.*;

@SpringBootApplication
@OpenAPIDefinition
@EnableScheduling
public class IrrigationSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(IrrigationSystemApplication.class, args);
	}

}
