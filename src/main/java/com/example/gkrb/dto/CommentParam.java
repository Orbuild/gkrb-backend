package com.example.gkrb.dto;

import lombok.Data;

@Data
public class CommentParam {

    private String userId;

    private String content;

    private String timestamp;

    private int messageId;

}
