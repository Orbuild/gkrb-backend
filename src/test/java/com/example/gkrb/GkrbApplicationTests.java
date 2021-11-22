package com.example.gkrb;

import com.example.gkrb.dto.UserRegisterParam;
import com.example.gkrb.mapper.UserMapper;
import com.example.gkrb.service.UserService;
import com.example.gkrb.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
class GkrbApplicationTests {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {
    }

    @Test
    void test1() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        UserRegisterParam userRegisterParam = new UserRegisterParam();
        userRegisterParam.setRegisterTime("2011-11-11 11:11:11");
        userRegisterParam.setName("222");
        userRegisterParam.setPassword("333");
        userRegisterParam.setUserId("222qq.com");
        int insertState = userService.insert(userRegisterParam);
        System.out.println("insert state: " + insertState);
    }

    @Test
    void test2() {
        System.out.println(userMapper.selectByPrimaryKey("111qq.com"));
        System.out.println(userMapper.selectByPrimaryKey("111qq.com") != null);
    }

}
