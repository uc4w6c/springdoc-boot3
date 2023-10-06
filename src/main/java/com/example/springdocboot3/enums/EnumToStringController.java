package com.example.springdocboot3.enums;

import lombok.ToString;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("enumtostring")
public class EnumToStringController {
  @PostMapping
  public String index(@RequestBody EnumToStringRequest request) {
    return request.webProxy.name();
  }

  record EnumToStringRequest(
      WebProxyEnum webProxy
  ) {}

  public enum WebProxyEnum {
    NO_PROXY("1"),
    HTTP("2"),
    HTTPS("3"),
    SOCKS("4"),
    SSH("5");

    private String code;

    WebProxyEnum(String code) {
      this.code = code;
    }

    @Override
    public String toString() {
      return code;
    }
  }
}
