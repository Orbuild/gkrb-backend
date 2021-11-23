package com.example.gkrb;

import com.example.gkrb.dto.MessageParam;
import com.example.gkrb.dto.UserLoginParam;
import com.example.gkrb.dto.UserRegisterParam;
import com.example.gkrb.mapper.UserMapper;
import com.example.gkrb.model.MT;
import com.example.gkrb.model.Message;
import com.example.gkrb.service.MTService;
import com.example.gkrb.service.TagService;
import com.example.gkrb.service.UserService;
import com.example.gkrb.service.impl.MessageServiceImpl;
import com.example.gkrb.service.impl.TagServiceImpl;
import com.example.gkrb.service.impl.UserServiceImpl;
import com.example.gkrb.utils.StringUtil;
import com.example.gkrb.utils.TimeUtil;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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

    @Autowired
    private MTService mtService;

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
        String[] pictures = {"http:11", "http:22"};
        messageParam.setPictures(pictures);
        System.out.println(Arrays.toString(pictures));
        messageParam.setLikes(6);
        String[] s = {"111", "篮球", "222"};
        messageParam.setTags(s);

        messageService.create(messageParam);


    }

    @Test
    void test4() {
        tagService.insert("篮球");
    }

    @Test
    void test5() {
        List<MT> list = mtService.getMTByMessageId(6);
        System.out.println(list.toString());
    }

    @Test
    void test6() {
        List<String> list = new ArrayList<>();
        list.add("111");
        list.add("222");
        String[] s = list.toArray(new String[0]);
        System.out.println(Arrays.toString(s));

    }

    @Test
    void test7() {
        System.out.println(messageService.getMessages(1, 10));
    }

    @Test
    void test8() {
        String[] pictures = {"http:11", "http:22"};
        String s = Arrays.toString(pictures);
        s = s.replace("[", "").replace("]", "").replace(" ", "");
        String[] a = s.split(",");
        System.out.println(a.length + " " + a[0] + " " + a[1]);
        System.out.println(s);
    }

    @Test
    void test9() {
        List<String> list = new ArrayList<>();
        list.add("111");
        list.add("222");
        list.add("111");
        System.out.println(list.toString());
        Set<String> set = new HashSet<>(list);
        List<String> list2 = new ArrayList<>(set);
        System.out.println(list2.toString());
        //System.out.println(messageService.getMessagesByTags(list, 1, 10));
    }

    @Test
    void test10() {
        List<UserLoginParam> list = new ArrayList<>();

        UserLoginParam userLoginParam1 = new UserLoginParam();
        userLoginParam1.setUserId("2011-11-9 11:11:11");
        UserLoginParam userLoginParam2 = new UserLoginParam();
        userLoginParam2.setUserId("2011-11-11 11:11:11");
        UserLoginParam userLoginParam3 = new UserLoginParam();
        userLoginParam3.setUserId("2011-11-14 11:11:11");

        list.add(userLoginParam1);
        list.add(userLoginParam2);
        list.add(userLoginParam3);

        System.out.println(list.toString());

        Collections.sort(list, new Comparator<UserLoginParam>() {
            @SneakyThrows
            @Override
            public int compare(UserLoginParam o1, UserLoginParam o2) {
                return TimeUtil.StringToDate(o2.getUserId()).compareTo(TimeUtil.StringToDate(o1.getUserId()));
            }
        });

        System.out.println(list.toString());

    }

}
