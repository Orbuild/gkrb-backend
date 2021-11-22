package com.example.gkrb.service.impl;

import com.example.gkrb.dto.MessageParam;
import com.example.gkrb.mapper.MessageMapper;
import com.example.gkrb.model.MT;
import com.example.gkrb.model.Message;
import com.example.gkrb.service.MTService;
import com.example.gkrb.service.MessageService;
import com.example.gkrb.service.TagService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageMapper messageMapper;

    @Autowired
    private TagService tagService;

    @Autowired
    private MTService mtService;

    public void create(MessageParam messageParam) throws ParseException {
        Message message = new Message();
        BeanUtils.copyProperties(messageParam, message);

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        message.setTimestamp(formatter.parse(messageParam.getTimestamp()));

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
}
