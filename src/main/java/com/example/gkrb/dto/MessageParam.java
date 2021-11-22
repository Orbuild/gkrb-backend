package com.example.gkrb.dto;

import lombok.Data;

import java.util.Date;

@Data
public class MessageParam {

    private String userId;

    private String timestamp;

    private String title;

    private String content;

    private String pictures;

    private Integer likes;

    private String[] tags;

}
