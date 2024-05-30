package com.example.demo.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class Configuration {
    @Value("${string.token.access}")
    private String tokenAccess;
    @Value("${string.token.confirmation}")
    private String tokenConfirmation;
    @Value("${string.secret.key}")
    private String secretKey;
}
