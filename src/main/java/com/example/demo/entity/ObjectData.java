package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ObjectData {
    @JsonProperty("message")
    private Message message;

    @Override
    public String toString() {
        return "ObjectData{" +
                "message=" + message +
                '}';
    }
}
