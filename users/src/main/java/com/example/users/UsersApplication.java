package com.example.users;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.example.users", "com.example.feature"})
public class UsersApplication {

  public static void main(String[] args) {
    SpringApplication.run(UsersApplication.class, args);
  }
}
