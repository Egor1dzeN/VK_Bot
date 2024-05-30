package com.example.demo.service;

import com.example.demo.config.Configuration;
import com.example.demo.config.TypeData;
import com.example.demo.entity.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MainService {
    @Autowired
    Configuration configuration;
    public String RequestProcessing(Data data) {
        if (data.getType().equals("confirmation")){
            System.out.println("confirmation");
            return configuration.getTokenConfirmation();
        }
        return "ok";
    }
}
