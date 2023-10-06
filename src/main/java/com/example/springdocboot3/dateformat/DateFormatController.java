package com.example.springdocboot3.dateformat;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

/**
 * https://github.com/springdoc/springdoc-openapi/issues/2356
 */
@RestController
@RequestMapping("dateformat")
public class DateFormatController {
  @GetMapping
  public DateFormatResponse index() {
    return new DateFormatResponse(LocalDate.now(), LocalDate.now());
  }

  record DateFormatResponse(
      @Schema(
          type = "string",
          format = "date",
          example = "20230203",
          pattern = "yyyyMMdd"
      )
      @JsonFormat(pattern="yyyyMMdd")
      LocalDate myDate,
      @Schema(
          type = "string",
          example = "20230203",
          pattern = "yyyyMMdd"
      )
      @JsonFormat(pattern="yyyyMMdd")
      LocalDate customDate
  ) {}
}
