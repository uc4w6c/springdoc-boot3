package com.example.springdocboot3.bugtest;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springdoc.core.annotations.ParameterObject;
import org.springdoc.core.properties.SpringDocConfigProperties;
import org.springdoc.core.properties.SwaggerUiConfigParameters;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("butest")
public class ParameterObjectRequiredModeController {
  private SwaggerUiConfigParameters swaggerUiConfigParameters;

  public ParameterObjectRequiredModeController(SwaggerUiConfigParameters swaggerUiConfigParameters) {
    this.swaggerUiConfigParameters = swaggerUiConfigParameters;
  }

  @GetMapping
  public String index(@ParameterObject Request request) {
    System.out.println(swaggerUiConfigParameters);
    return null;
  }

  record Request(
      @Schema(requiredMode = Schema.RequiredMode.REQUIRED)
      String id
  ) {}
}
