package com.emplyee.employeedemo.config;

import io.swagger.v3.oas.models.servers.Server;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

  @Bean
  public OpenAPI customOpenAPI() {
    return new OpenAPI()
        .info(new Info()
            .title("Employee Demo API")
            .version("1.0")
            .description("API for managing Employees and Warehouse"))
        .addServersItem(new Server()
            .url("/employee-demo"));
  }
}
