package com.example.gkrb.model;

import lombok.Data;

import java.util.Date;

@Data
public class User {

    private String userId;

    private String password;

    private String avatar;

    private String name;

    private Date registerTime;

    private String gender;

    private String studentId;

    private String trainingUnit;

    private String major;

    private String academy;

    private String classNum;

    private Integer level;

    private Integer identity;

}