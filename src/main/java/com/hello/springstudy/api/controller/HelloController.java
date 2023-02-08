package com.hello.springstudy.api.controller;

import com.hello.springstudy.api.dto.HelloResponseDto;
import com.hello.springstudy.api.vo.ResultMsgA;
import com.hello.springstudy.api.vo.ResultMsgB;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

  @GetMapping("/hello-eunjiA")
  public ResponseEntity<ResultMsgA> helloEunjiA() {
    HelloResponseDto helloResponseDto = HelloResponseDto.builder()
            .id(1L)
            .name("eunjiA")
            .build();
    return ResponseEntity
            .ok()
            .body(ResultMsgA.resultMsg(HttpStatus.OK, helloResponseDto));
  }

  @GetMapping("/hello-eunjiB")
  public ResponseEntity<ResultMsgB> helloEunjiB() {
    HelloResponseDto helloResponseDto = HelloResponseDto.builder()
            .id(2L)
            .name("eunjiB")
            .build();
    return ResponseEntity
            .ok()
            .body(ResultMsgB.resultMsg(helloResponseDto));
  }

  @GetMapping("/hello-eunjiC")
  public ResponseEntity<ResultMsgB> helloEunjiC() {
    HelloResponseDto helloResponseDto = HelloResponseDto.builder()
            .role("DEV")
            .name("eunjiC")
            .build();
    return ResponseEntity
            .ok()
            .body(ResultMsgB.resultMsg(helloResponseDto));
  }

  @ResponseStatus(HttpStatus.CREATED)
  @GetMapping("/hello-eunjiD")
  public HelloResponseDto helloEunjiD() {
    HelloResponseDto helloResponseDto = HelloResponseDto.builder()
            .id(3L)
            .role("DEV")
            .build();
    return helloResponseDto;
  }
}