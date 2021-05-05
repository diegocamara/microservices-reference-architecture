package com.example.users.infrastructure.web.model;

import com.example.model.User;
import lombok.Data;

import java.util.UUID;

@Data
public class UserResponse {
  private UUID id;
  private String name;

  public UserResponse(User user) {
    this.id = user.getId();
    this.name = user.getName();
  }
}
