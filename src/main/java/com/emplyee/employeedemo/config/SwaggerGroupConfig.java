package com.emplyee.employeedemo.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerGroupConfig {

  @Bean
  public GroupedOpenApi regionsApi() {
    return GroupedOpenApi.builder()
        .group("Regions API")
        .pathsToMatch("/api/regions/**")
        .build();
  }

  @Bean
  public GroupedOpenApi jobsApi() {
    return GroupedOpenApi.builder()
        .group("Jobs API")
        .pathsToMatch("/api/jobs/**")
        .build();
  }
}
