package com.example.feature.impl;

import com.example.exception.UserNotFoundException;
import com.example.feature.FindUserById;
import com.example.model.User;
import com.example.model.UsersRepository;
import lombok.AllArgsConstructor;

import javax.inject.Named;
import java.util.UUID;

@Named
@AllArgsConstructor
public class FindUserByIdImpl implements FindUserById {

  private final UsersRepository usersRepository;

  @Override
  public User handle(UUID id) {
    return usersRepository.findById(id).orElseThrow(UserNotFoundException::new);
  }
}
