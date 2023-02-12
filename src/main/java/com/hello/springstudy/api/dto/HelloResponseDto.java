package com.hello.springstudy.api.dto;

import lombok.*;
import org.springframework.util.Assert;

@Getter
public class HelloResponseDto {
  private Long id;
  private String name;
  private String role;

  @Builder
  public HelloResponseDto(Long id, String name, String role) {
    Assert.notNull(id, "id must not be null");
    Assert.notNull(name, "name must not be null");
    this.id = id;
    this.name = name;
    this.role = role;
  }
}
