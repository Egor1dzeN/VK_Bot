package com.example.demo.entity;

import lombok.Data;

@Data
public class Message {
    Long id;
    Long peer_id;
    Long from_id;
    Long random_id;
    String text;

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", peer_id=" + peer_id +
                ", from_id=" + from_id +
                ", random_id=" + random_id +
                ", text='" + text + '\'' +
                '}';
    }
}
