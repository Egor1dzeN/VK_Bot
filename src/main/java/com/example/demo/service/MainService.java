package com.example.demo.service;

import com.example.demo.config.Configuration;
import com.example.demo.entity.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

@Service
public class MainService {
    @Autowired
    Configuration configuration;

    public String RequestProcessing(Data data) {
        if (data.getType().equals("confirmation")) {
            System.out.println("confirmation");
            return configuration.getTokenConfirmation();
        } else if (data.getType().equals("message_new")){
            System.out.println(data);
            sendMessage(data);
        }
        return "ok";
    }

    public void sendMessage(Data data) {
        RestTemplate restTemplate = new RestTemplate();
        Random random = new Random();
        int rand_id = random.nextInt(10000);

        String tokenAccess = configuration.getTokenAccess();
        Long userId = data.getObjectData().getMessage().getFrom_id();
//        System.out.println(userId);
        String message = "Вы сказали: "+ data.getObjectData().getMessage().getText();
        String url = "https://api.vk.com/method/messages.send?access_token=" + tokenAccess +
                "&user_id=" + userId +
                "&random_id=" + rand_id +
                "&message=" + message+
                "&v=5.236";
        HttpEntity<String> request = new HttpEntity<>("");
        String response = restTemplate.postForObject(url, request, String.class);
        System.out.println(response);
    }
}
