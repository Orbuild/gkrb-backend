package com.example.gkrb.service;

import com.example.gkrb.dto.MessageDetailsParam;
import com.example.gkrb.dto.MessageParam;
import com.github.pagehelper.PageInfo;

import java.text.ParseException;
import java.util.List;

public interface MessageService {

    void create(MessageParam messageParam) throws ParseException;

    PageInfo<MessageDetailsParam> getMessages(int pageNum, int pageSize);

    public PageInfo<MessageDetailsParam> getMessagesByTags(List<String> tagValues, int pageNum, int pageSize);

}
