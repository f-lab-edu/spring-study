package com.hello.springstudy.api.controller;

import com.hello.springstudy.api.dto.HelloResponseDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class HelloControllerTest {

  @Autowired
  private MockMvc mvc;

  @Test
  @DisplayName("eunjiA_API_호출_성공")
  public void callApiEunjiA() throws Exception {
    String status = "OK";
    String name = "eunjiA";

    mvc.perform(get("/hello-eunjiA"))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.status", is(status)))
            .andExpect(jsonPath("$.data.name", is(name)));
  }

  @Test
  @DisplayName("eunjiB_API_호출_성공")
  public void callApiEunjiB() throws Exception {
    String status = "OK";
    String name = "eunjiB";

    mvc.perform(get("/hello-eunjiB"))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.status", is(status)))
            .andExpect(jsonPath("$.data.name", is(name)));
  }

  @Test
  @DisplayName("HelloResponseDto_builder_사용")
  public void useBuilder() {
    Long id = 3L;
    String name = "dev";
    String role = "DEV";

    HelloResponseDto helloResponseDto = HelloResponseDto.builder()
            .id(id)
            .name(name)
            .role(role)
            .build();

    assertThat(helloResponseDto.getId()).isEqualTo(id);
    assertThat(helloResponseDto.getName()).isEqualTo(name);
    assertThat(helloResponseDto.getRole()).isEqualTo(role);
  }

  @Test
  @DisplayName("eunjiC_API_호출_예외")
  public void callApiEunjiC() throws Exception {
    assertThatThrownBy(() -> mvc.perform(get("/hello-eunjiC"))
            .andExpect(status().isOk()))
            .hasCause(new IllegalArgumentException("id must not be null"));
  }

  @Test
  @DisplayName("eunjiD_API_호출_예외")
  public void callApiEunjiD() throws Exception {
    assertThatThrownBy(() -> mvc.perform(get("/hello-eunjiD"))
            .andExpect(status().isCreated()))
            .hasCause(new IllegalArgumentException("name must not be null"));
  }
}