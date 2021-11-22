package com.example.gkrb.model;

import lombok.Data;

import java.util.Date;

@Data
public class Comment {

    private Integer commentId;

    private String userId;

    private Date timestamp;

    private Integer messageId;

    private String content;

}