package com.example.gkrb.service.impl;

import com.example.gkrb.dto.MessageDetailsParam;
import com.example.gkrb.dto.MessageParam;
import com.example.gkrb.dto.UserInfoParam;
import com.example.gkrb.dto.UserLoginParam;
import com.example.gkrb.mapper.MTMapper;
import com.example.gkrb.mapper.MessageMapper;
import com.example.gkrb.mapper.TagMapper;
import com.example.gkrb.mapper.UserMapper;
import com.example.gkrb.model.MT;
import com.example.gkrb.model.Message;
import com.example.gkrb.model.Tag;
import com.example.gkrb.model.User;
import com.example.gkrb.service.*;
import com.example.gkrb.utils.StringUtil;
import com.example.gkrb.utils.TimeUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.SneakyThrows;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageMapper messageMapper;

    @Autowired
    private TagMapper tagMapper;

    @Autowired
    private MTMapper mtMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private TagService tagService;

    @Autowired
    private MTService mtService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private UserService userService;

    // 添加消息
    // @Transactional
    public void create(MessageParam messageParam) throws ParseException {
        Message message = new Message();
        BeanUtils.copyProperties(messageParam, message);

        message.setTimestamp(TimeUtil.StringToDate(messageParam.getTimestamp()));

        message.setPictures(StringUtil.ArrayToString(messageParam.getPictures()));

        messageMapper.insertSelective(message);
        System.out.println(message);

        int tagId;

        // 将message中的标签写入tag表，并将message和tag的对应关系写入mt表
        for(String tagValue : messageParam.getTags()) {
            tagId = tagService.insert(tagValue);

            MT mt = new MT();
            mt.setMessageId(message.getMessageId());
            mt.setTagId(tagId);
            mtService.insert(mt);
        }

    }

    // 根据消息ID获取消息的详细信息
    // @Transactional
    public MessageDetailsParam getMessageDetailsByMessageId(int messageId) {
        MessageDetailsParam messageDetailsParam = new MessageDetailsParam();

        Message message = messageMapper.selectByPrimaryKey(messageId);
        BeanUtils.copyProperties(message, messageDetailsParam);

        // 发布时间date转string
        messageDetailsParam.setTimestamp(TimeUtil.DateToString(message.getTimestamp()));

        // 设置pictures
        messageDetailsParam.setPictures(StringUtil.StringToArray(message.getPictures()));

        // 获取消息发布者的个人信息
        messageDetailsParam.setUserInfoParam(userService.getUserInfoByUserId(message.getUserId()));

        // 获取消息对应的tag列表
        List<MT> mtList = mtService.getMTByMessageId(message.getMessageId());

        // 获取评论列表
        messageDetailsParam.setCommentDetailsList(commentService.getCommentDetailsByMessageId(messageId));

        List<String> tagValues = new ArrayList<>();

        for(MT mt : mtList) {
            tagValues.add(tagService.getTagByTagId(mt.getTagId()).getValue());
        }

        messageDetailsParam.setTagValues(tagValues.toArray(new String[0]));

        return  messageDetailsParam;
    }

    // 获取消息列表
    // @Transactional
    public PageInfo<MessageDetailsParam> getMessages(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);

        List<MessageDetailsParam> messageDetailsList = new ArrayList<>();

        List<Message> messageList = messageMapper.selectAllMessages();

        for(Message message : messageList) {
            messageDetailsList.add(getMessageDetailsByMessageId(message.getMessageId()));
        }

        return new PageInfo<>(messageDetailsList);
    }

    // @Transactional
    public PageInfo<MessageDetailsParam> getMessagesByTags(List<String> tagValues, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);

        List<MessageDetailsParam> messageDetailsList = new ArrayList<>();

        List<Integer> messageIdList = new ArrayList<>();

        // messageId可能存在重复
        for(String value : tagValues) {
            Tag tag = tagMapper.selectByTagValue(value);
            List<MT> mtList = mtMapper.getMtByTagId(tag.getTagId());

            for(MT mt : mtList) {
                messageIdList.add(mt.getMessageId());
            }
        }

        // 去重
        Set<Integer> set = new HashSet<>(messageIdList);
        List<Integer> newMessageIdList = new ArrayList<>(set);

        for(int messageId : newMessageIdList) {
            messageDetailsList.add(getMessageDetailsByMessageId(messageId));
        }

        // 按照消息发布时间降序排序
        Collections.sort(messageDetailsList, new Comparator<MessageDetailsParam>() {
            @SneakyThrows
            @Override
            public int compare(MessageDetailsParam m1, MessageDetailsParam m2) {
                return TimeUtil.StringToDate(m2.getTimestamp()).compareTo(TimeUtil.StringToDate(m1.getTimestamp()));
            }
        });

        return new PageInfo<>(messageDetailsList);
    }

    public void delete(int messageId) {
        messageMapper.deleteByPrimaryKey(messageId);
    }


}
