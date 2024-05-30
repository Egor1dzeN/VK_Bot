package com.example.demo.service;

import com.example.demo.config.Configuration;
import com.example.demo.config.TypeData;
import com.example.demo.entity.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MainService {
    @Autowired
    Configuration configuration;

    public String RequestProcessing(Data data) {
        if (data.getType().equals("confirmation")) {
            System.out.println("confirmation");
            return configuration.getTokenConfirmation();
        }
        sendMessage();
        return "ok";
    }

    public void sendMessage() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://api.vk.com/method/messages.send?access_token="+configuration.getTokenAccess()+"&user_id=224004251&random_id=0&message=text&v=5.236";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Создание тела запроса
        String jsonBody = "{\"key1\":\"value1\", \"key2\":\"value2\"}";

        // Оберните тело и заголовки запроса в HttpEntity
        HttpEntity<String> request = new HttpEntity<>(jsonBody, headers);

        // Отправьте POST запрос
        String response = restTemplate.postForObject(url, request, String.class);

        // Обработайте ответ
        System.out.println(response);
    }
}
