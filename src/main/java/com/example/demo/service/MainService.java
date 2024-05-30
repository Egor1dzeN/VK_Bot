package com.example.demo.service;

import com.example.demo.config.Configuration;
import com.example.demo.entity.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MainService {
    @Autowired
    Configuration configuration;

    @Autowired
    SendMessageClass sendMessage;

    private static final Logger logger = LoggerFactory.getLogger(MainService.class);

    //Обрабатывает json-объект полученный на сервер от ВК
    public String RequestProcessing(Data data) {
        // Подтверждение сервера
        if (data.getType().equals("confirmation")) {
            logger.info("We received a confirmation request");
            return configuration.getTokenConfirmation();

        }
        //Получение нового сообщения от пользователя
        else if (data.getType().equals("message_new")) {
            //Обработка сообщения
            sendMessage.sendMessage(data);
        }
        return "ok";
    }
}
