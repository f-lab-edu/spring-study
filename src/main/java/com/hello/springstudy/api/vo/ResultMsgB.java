package com.hello.springstudy.api.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Builder
@Data
@AllArgsConstructor
public class ResultMsgB {

  private final Enum status = HttpStatus.OK;
  private Object data;

  public static ResultMsgB resultMsg(Object data) {
    return ResultMsgB.builder()
            .data(data)
            .build();
  }
}
