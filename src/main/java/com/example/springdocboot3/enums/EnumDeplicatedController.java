package com.example.springdocboot3.enums;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("enums/deplicated")
public class EnumDeplicatedController {
  @GetMapping
  public MyClass testEndpoint() {
    return null;
  }

  @Schema(enumAsRef = true, title = "テスト")
  public enum TestEnum {
    VAL1, VAL2
  }

  public record MyClass(
      @Schema(title = "テスト1") TestEnum field1,
      @Schema(title = "テスト2", deprecated = true) TestEnum field2,
      @Schema(title = "person1") Person person1,
      @Schema(title = "person2", deprecated = true) Person person2
  ) {
  }

  @Schema(title = "person")
  public record Person(String name){}
}
