package com.example.gkrb.controller;

import com.example.gkrb.dto.UserInfoParam;
import com.example.gkrb.dto.UserLoginParam;
import com.example.gkrb.dto.UserRegisterParam;
import com.example.gkrb.dto.response.BaseResponse;
import com.example.gkrb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public BaseResponse<Integer> register(@RequestBody UserRegisterParam userRegisterParam) throws ParseException {
        int insertState = userService.insert(userRegisterParam);
        if(insertState == 1) {
            return BaseResponse.success("Register successfully", 1);
        }
        return BaseResponse.error("The email has already been registered.", 0);
    }

    @GetMapping("/login")
    public BaseResponse<Integer> login(@RequestBody UserLoginParam userLoginParam) {
        int loginState = userService.checkUser(userLoginParam);
        if(loginState == -1) {
            return BaseResponse.error("The email is incorrect.", -1);
        }
        else if (loginState == 0) {
            return BaseResponse.error("The password is incorrect.", 0);
        }
        return BaseResponse.success("Login successfully", 1);
    }

    @GetMapping("/getUserInfo")
    public BaseResponse<UserInfoParam> getUserInfo(@RequestParam String userId) {
        return BaseResponse.success("Get userinfo successfully", userService.getUserInfoByUserId(userId));
    }





}
