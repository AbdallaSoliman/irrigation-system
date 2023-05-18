package com.banquemisr.irrigationsystem.config;

import io.swagger.v3.oas.models.*;
import io.swagger.v3.oas.models.info.*;
import org.springframework.context.annotation.*;

@Configuration
@Profile({"!prod"})
public class OpenApiConfig   {

  @Bean
  public OpenAPI springShopOpenAPI() {

    return new OpenAPI()
        .info(new Info().title("Irrigation System API").description("As a irrigation system which helps the automatic irrigation of agricultural lands without human intervention, system has to\n" +
                "be designed to fulfil the requirement of maintaining and configuring the plots of land by the irrigation time slots and the\n" +
                "amount of water required for each irrigation period.\n" +
                "The irrigation system should have integration interface with a sensor device to direct letting the sensor to irrigate based on\n" +
                "the configured time slots/amount of water.")
                .version("v0.0.1"));
  }
}
