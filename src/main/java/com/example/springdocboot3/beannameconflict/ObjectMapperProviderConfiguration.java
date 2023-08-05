package com.example.springdocboot3.beannameconflict;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ObjectMapperProviderConfiguration {
  @Bean(name = "testObjectMapperProvider")
  public ObjectMapperProvider objectMapperProvider() {
    return new ObjectMapperProvider();
  }
}
