package com.example.model;

import java.util.Optional;
import java.util.UUID;

public interface UsersRepository {
  Optional<User> findById(UUID id);
}
