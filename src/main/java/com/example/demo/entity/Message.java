package com.example.demo.entity;

import lombok.Data;

@Data
public class Message {
    Long id;
    String text;

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", text='" + text + '\'' +
                '}';
    }
}
