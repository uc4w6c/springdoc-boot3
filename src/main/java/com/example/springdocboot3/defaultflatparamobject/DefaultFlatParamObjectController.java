package com.example.springdocboot3.defaultflatparamobject;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * https://github.com/springdoc/springdoc-openapi/issues/2363
 */
@RestController
@RequestMapping("defaultflatparmobject")
public class DefaultFlatParamObjectController {
  @GetMapping
  public String query(@Valid DefaultFlatParamObjectQuery query) {
    return "query:" + query;
  }

  record DefaultFlatParamObjectQuery(int id, String name, int age) {}
}
