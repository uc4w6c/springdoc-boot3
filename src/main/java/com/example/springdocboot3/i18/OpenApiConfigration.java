package com.example.springdocboot3.i18;

import org.springdoc.core.customizers.OpenApiLocaleCustomizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

/**
 * debug: https://github.com/springdoc/springdoc-openapi/issues/2299
 * Localeがjaだけのときの動きを確認
 */
//@Configuration
//public class OpenApiConfigration {
//  @Autowired
//  private MessageSource messageSource;
//
//  @Bean
//  public OpenApiLocaleCustomizer openApiLocaleCustomizer() {
//    return (openAPI, locale)
//        -> openAPI.getInfo().title(messageSource.getMessage("test", null, locale));
//  }
//}
