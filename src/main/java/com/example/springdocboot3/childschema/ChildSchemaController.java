package com.example.springdocboot3.childschema;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * https://github.com/springdoc/springdoc-openapi/issues/2238
 */
@RestController
@RequestMapping("child/schema")
public class ChildSchemaController {
  @GetMapping
  public ParentDto index() {
    return null;
  }

  public class ParentDto {
    @Schema(title = "parent1 title", description = "parent1 description")
    private ChildDto childDto1;
    @Schema(title = "parent2 title", description = "parent2 description")
    private ChildDto childDto2;

    public ChildDto getChildDto1() {
      return childDto1;
    }

    public ChildDto getChildDto2() {
      return childDto2;
    }
  }

  // @Schema(title = "child title", description = "child description")
  public class ChildDto {
    private String name;

    public String getName() {
      return name;
    }
  }
}
