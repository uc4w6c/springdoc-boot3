package com.example.springdocboot3.converter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("converter")
public class ConverterController {
  @GetMapping("/{userId}")
  public User doSomething(@PathVariable("userId") User user) {
    return user;
  }

  @GetMapping("object")
  public String test(@RequestBody ObjectA request) {
    return "OK!";
  }
}
