package com.example.feature;

import com.example.model.User;

import java.util.UUID;

public interface FindUserById {
  User handle(UUID id);
}
