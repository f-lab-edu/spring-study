package com.hello.springstudy.api.controller;

import com.hello.springstudy.exception.BusinessException;
import com.hello.springstudy.exception.ResultMsg;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class ApiExceptionController {

  @GetMapping("/api/members/{id}")
  public ResponseEntity<ResultMsg> getMember(@PathVariable("id") String id) {
    try {
      if (id.equals("bad")) {
        throw new IllegalArgumentException("잘못된 입력 값");
      }
    } catch (RuntimeException e) {
      throw new BusinessException("4xx", e.getMessage(), e);
    }
    ResultMsg resultMsg = new ResultMsg();
    resultMsg.setData(id);
    return ResponseEntity
            .ok()
            .body(resultMsg);
  }
}
