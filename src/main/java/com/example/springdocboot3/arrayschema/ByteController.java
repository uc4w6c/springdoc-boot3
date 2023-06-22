package com.example.springdocboot3.arrayschema;

import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * https://github.com/springdoc/springdoc-openapi/issues/2275
 */
@RestController
@RequestMapping("array/schema/byte")
public class ByteController {
  @GetMapping
  public Response index() {
    return null;
  }

  public record Response(
      @Schema(description = "foo")
      byte[] content,

      @ArraySchema(arraySchema = @Schema(description = "foo2"))
      byte[] content2,

      @Schema(description = "foo", type = "string", format = "byte")
      byte[] content3
  ) {}
}
