package com.example.users.infrastructure.configuration;

import com.example.users.infrastructure.configuration.properties.KeycloakProperties;
import org.keycloak.OAuth2Constants;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.admin.client.resource.RealmResource;
import org.keycloak.admin.client.resource.UsersResource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KeycloakClientConfiguration {

  @Bean
  public Keycloak keycloak(KeycloakProperties keycloakProperties) {
    return KeycloakBuilder.builder()
        .serverUrl(keycloakProperties.getServerUrl())
        .realm(keycloakProperties.getRealm())
        .grantType(OAuth2Constants.CLIENT_CREDENTIALS)
        .clientId(keycloakProperties.getClientId())
        .clientSecret(keycloakProperties.getClientSecret())
        .build();
  }

  @Bean
  public RealmResource applicationRealm(Keycloak keycloak, KeycloakProperties keycloakProperties) {
    return keycloak.realm(keycloakProperties.getRealm());
  }

  @Bean
  public UsersResource usersResource(RealmResource applicationRealm) {
    return applicationRealm.users();
  }
}
