package com.example.gkrb.dto;

import lombok.Data;

import java.util.Date;

@Data
public class UserInfoParam {

    private String userId;

    private String password;

    private String avatar;

    private String name;

    private String registerTime;    // 类型是string，User类是Date类型

    private String gender;

    private String studentId;

    private String trainingUnit;

    private String major;

    private String academy;

    private String classNum;

    private int level;

    private int identity;

}
