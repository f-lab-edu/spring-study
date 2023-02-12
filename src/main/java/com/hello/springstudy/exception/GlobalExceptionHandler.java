package com.hello.springstudy.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(BusinessException.class)
  public ResponseEntity<?> handleBusinessException(BusinessException e) {
    log.error("BusinessException: ", e);
    ResultMsg resultMsg = new ResultMsg();
    resultMsg.setCode(e.getCode());
    resultMsg.setMessage(e.getMessage());
    return new ResponseEntity<>(resultMsg, HttpStatus.OK);
  }
}
