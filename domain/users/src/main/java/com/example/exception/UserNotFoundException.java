package com.example.exception;

public class UserNotFoundException extends BusinessException {
  public UserNotFoundException() {
    super("User not found");
  }
}
