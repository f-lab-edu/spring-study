package com.hello.springstudy.controller;

import com.hello.springstudy.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

  @GetMapping("/hello-string")
  public String helloString() {
    return "hello string...";
  }

  @GetMapping("/hello-eunji")
  public HelloResponseDto helloEunji(@RequestParam("name") String name) {
    HelloResponseDto dto = new HelloResponseDto();
    dto.setName(name);
    return dto;
  }
}
