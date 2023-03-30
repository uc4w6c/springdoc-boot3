package com.example.springdocboot3.jsonview;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("json/view")
public class JsonViewController {
  @PostMapping
  @JsonView(Views.Public.class)
  public String create(
      @RequestBody @JsonView(Views.Public.class) MealParty value) {
    return null;
  }
}
