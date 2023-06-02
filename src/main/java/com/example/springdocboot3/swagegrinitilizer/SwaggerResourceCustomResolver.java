package com.example.springdocboot3.swagegrinitilizer;

import jakarta.servlet.http.HttpServletRequest;
import org.springdoc.core.properties.SwaggerUiConfigParameters;
import org.springdoc.core.properties.SwaggerUiConfigProperties;
import org.springdoc.core.properties.SwaggerUiOAuthProperties;
import org.springdoc.core.providers.ObjectMapperProvider;
import org.springdoc.ui.AbstractSwaggerIndexTransformer;
import org.springdoc.webmvc.ui.SwaggerIndexTransformer;
import org.springdoc.webmvc.ui.SwaggerWelcomeCommon;
import org.springframework.core.io.Resource;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.CollectionUtils;
import org.springframework.web.servlet.resource.ResourceTransformerChain;
import org.springframework.web.servlet.resource.TransformedResource;

import java.io.IOException;
import java.io.InputStream;

import static org.springdoc.core.properties.SwaggerUiConfigParameters.QUERY_CONFIG_ENABLED_PROPERTY;
import static org.springdoc.core.utils.Constants.SWAGGER_INITIALIZER_JS;

public class SwaggerResourceCustomResolver extends AbstractSwaggerIndexTransformer implements SwaggerIndexTransformer {
  private static final String PRESETS = "presets: [";

  /**
   * The Swagger welcome common.
   */
  private final SwaggerWelcomeCommon swaggerWelcomeCommon;

  /**
   * Instantiates a new Swagger index transformer.
   * @param swaggerUiConfig the swagger ui config
   * @param swaggerUiOAuthProperties the swagger ui o auth properties
   * @param swaggerUiConfigParameters the swagger ui config parameters
   * @param swaggerWelcomeCommon the swagger welcome common
   * @param objectMapperProvider the object mapper provider
   */
  public SwaggerResourceCustomResolver(SwaggerUiConfigProperties swaggerUiConfig, SwaggerUiOAuthProperties swaggerUiOAuthProperties,
                                     SwaggerUiConfigParameters swaggerUiConfigParameters, SwaggerWelcomeCommon swaggerWelcomeCommon, ObjectMapperProvider objectMapperProvider) {
    super(swaggerUiConfig, swaggerUiOAuthProperties, swaggerUiConfigParameters, objectMapperProvider);
    this.swaggerWelcomeCommon = swaggerWelcomeCommon;
  }

  @Override
  public Resource transform(HttpServletRequest request, Resource resource,
                            ResourceTransformerChain transformerChain) throws IOException {

    final AntPathMatcher antPathMatcher = new AntPathMatcher();
    boolean isIndexFound = antPathMatcher.match("**/swagger-ui/**/" + SWAGGER_INITIALIZER_JS, resource.getURL().toString());

    if (isIndexFound) {
      String html = defaultTransformations(resource.getInputStream());
      return new TransformedResource(resource, html.getBytes());
    }
    else
      return resource;
  }

  @Override
  protected String defaultTransformations(InputStream inputStream) throws IOException {
    String html = readFullyAsString(inputStream);
    if (!CollectionUtils.isEmpty(swaggerUiOAuthProperties.getConfigParameters()))
      html = addInitOauth(html);

    if (swaggerUiConfig.isCsrfEnabled()) {
      if (swaggerUiConfig.getCsrf().isUseLocalStorage())
        html = addCSRFLocalStorage(html);
      else if (swaggerUiConfig.getCsrf().isUseSessionStorage())
        html = addCSRFSessionStorage(html);
      else
        html = addCSRF(html);
    }

    if (swaggerUiConfig.getSyntaxHighlight().isPresent())
      html = addSyntaxHighlight(html);

    if (swaggerUiConfig.getQueryConfigEnabled() == null || !swaggerUiConfig.getQueryConfigEnabled())
      html = addParameters(html);
    else
      html = addParameter(html, QUERY_CONFIG_ENABLED_PROPERTY, swaggerUiConfig.getQueryConfigEnabled().toString());

    if (swaggerUiConfig.isDisableSwaggerDefaultUrl())
      html = overwriteSwaggerDefaultUrl(html);

    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("onComplete: function() {\n");
    stringBuilder.append("window.ui.preauthorizeApiKey(\"api_key\", \"abcde12345\");\n");
    stringBuilder.append("},\n");
    stringBuilder.append(PRESETS);

    html = html.replace(PRESETS, stringBuilder.toString());
    return html;
  }

  private String addParameter(String html, String key, String value) {
    StringBuilder stringBuilder = new StringBuilder("window.ui = SwaggerUIBundle({\n");
    stringBuilder.append(key + ": \"" + value + "\",");
    return html.replace("window.ui = SwaggerUIBundle({", stringBuilder.toString());
  }
}
