package com.hello.springstudy.exception;

import lombok.Data;

@Data
public class ResultMsg {

  private String code = "00000000";
  private String message;
  private Object data;
}
