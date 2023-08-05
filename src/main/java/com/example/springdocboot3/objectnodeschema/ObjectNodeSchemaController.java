package com.example.springdocboot3.objectnodeschema;

import com.fasterxml.jackson.databind.node.ObjectNode;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * https://github.com/springdoc/springdoc-openapi/issues/2333
 */
@RestController
@RequestMapping("object/node/schema")
public class ObjectNodeSchemaController {
  @PostMapping
  public ObjectNodeSchemaResponse index(@RequestBody ObjectNodeSchemaRequest objectNodeSchemaRequest) {
    return null;
  }

  public record ObjectNodeSchemaRequest(
      String name,
      @Schema(
          description = "description",
          requiredProperties = {"name", "type", "stage"},
          implementation = ObjectNodeChild.class,
          additionalProperties = Schema.AdditionalPropertiesValue.TRUE
      )
      ObjectNode attributes
  ) {}

  public record ObjectNodeSchemaResponse(
      String name,
      @Schema(
          description = "description",
          requiredProperties = {"name", "type", "stage"},
          implementation = ObjectNodeChild.class,
          additionalProperties = Schema.AdditionalPropertiesValue.TRUE
      )
      ObjectNode attributes
  ) {}

  public record ObjectNodeChild(String name, int age) {}
}
