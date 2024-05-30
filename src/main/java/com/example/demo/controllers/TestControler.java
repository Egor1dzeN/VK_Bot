package com.example.demo.controllers;

import com.example.demo.entity.Data;
import com.example.demo.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestControler {
    @Autowired
    MainService mainService;

    @GetMapping("/")
    public String main_test(@RequestBody Data data){
        mainService.RequestProcessing(data);
//        System.out.println();
        return "Helol";
    }
}
