package com.example.springdocboot3.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserConverter implements Converter<String, User> {

  @Override
  public User convert(String userId) {
    User user = new User(userId);
    return user;
  }
}
