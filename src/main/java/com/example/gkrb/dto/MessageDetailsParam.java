package com.example.gkrb.dto;

import com.example.gkrb.model.Comment;
import com.example.gkrb.model.User;
import lombok.Data;

import java.util.List;

@Data
public class MessageDetailsParam {

    private int messageId;

    private String timestamp;

    private String title;

    private String content;

    private String[] pictures;

    private int likes;

    // 消息发布者个人信息
    private UserInfoParam userInfoParam;

    // 消息对应的tag列表
    private String[] tagValues;

    // 消息的评论
    private List<CommentDetailsParam> commentDetailsList;

}
