package com.example.springdocboot3.i18;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("i18")
@Tag(name = "test")
public class I18Controller {
}
