package com.main.application.controllers.item;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;
    
    @Test
    public void getAllItems() throws Exception{

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/item"))
                        .andExpect(status().isOk());

    }

    @Test
    public void getAllItems_ex() throws Exception{

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/items"))
                        .andExpect(status().isNotFound());

    }
}
