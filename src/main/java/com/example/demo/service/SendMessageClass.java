package com.example.demo.service;

import com.example.demo.config.Configuration;
import com.example.demo.entity.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

@Component
public class SendMessageClass {
    @Autowired
    Configuration configuration;
    private static final Logger logger = LoggerFactory.getLogger(SendMessageClass.class);

    //Обработка полученного сообщения и отправка ответа
    public void sendMessage(Data data) {

        RestTemplate restTemplate = new RestTemplate();

        Random random = new Random();
        int rand_id = random.nextInt(10000);

        String tokenAccess = configuration.getTokenAccess();
        //Получаем id отправителя
        Long userId = data.getObjectData().getMessage().getFrom_id();
        // Создаем переменную, которая хранит ответ от бота
        String message = "Вы сказали: " + data.getObjectData().getMessage().getText();
        // Формируем url для отправки ответа
        String url = "https://api.vk.com/method/messages.send?access_token=" + tokenAccess +
                "&user_id=" + userId +
                "&random_id=" + rand_id +
                "&message=" + message +
                "&v=5.236";
        //Отправляем запрос на сервер Vk и получаем ответ
        logger.info("The answer was sent to the address - "+url);
        String response = restTemplate.postForObject(url,new HttpEntity<>(""), String.class);
        logger.info("We received a response" + response);
    }
}
