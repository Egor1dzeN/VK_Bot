package com.example.demo;

import com.example.demo.entity.Data;
import com.example.demo.entity.Message;
import com.example.demo.entity.ObjectData;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class VkBotTestTaskApplicationTests {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testControllerIsOkConf() throws Exception {
        Data testData = new Data();
        testData.setType("confirmation");
        String jsonTestData = objectMapper.writeValueAsString(testData);
        mockMvc.perform(MockMvcRequestBuilders.post("/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonTestData)).andExpect(status().isOk());
    }
    @Test
    public void testControllerIsOkMes() throws Exception {
        Data testData = new Data();
        testData.setType("message_new");
        ObjectData objectData = new ObjectData();
        objectData.setMessage(new Message());
        testData.setObjectData(objectData);
        String jsonTestData = objectMapper.writeValueAsString(testData);
        mockMvc.perform(MockMvcRequestBuilders.post("/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonTestData))
                .andExpect(status().isOk())
                .andExpect(content().string("ok"));
    }


}
