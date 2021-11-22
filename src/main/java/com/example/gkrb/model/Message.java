package com.example.gkrb.model;

import lombok.Data;

import java.util.Date;

@Data
public class Message {

    private Integer messageId;

    private String userId;

    private Date timestamp;

    private String title;

    private String content;

    private String pictures;

    private Integer likes;

}