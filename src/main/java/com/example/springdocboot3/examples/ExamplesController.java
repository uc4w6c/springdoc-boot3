package com.example.springdocboot3.examples;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;

/**
 * issue: https://github.com/springdoc/springdoc-openapi/issues/2342
 * https://github.com/swagger-api/swagger-core/blob/master/modules/swagger-core/src/main/java/io/swagger/v3/core/converter/ModelConverters.java
 * を生成するときにopenapi v3.1の場合はgetInstanceの引数をtrueにする必要があった
 *
 */
@RestController
@RequestMapping("examples")
public class ExamplesController {
  @GetMapping
  public ExamplesResponse index() {
    return null;
  }

  public record ExamplesResponse(
      @Schema(description = "name", requiredMode = REQUIRED, examples = { "name" })
      String name,
      @Schema(description = "transaction subject", requiredMode = REQUIRED, example = "Hello", examples = { "Hello", "World" })
      String subject
  ) {}
}
