package com.example.users.infrastructure.repository;

import com.example.model.User;
import com.example.model.UsersRepository;
import com.example.users.infrastructure.repository.springdata.mongodb.SpringDataMongoDBUsersRepository;
import lombok.AllArgsConstructor;
import org.keycloak.admin.client.resource.UsersResource;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.stereotype.Repository;

import javax.ws.rs.NotFoundException;
import java.util.Optional;
import java.util.UUID;

@Repository
@AllArgsConstructor
public class MongoDBKeycloakUsersRepository implements UsersRepository {

  private final SpringDataMongoDBUsersRepository springDataMongoDBUsersRepository;
  private final UsersResource usersResource;

  @Override
  public Optional<User> findById(UUID id) {
    final var userRepresentationOptional = userRepresentationOptional(id);
    if (userRepresentationOptional.isPresent()) {
      final var userRepresentation = userRepresentationOptional.get();
      return Optional.of(
          new User(UUID.fromString(userRepresentation.getId()), userRepresentation.getUsername()));
    }
    return Optional.empty();
  }

  private Optional<UserRepresentation> userRepresentationOptional(UUID id) {
    try {
      return Optional.of(usersResource.get(id.toString()).toRepresentation());
    } catch (NotFoundException notFoundException) {
      return Optional.empty();
    }
  }
}
