package com.example.springdocboot3.multigroup;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MultiGroupController {
  @GetMapping("c1")
  public String index() {
    return null;
  }
  @GetMapping("c2")
  public String index2() {
    return null;
  }
  @GetMapping("c3")
  public String index3() {
    return null;
  }
  @GetMapping("c4")
  public String index4() {
    return null;
  }
}
