package com.example.springdocboot3.arrayschema;

import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * https://stackoverflow.com/questions/75877743/how-to-specify-type-for-a-list
 */
@RestController
@RequestMapping("array/schema/")
public class ArraySchemaController {
  @GetMapping
  public Response index() {
    return null;
  }

  record Response(
      @ArraySchema(schema = @Schema(description = "List of duplicate person"))
      List<DuplicatePersonName> duplicatePersons
  ) {}

  record DuplicatePersonName(String name, String id) {}
}
