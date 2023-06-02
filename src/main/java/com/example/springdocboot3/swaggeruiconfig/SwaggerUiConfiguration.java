package com.example.springdocboot3.swaggeruiconfig;

import org.springdoc.core.properties.SwaggerUiConfigProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

// @Configuration
public class SwaggerUiConfiguration {
  // @Bean//(name = "swaggerUiConfig")
  // @Primary
  public SwaggerUiConfigProperties swaggerUiConfig(SwaggerUiConfigProperties config) {
    // config.setShowCommonExtensions(true);
    // config.setQueryConfigEnabled(true);
    config.setUrl("/doc.yaml");
    return config;
  }
}
