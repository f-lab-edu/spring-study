package com.hello.springstudy.exception;

public class BusinessException extends RuntimeException {

  private String code = "";

  private String message = "";

  public BusinessException() {
    super();
  }

  public BusinessException(String message) {
    super(message);
    this.message = message;
  }

  public BusinessException(String code, String message) {
    super(message);
    this.code = code;
    this.message = message;
  }

  public BusinessException(Throwable cause) {
    super(cause);
  }

  public BusinessException(String message, Throwable cause) {
    super(message, cause);
    this.message = message;
  }

  public BusinessException(String code, String message, Throwable cause) {
    super(message, cause);
    this.code = code;
    this.message = message;
  }

  public String getCode() {
    return code;
  }

  public String getMessage() {
    return message;
  }
}