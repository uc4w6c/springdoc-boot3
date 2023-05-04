package com.example.springdocboot3.bugtest;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/*
@RestController
@RequestMapping("bugtest/schemanonfield")
public class SchemaNonFieldController {
  @GetMapping
  public String index(@RequestParam @Schema(maxLength = Integer.MAX_VALUE) String id) {
    return null;
  }
}
 */
