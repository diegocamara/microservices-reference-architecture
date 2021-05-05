package com.example.gateway;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractNameValueGatewayFilterFactory;
import org.springframework.stereotype.Component;

@Component
public class JwtExtractorFilter extends AbstractNameValueGatewayFilterFactory {

  @Override
  public GatewayFilter apply(NameValueConfig config) {
    return (exchange, chain) -> chain.filter(exchange);
  }
}
