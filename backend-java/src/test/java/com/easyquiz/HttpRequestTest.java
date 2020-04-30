package com.easyquiz;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HttpRequestTest {
    
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    private String url = "http://localhost:";

    @Test
    public void homeShouldReturnDefaultMessage() throws Exception {
        assertThat(this.restTemplate.getForObject(url + port + "/", String.class))
            .contains("Greetings from Spring Boot!");
    }

    @Test
    public void greetingShouldReturnDefaultMessage() throws Exception {
        assertThat(this.restTemplate.getForObject(url + port + "/greeting/", String.class))
            .contains("{\"id\":1,\"content\":\"Hello, World!\"}");
    }
}