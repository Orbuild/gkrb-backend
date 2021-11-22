package com.example.gkrb.service.impl;

import com.example.gkrb.dto.UserLoginParam;
import com.example.gkrb.dto.UserRegisterParam;
import com.example.gkrb.mapper.UserMapper;
import com.example.gkrb.model.User;
import com.example.gkrb.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    public int insert(UserRegisterParam userRegisterParam) throws ParseException {
        User user = new User();
        BeanUtils.copyProperties(userRegisterParam, user);

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        user.setRegisterTime(formatter.parse(userRegisterParam.getRegisterTime()));

        // 用户已经存在
        if(getUserById(user.getUserId()) != null) {
            return 0;
        }
        userMapper.insertSelective(user);
        return 1;
    }

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

    public User getUserById(String userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

}
