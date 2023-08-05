package com.example.springdocboot3.replacewithclass.stringvalue;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * https://github.com/springdoc/springdoc-openapi/issues/2285
 */
@RestController
@RequestMapping("replacewithclass/stringvalue")
public class StringValueController {
  static {
    // SpringDocUtils.getConfig().replaceWithClass(ReplaceWithClassController.ReplaceWithClass.class, String.class);
  }

  @PostMapping
  public String hello(@RequestBody DemoRequest request) {
    return "Hello " + request.getName().getValue();
  }

  @Schema(description = "other desc", example = "other example", type = "string")
  public static class StringValueObject {
    private String value;

    public StringValueObject(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }
  }

  public static class DemoRequest {
    @Schema(description = "other desc", example = "other example", type = "string")
    private StringValueObject name;

    @Schema(ref = "")
    private StringValueObject name2;

    public DemoRequest(StringValueObject name, StringValueObject name2) {
      this.name = name;
      this.name2 = name2;
    }

    public StringValueObject getName() {
      return name;
    }

    public StringValueObject getName2() {
      return name2;
    }
  }
}
