package com.example.springdocboot3.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
class BToAConvertor implements Converter<ObjectB, ObjectA> {
  @Override
  public ObjectA convert(ObjectB source) {
    return new ObjectA(source.id(), "name");
  }
}
