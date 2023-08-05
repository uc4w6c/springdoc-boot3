package com.example.springdocboot3.multiparam;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.SchemaProperty;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * https://github.com/springdoc/springdoc-openapi/issues/2276
 * springdoc.default-support-form-data: trueをつけることで発生する問題がおかしいっぽい
 * greetingsがquery paramから消えていることが問題
 */
@RestController
@RequestMapping("multi/param")
public class MultiParamController {
  @RequestMapping(path = "/{planet}/upload", method = POST, produces = APPLICATION_JSON_VALUE,
      consumes = MULTIPART_FORM_DATA_VALUE)
  @ResponseStatus(value = CREATED)
  @Operation(summary = "This method will upload a file to other planet.",
      responses = {
          @ApiResponse(responseCode = "201",
              description = "The request was successful."),
          @ApiResponse(responseCode = "400", description = "Generic failure response.")
      },
      parameters = {
          @Parameter(name = "planet",
              required = true, schema = @Schema(name = "planet", type = "string", defaultValue = "venus",
              allowableValues = {"venus","mars"}), in = ParameterIn.PATH),
          @Parameter(name = "greetings", description = "This parameter is just to example.",
              schema = @Schema(name = "greetings", type = "string"), in = ParameterIn.QUERY),
      },
      requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
          content = @Content(mediaType = MULTIPART_FORM_DATA_VALUE, schemaProperties = {
              @SchemaProperty(name = "file",
                  schema = @Schema(type = "object", implementation = MultipartFile.class,
                      requiredMode = Schema.RequiredMode.REQUIRED,
                      description = "File to be uploaded.")),
              @SchemaProperty(name = "name",
                  schema = @Schema(type = "string", requiredMode = Schema.RequiredMode.REQUIRED,
                      description = "File name to be used"))
          }))
  )
  public String test( @PathVariable("planet") final String planet,
                      @RequestParam("file") final MultipartFile file,
                      @RequestParam("name") @NotBlank(message = "'name' must not be blank") @Valid final String name,
                      @RequestParam(name = "greetings", defaultValue = "hello") final String greetings) {
    return greetings + " " + planet;
  }

  @RequestMapping(path = "/{planet}/upload2", method = POST, produces = APPLICATION_JSON_VALUE)
      // consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
  @ResponseStatus(value = CREATED)
  public String test2( @PathVariable("planet") final String planet,
                      // @RequestParam("file") final MultipartFile file,
                      @RequestParam("name") @NotBlank(message = "'name' must not be blank") @Valid final String name
                      // ,@RequestParam(name = "greetings", defaultValue = "hello") final String greetings
  ) {
    return name + " " + planet;
  }

  @RequestMapping(path = "/{planet}/upload3", method = POST, produces = APPLICATION_JSON_VALUE, consumes = MULTIPART_FORM_DATA_VALUE)
  @ResponseStatus(value = CREATED)
  public String test3( @PathVariable("planet") final String planet,
                       // @RequestParam("file") final MultipartFile file,
                       RequestDto request
  ) {
    return request.name() + " " + planet + " " + request.greetings();
  }
}
