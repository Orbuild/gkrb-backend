package com.example.gkrb.dto;

import lombok.Data;

import java.util.Date;

@Data
public class UserRegisterParam {

    private String userId;

    private String password;

    private String registerTime;

    private String name;

}
