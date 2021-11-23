package com.example.gkrb.dto;

import lombok.Data;

import java.util.Date;

@Data
public class CommentDetailsParam {

    private int commentId;

    private String timestamp;

    private int messageId;

    private String content;

    // 评论者的个人信息
    private UserInfoParam userInfoParam;

}
