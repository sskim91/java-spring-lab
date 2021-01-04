package com.sskim.mvcstudy.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author sskim
 */
@WebMvcTest
class SampleControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void mvcTest() throws Exception {
        mockMvc.perform(
                get("/event"))
                .andDo(print())
                .andExpect(status().isOk())
        ;
    }

    @Test
    void consumesTest() throws Exception {
        mockMvc.perform(
                get("/consumes")
                        .contentType(MediaType.TEXT_PLAIN_VALUE))
                .andDo(print())
                .andExpect(status().isOk())
        ;
    }

    @Test
    void producesTest() throws Exception {
        mockMvc.perform(
                get("/produces")
                        .accept(MediaType.TEXT_PLAIN_VALUE))
                .andDo(print())
                .andExpect(status().isOk())
        ;
    }
}