package com.hello.springstudy.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class HelloResponseDto {

  private Long id;
  private String name;
}
