package com.sh.controller;

import com.sh.HelloWordServiceApplicationTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class HelloWordControllerTest extends HelloWordServiceApplicationTests {
    @InjectMocks
    private HelloWordController helloWordController;
    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;
    private String name="Seher";
    @BeforeEach
    public void setup(){
        mockMvc= MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void Should_ReturnHelloWord_when_passingValidParameters() throws Exception {
        mockMvc.perform(get("/service/hello/{name}", name)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string(containsString(name)));
        String result=helloWordController.getHelloWord(name);
        Assertions.assertTrue(result.contains(name));
    }
}
