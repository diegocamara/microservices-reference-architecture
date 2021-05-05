package com.example.users.infrastructure.web.controller;

import com.example.feature.FindUserById;
import com.example.users.infrastructure.web.model.UserResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UsersController {

  private final FindUserById findUserById;

  @GetMapping("/{userId}")
  public ResponseEntity<UserResponse> findUserById(@PathVariable("userId") UUID userId) {
    final var user = findUserById.handle(userId);
    return ResponseEntity.ok(new UserResponse(user));
  }
}
