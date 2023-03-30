package com.example.springdocboot3.parameterobject;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("parameter/object")
public class ParameterObjectController {
  @Operation(summary = "Test Parameter Object Post", description = "Test")
  @ResponseStatus(HttpStatus.OK)
  @PostMapping(produces = "application/json")
  public @ResponseBody ResponseEntity<String> test2(
      @ParameterObject TestRequest testRequest) {
    return null;
  }

  /*@Schema
  record TestRequest(
      String id, String name) {}*/
  @Schema
  @NoArgsConstructor
  @Getter
  @Setter
  @ToString
  record TestRequest(
      @NotNull(message = "{document.digest.time.missing}") long id, String name) {}
}
