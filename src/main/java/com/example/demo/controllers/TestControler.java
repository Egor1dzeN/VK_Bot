package com.example.demo.controllers;

import com.example.demo.entity.Data;
import com.example.demo.service.MainService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestControler {
    @Autowired
    MainService mainService;
    private static final Logger logger = LoggerFactory.getLogger(TestControler.class);

    @PostMapping("/")
    public String main_test(@RequestBody Data data) {
        logger.info("Incoming message:"+ data);
        return mainService.RequestProcessing(data);
    }
}
