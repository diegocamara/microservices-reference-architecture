package com.example.gateway.configuration;

import com.example.gateway.configuration.properties.ServicesProperties;
import lombok.AllArgsConstructor;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class RoutesConfiguration {

  private final ServicesProperties servicesProperties;

  @Bean
  public RouteLocator routeLocator(RouteLocatorBuilder routeLocatorBuilder) {
    return routeLocatorBuilder
        .routes()
        .route(
            predicateSpec -> predicateSpec.path("/users/**").uri(servicesProperties.getUsersUri()))
        .build();
  }
}
