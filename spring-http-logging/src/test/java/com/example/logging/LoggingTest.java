package com.example.logging;

import com.example.logging.domain.Person;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author sskim
 */
@Slf4j
@WebMvcTest
public class LoggingTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    @DisplayName("GET 요청 RequestWrapper없이")
    void GET_WITHOUT_REQUEST_WRAPPER() throws Exception {
        mockMvc.perform(get("/hello")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    @DisplayName("POST 요청 RequestWrapper없이")
    void POST_WITHOUT_REQUEST_WRAPPER() throws Exception {

        String valueAsString = objectMapper.writeValueAsString(new Person("1", "test"));

        mockMvc.perform(post("/json")
                        .content(valueAsString)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andDo(print());
    }
}
