package com.example.gateway.filters;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class UserHeaderFilter implements GlobalFilter {
  @Override
  public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
    return exchange
        .getPrincipal()
        .cast(JwtAuthenticationToken.class)
        .map(
            jwtAuthenticationToken -> {
              exchange
                  .getRequest()
                  .mutate()
                  .header("User", jwtAuthenticationToken.getName())
                  .build();
              return exchange;
            })
        .flatMap(chain::filter);
  }
}
