package com.hello.springstudy.api.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class ApiExceptionControllerTest {

  @Autowired
  private MockMvc mvc;

  @Test
  @DisplayName("예외_응답_결과")
  public void callErrorResult() throws Exception {
    mvc.perform(get("/api/members/bad"))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.code", is("4xx")))
            .andExpect(jsonPath("$.message", is("잘못된 입력 값")))
            .andExpect(jsonPath("$.data", nullValue()));
  }

  @Test
  @DisplayName("정상_응답_결과")
  public void callSuccessResult() throws Exception {
    mvc.perform(get("/api/members/good"))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.code", is("00000000")))
            .andExpect(jsonPath("$.message", nullValue()))
            .andExpect(jsonPath("$.data", is("good")));
  }
}