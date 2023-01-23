package com.hello.springstudy.api.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class HelloControllerTest {

  @Autowired
  private MockMvc mvc;

  @Test
  public void eunjiA_API_호출() throws Exception {
    String status = "OK";
    String name = "eunjiA";

    mvc.perform(get("/hello-eunjiA"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.status", is(status)))
            .andExpect(jsonPath("$.data.name", is(name)));
  }

  @Test
  public void eunjiB_API_호출() throws Exception {
    String status = "OK";
    String name = "eunjiB";

    mvc.perform(get("/hello-eunjiB"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.status", is(status)))
            .andExpect(jsonPath("$.data.name", is(name)));
  }
}