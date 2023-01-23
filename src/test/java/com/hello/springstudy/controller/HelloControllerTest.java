package com.hello.springstudy.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.is;

@WebMvcTest
public class HelloControllerTest {

  @Autowired
  private MockMvc mvc;

  @Test
  public void hello_string이_리턴된다() throws Exception {
    String helloString = "hello string...";

    mvc.perform(get("/hello-string"))
            .andExpect(status().isOk())
            .andExpect(content().string(helloString));
  }

  @Test
  public void hello_eunji가_리턴된다() throws Exception {
    String helloEunji = "helloEunji";

    mvc.perform(get("/hello-eunji").param("name", helloEunji))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.name", is(helloEunji)));
  }
}
