package com.example.gkrb.service.impl;

import com.example.gkrb.dto.CommentDetailsParam;
import com.example.gkrb.dto.CommentParam;
import com.example.gkrb.dto.UserInfoParam;
import com.example.gkrb.mapper.CommentMapper;
import com.example.gkrb.mapper.UserMapper;
import com.example.gkrb.model.Comment;
import com.example.gkrb.model.User;
import com.example.gkrb.service.CommentService;
import com.example.gkrb.service.UserService;
import com.example.gkrb.utils.TimeUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    // @Transactional
    public List<CommentDetailsParam> getCommentDetailsByMessageId(int messageId) {
        List<Comment> commentList = commentMapper.getCommentsByMessageId(messageId);

        List<CommentDetailsParam> commentDetailsList = new ArrayList<>();

        for(Comment comment : commentList) {
            CommentDetailsParam commentDetailsParam = new CommentDetailsParam();
            BeanUtils.copyProperties(comment, commentDetailsParam);

            commentDetailsParam.setTimestamp(TimeUtil.DateToString(comment.getTimestamp()));

            // 获取评论者个人信息
            commentDetailsParam.setUserInfoParam(userService.getUserInfoByUserId(comment.getUserId()));

            commentDetailsList.add(commentDetailsParam);
        }

        return commentDetailsList;
    }

    public void create(CommentParam commentParam) throws ParseException {
        Comment comment = new Comment();
        BeanUtils.copyProperties(commentParam, comment);

        comment.setTimestamp(TimeUtil.StringToDate(commentParam.getTimestamp()));

        commentMapper.insertSelective(comment);
    }

    public void delete(int commentId) {
        commentMapper.deleteByPrimaryKey(commentId);
    }

}
