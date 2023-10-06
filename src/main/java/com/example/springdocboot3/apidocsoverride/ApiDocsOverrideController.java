package com.example.springdocboot3.apidocsoverride;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * https://github.com/springdoc/springdoc-openapi/issues/2341
 */
@Controller
public class ApiDocsOverrideController {
  @GetMapping("/test/v3/api-docs/{param}")
  public String forwardV3ApiDocsParam(@PathVariable String param) {
    return "redirect:/v3/api-docs/" + param;
  }

  @GetMapping(value = {"/test/v3/api-docs", "/test/v3/api-docs/default"})
  public String forwardV3ApiDocs() {
    return "redirect:/v3/api-docs";
  }
}
