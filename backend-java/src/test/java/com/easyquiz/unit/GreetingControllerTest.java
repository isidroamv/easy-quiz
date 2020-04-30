package com.easyquiz.unit;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.assertj.core.api.Assertions.assertThat;

import com.easyquiz.controller.GreetingController;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class GreetingControllerTest {
    
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private GreetingController controller;

    @Test 
    public void contextLoads() throws Exception {
        assertThat(controller).isNotNull();
    }

    @Test
    public void getGreeting() throws Exception {
        this.mockMvc.perform(get("/greeting")).andDo(print())
                    .andExpect(status().isOk())
                    .andExpect(content().string(containsString("{\"id\":1,\"content\":\"Hello, World!\"}")));
    }

    @Test
    public void getGreetingCustomName() throws Exception {
        this.mockMvc.perform(get("/greeting?name=Israel")).andDo(print())
                    .andExpect(status().isOk())
                    .andExpect(content().string(containsString("{\"id\":2,\"content\":\"Hello, Israel!\"}")));
    }
}