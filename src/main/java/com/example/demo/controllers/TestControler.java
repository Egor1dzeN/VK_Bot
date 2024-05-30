package com.example.demo.controllers;

import com.example.demo.entity.Data;
import com.example.demo.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestControler {
    @Autowired
    MainService mainService;

    @PostMapping("/")
    public String main_test(@RequestBody Data data) {
        System.out.println(data);
//        System.out.println();
        return mainService.RequestProcessing(data);
    }
}
