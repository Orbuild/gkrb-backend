package com.example.gkrb.service.impl;

import com.example.gkrb.dto.CommentDetailsParam;
import com.example.gkrb.dto.UserInfoParam;
import com.example.gkrb.mapper.CommentMapper;
import com.example.gkrb.mapper.UserMapper;
import com.example.gkrb.model.Comment;
import com.example.gkrb.model.User;
import com.example.gkrb.service.CommentService;
import com.example.gkrb.utils.TimeUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private UserMapper userMapper;

    public List<CommentDetailsParam> getCommentDetailsByMessageId(int messageId) {
        List<Comment> commentList = commentMapper.getCommentsByMessageId(messageId);

        List<CommentDetailsParam> commentDetailsList = new ArrayList<>();

        for(Comment comment : commentList) {
            CommentDetailsParam commentDetailsParam = new CommentDetailsParam();
            BeanUtils.copyProperties(comment, commentDetailsParam);

            commentDetailsParam.setTimestamp(TimeUtil.DateToString(comment.getTimestamp()));

            User user = userMapper.selectByPrimaryKey(comment.getUserId());
            UserInfoParam userInfoParam = new UserInfoParam();
            BeanUtils.copyProperties(user, userInfoParam);
            userInfoParam.setRegisterTime(TimeUtil.DateToString(user.getRegisterTime()));

            commentDetailsParam.setUserInfoParam(userInfoParam);

            commentDetailsList.add(commentDetailsParam);
        }

        return commentDetailsList;
    }

}
