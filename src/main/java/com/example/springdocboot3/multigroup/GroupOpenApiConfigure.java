package com.example.springdocboot3.multigroup;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * https://stackoverflow.com/questions/75910090/swagger-not-working-properly-with-sb-3-springdoc-2-when-using-groupedopenapi
 * 再現せず
 */
// @Configuration
public class GroupOpenApiConfigure {
  private GroupedOpenApi getGroupedOpenApi(String category) {
    GroupedOpenApi group = GroupedOpenApi.builder()
        .group(category)
        .pathsToMatch(String.format("/%s/**", category))
        .build();
    return group;
  }

//  @Bean public GroupedOpenApi c1OpenApi() { return getGroupedOpenApi("c1"); }
//  @Bean public GroupedOpenApi c2OpenApi() { return getGroupedOpenApi("c2"); }
//  @Bean public GroupedOpenApi c3OpenApi() { return getGroupedOpenApi("c3"); }
//  @Bean public GroupedOpenApi c4OpenApi() { return getGroupedOpenApi("c4"); }
}
