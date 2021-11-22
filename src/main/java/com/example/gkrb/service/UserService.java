package com.example.gkrb.service;

import com.example.gkrb.dto.UserLoginParam;
import com.example.gkrb.dto.UserRegisterParam;

import java.text.ParseException;

public interface UserService {

    int insert(UserRegisterParam userRegisterParam) throws ParseException;

    int checkUser(UserLoginParam userLoginParam);

}
