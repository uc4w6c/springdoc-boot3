package com.example.springdocboot3.jsonview;

import com.fasterxml.jackson.annotation.JsonView;

public class MealParty {
  @JsonView(Views.Private.class)
  private String id;

  @JsonView(Views.Public.class)
  private String name;

  public MealParty() {}

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  @JsonView(Views.Public.class)
  public void setName(String name) {
    this.name = name;
  }
}
