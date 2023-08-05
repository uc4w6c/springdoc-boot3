package com.example.springdocboot3.multiparam;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.web.bind.annotation.RequestParam;

public record RequestDto(
    @Schema(description = "name")
    @NotBlank(message = "'name' must not be blank") @Valid String name,
    @Schema(description = "greetings")
    @RequestParam(name = "greetings", defaultValue = "hello") String greetings
) {}
