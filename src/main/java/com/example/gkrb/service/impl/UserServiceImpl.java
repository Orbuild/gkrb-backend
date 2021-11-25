package com.example.gkrb.service.impl;

import com.example.gkrb.dto.UserInfoParam;
import com.example.gkrb.dto.UserLoginParam;
import com.example.gkrb.dto.UserRegisterParam;
import com.example.gkrb.mapper.UserMapper;
import com.example.gkrb.model.User;
import com.example.gkrb.service.TagService;
import com.example.gkrb.service.UserService;
import com.example.gkrb.utils.TimeUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Transactional
    public int insert(UserRegisterParam userRegisterParam) throws ParseException {
        User user = new User();
        BeanUtils.copyProperties(userRegisterParam, user);

        user.setRegisterTime(TimeUtil.StringToDate(userRegisterParam.getRegisterTime()));

        // 用户已经存在
        if(getUserById(user.getUserId()) != null) {
            return 0;
        }
        userMapper.insertSelective(user);
        return 1;
    }

    @Transactional
    public int checkUser(UserLoginParam userLoginParam) {
        User user = getUserById(userLoginParam.getUserId());
        if(user == null) {
            return -1;
        }
        else if(!user.getPassword().equals(userLoginParam.getPassword())) {
            return 0;
        }
        return 1;
    }

    @Transactional
    public User getUserById(String userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    @Transactional
    public UserInfoParam getUserInfoByUserId(String userId) {
        User user = userMapper.selectByPrimaryKey(userId);

        UserInfoParam userInfoParam = new UserInfoParam();
        BeanUtils.copyProperties(user, userInfoParam);

        userInfoParam.setRegisterTime(TimeUtil.DateToString(user.getRegisterTime()));

        return userInfoParam;
    }

}
