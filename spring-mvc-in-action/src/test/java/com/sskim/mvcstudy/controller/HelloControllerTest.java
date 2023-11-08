package com.sskim.mvcstudy.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author sskim
 */
@WebMvcTest
class HelloControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void GET_요청_테스트() throws Exception{
        mockMvc.perform(
                get("/hello")
                        .param("username", "sskim")
                        .param("age", "31")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE))
                .andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    void POST_요청_테스트() throws Exception{

        mockMvc.perform(
                post("/hello")
                        .param("username", "sskim")
                        .param("age", "31")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE))
                .andDo(print())
                .andExpect(status().isOk());

    }
}