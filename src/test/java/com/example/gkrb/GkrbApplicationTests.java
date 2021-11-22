package com.example.gkrb;

import com.example.gkrb.dto.MessageParam;
import com.example.gkrb.dto.UserRegisterParam;
import com.example.gkrb.mapper.UserMapper;
import com.example.gkrb.model.Message;
import com.example.gkrb.service.TagService;
import com.example.gkrb.service.UserService;
import com.example.gkrb.service.impl.MessageServiceImpl;
import com.example.gkrb.service.impl.TagServiceImpl;
import com.example.gkrb.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
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

    @Autowired
    private MessageServiceImpl messageService;

    @Autowired
    private TagService tagService;

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

    @Test
    void test3() throws ParseException {
        MessageParam messageParam = new MessageParam();
        messageParam.setUserId("111qq.com");
        messageParam.setTimestamp("2011-11-11 11:11:11");
        messageParam.setTitle("333");
        messageParam.setContent("444");
        messageParam.setPictures("555");
        messageParam.setLikes(6);
        String[] s = {"111", "篮球", "222"};
        messageParam.setTags(s);

        messageService.create(messageParam);


    }

    @Test
    void test4() {
        tagService.insert("篮球");
    }

}
