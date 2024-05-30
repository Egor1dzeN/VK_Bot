package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

@lombok.Data
public class Data {
    private String type;
    @JsonProperty("object")
    private ObjectData objectData;
    private Long group_id;

    @Override
    public String toString() {
        return "Data{" +
                "type='" + type + '\'' +
                ", objectData=" + objectData +
                ", group_id=" + group_id +
                '}';
    }
}