package com.example.springdocboot3.requestparamrequired;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("requestparamrequired")
public class RequestParamRequiredController {
  @GetMapping
  public String index(@RequestParam(required = true) String code, @RequestParam(required = false) String id) {
    return code + id;
  }

  @GetMapping(value = "/code", produces = MediaType.APPLICATION_JSON_VALUE)
  public String searchByCode(@RequestParam(required = true) String code, @RequestParam(required = false) String locale,
                                      @RequestParam(required = false) Double latitude, @RequestParam(required = false) Double longitude,
                                      @RequestParam(required = false) Double distanceInKm) throws Exception {
    return null;
  }
}
