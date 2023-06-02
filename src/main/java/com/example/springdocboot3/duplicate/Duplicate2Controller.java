package com.example.springdocboot3.duplicate;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.constraints.NotNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * https://github.com/springdoc/springdoc-openapi/issues/2236
 * @see <a href="https://github.com/springdoc/springdoc-openapi/commit/0463681590754224fec124f3a3169a886ee4df11#diff-477689aa4a827d0fcc840ccb95f3288b2f2318700e7f5b293e13875200461b11">参考</a>
 */
@RestController
@RequestMapping("duplicate2")
public class Duplicate2Controller {
  @GetMapping(value = "/{id}", params = "name")
  @Operation(description = "check duplicate")
  public String findDuplicatePerson(@PathVariable Long id, @RequestParam String name) {
    return "id:" + id.toString() + ", name:" + name;
  }

  @GetMapping("/{id}")
  @Operation(description = "Get person by its id")
  public String findPersonById(@PathVariable @NotNull Long id) {
    return id.toString();
  }
}
