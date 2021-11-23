package com.example.gkrb.dto;

import com.example.gkrb.model.User;
import lombok.Data;

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

}
