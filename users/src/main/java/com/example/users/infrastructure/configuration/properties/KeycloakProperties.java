package com.example.users.infrastructure.configuration.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "keycloak")
public class KeycloakProperties {
  private String serverUrl;
  private String realm;
  private String username;
  private String password;
  private String clientId;
  private String clientSecret;
  private String grantType;
  private String authorization;
}
