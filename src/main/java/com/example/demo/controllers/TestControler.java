package com.example.demo.controllers;

import com.example.demo.entity.Data;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestControler {

    @GetMapping("/")
    public String main(@RequestBody Data data){
        System.out.println(data);
//        System.out.println();
        return "Helol";
    }
}
