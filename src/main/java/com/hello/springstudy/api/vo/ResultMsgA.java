package com.hello.springstudy.api.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class ResultMsgA<T> {

  private Enum status;
  private T data;

  public ResultMsgA(Enum status) {
    this.status = status;
    this.data = null;
  }

  public static <T> ResultMsgA<T> resultMsg(Enum status) {
    return resultMsg(status, null);
  }

  public static <T> ResultMsgA<T> resultMsg(Enum status, T t) {
    return ResultMsgA.<T>builder()
            .status(status)
            .data(t)
            .build();
  }
}
